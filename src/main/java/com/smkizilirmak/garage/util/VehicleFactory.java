package com.smkizilirmak.garage.util;

import com.smkizilirmak.garage.domain.Car;
import com.smkizilirmak.garage.domain.Jeep;
import com.smkizilirmak.garage.domain.Truck;
import com.smkizilirmak.garage.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleFactory {
    public static Vehicle createVehicle(String plate, String color, String vehicleType, int startedSlot) {
        switch (vehicleType) {
            case "Car":
                return new Car(plate, color, generateHoldingSlots(startedSlot, 1));
            case "Jeep":
                return new Jeep(plate, color, generateHoldingSlots(startedSlot, 2));
            case "Truck":
                return new Truck(plate, color, generateHoldingSlots(startedSlot, 4));
            default: return null;
        }
    }

    private static List<Integer> generateHoldingSlots(int slotStartIndex, int slotSize) {
        List<Integer> slots = new ArrayList<>();
        for(int i = 0; i < slotSize; i++) {
            slots.add(slotStartIndex+i);
        }
        return slots;
    }
}
