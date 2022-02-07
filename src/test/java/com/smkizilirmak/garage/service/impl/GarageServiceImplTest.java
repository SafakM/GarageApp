package com.smkizilirmak.garage.service.impl;

import com.smkizilirmak.garage.dto.ParkingDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class GarageServiceImplTest {
    @InjectMocks
    private GarageServiceImpl garageService;

    @Test
    void startParking() {
        ParkingDto parkingDto =new ParkingDto();
        parkingDto.setColor("Red");
        parkingDto.setPlate("34abc34");
        parkingDto.setVehicleType("Car");

        ParkingDto parkingDtoNew =new ParkingDto();
        parkingDtoNew.setVehicleType("Truck");
        parkingDtoNew.setPlate("34ert45");
        parkingDtoNew.setColor("yellow");

        String result= garageService.startParking(parkingDto);
        String resultNew= garageService.startParking(parkingDtoNew);

        assertNotEquals(result,resultNew);



    }


    @Test
    void parkingVehicles() {
        List<String> tickets = new ArrayList<>();
        ParkingDto parkingDto =new ParkingDto();
        parkingDto.setColor("Red");
        parkingDto.setPlate("34abc34");
        parkingDto.setVehicleType("Car");
        String ticket= garageService.startParking(parkingDto);
        tickets.add(ticket);

        assertNotNull(tickets);
    }


}