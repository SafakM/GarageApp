package com.smkizilirmak.garage.service.impl;

import com.smkizilirmak.garage.domain.Ticket;
import com.smkizilirmak.garage.domain.Vehicle;
import com.smkizilirmak.garage.dto.ParkingDto;
import com.smkizilirmak.garage.exception.GarageApiException;
import com.smkizilirmak.garage.service.api.GarageService;
import com.smkizilirmak.garage.util.VehicleFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GarageServiceImpl implements GarageService {

    static List<Ticket> tickets = new ArrayList<>();
    static Hashtable<Integer, Boolean> garage = new Hashtable<Integer, Boolean>() {{
        put(10, true);
        put(9, true);
        put(8, true);
        put(7, true);
        put(6, true);
        put(5, true);
        put(4, true);
        put(3, true);
        put(2, true);
        put(1, true);
    }};

    @Override
    public String startParking(ParkingDto parkingDto) {
            int startedSlot = findParkingSlotStart(parkingDto.getVehicleType());
            if(startedSlot != 0) {
                Vehicle vehicle = VehicleFactory.createVehicle(parkingDto.getPlate(), parkingDto.getColor(), parkingDto.getVehicleType(), startedSlot);
                Ticket ticket = new Ticket(vehicle);
                tickets.add(ticket);
                setParkingSlots(vehicle.getHoldingSlots(), false);
                return ticket.getTicketNumber();
            }
            else {
                throw new GarageApiException("Park yeri bulunamadı",HttpStatus.NOT_FOUND,"Park yeri bulunamadı");
                //return "Parklanma basarisiz";
            }

    }

    @Override
    public void endParking(String ticketNumber) {
        Optional<Ticket> ticket = tickets.stream().filter(f -> f.getTicketNumber().equals(ticketNumber)).findFirst();
        if(ticket.isPresent()) {
            setParkingSlots(ticket.get().getVehicle().getHoldingSlots(), true);
            tickets.remove(ticket.get());
        }
        else{
            throw new GarageApiException("Gecersiz bilet",HttpStatus.NOT_FOUND,"Gecersiz Bilet Verdiniz");
        }
    }

    @Override
    public List<String> parkingVehicles() {
        List<String> parkingList = new ArrayList<>();
        tickets.forEach(f -> parkingList.add(f.getVehicle().toString() + " - " + f.getTicketNumber()));
        return parkingList;
    }

    @Override
    public Hashtable<Integer, Boolean> garageStatus(){
        return garage;
    }

    private void setParkingSlots(List<Integer> holdingSlots, Boolean status) {
        holdingSlots.forEach(f-> garage.put(f, status));
    }


    private int findParkingSlotStart(String vehicleType) {
        List<Integer> emptyGarageSlots = garage.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        emptyGarageSlots = emptyGarageSlots.stream().sorted().collect(Collectors.toList());
        if(!emptyGarageSlots.isEmpty()) {
            if(vehicleType.equals("Car")) {
                return  emptyGarageSlots.stream().findFirst().get();
            }
            if(emptyGarageSlots.size() >= 2 && vehicleType.equals("Jeep")) {
                return findGarageSuitableSlot(emptyGarageSlots, 1);
            }
            if(emptyGarageSlots.size() >= 4 && vehicleType.equals("Truck")) {
                return findGarageSuitableSlot(emptyGarageSlots, 3);
            }
        }
        return 0;
    }

    private int findGarageSuitableSlot(List<Integer> emptyGarageSlots, int requiredExtraSlot) {
        for(int i = 0; i < emptyGarageSlots.size(); i++) {
            if(i + requiredExtraSlot < emptyGarageSlots.size()) {
                if((emptyGarageSlots.get(i) + requiredExtraSlot) == emptyGarageSlots.get(i + requiredExtraSlot))
                    return emptyGarageSlots.get(i);
            }
            else break;
        }
        return 0;
    }
}
