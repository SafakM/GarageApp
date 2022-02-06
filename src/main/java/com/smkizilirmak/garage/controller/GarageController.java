package com.smkizilirmak.garage.controller;

import com.smkizilirmak.garage.dto.ParkingDto;
import com.smkizilirmak.garage.service.api.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("rest/garage/")
public class GarageController {

    private final GarageService garageService;

    @Autowired
    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping("startParking")
    public ResponseEntity startParking(@Valid @RequestBody ParkingDto parkingDto) {
        return new ResponseEntity<>(garageService.startParking(parkingDto), HttpStatus.OK);
    }

    @GetMapping("endParking/{ticketNumber}")
    public ResponseEntity endParking(@PathVariable String ticketNumber) {
        garageService.endParking(ticketNumber);
        return new ResponseEntity<>("Parklanma sonlandirildi", HttpStatus.OK);
    }

    @GetMapping("parkingVehicles")
    public ResponseEntity parkingVehicles() {
        return new ResponseEntity<>(garageService.parkingVehicles(), HttpStatus.OK);
    }

    @GetMapping("garageStatus")
    public ResponseEntity garageStatus() {
        return new ResponseEntity<>(garageService.garageStatus(),HttpStatus.OK);
    }
}
