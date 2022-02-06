package com.smkizilirmak.garage.service.api;

import com.smkizilirmak.garage.domain.Ticket;
import com.smkizilirmak.garage.dto.ParkingDto;

import java.util.Hashtable;
import java.util.List;

public interface GarageService {
    String startParking(ParkingDto parkingDto);

    void endParking(String ticketNumber);

    List<String> parkingVehicles();

    Hashtable<Integer, Boolean> garageStatus();
}
