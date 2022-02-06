package com.smkizilirmak.garage.domain;

import java.util.List;

public class Jeep extends Vehicle{
    public Jeep(String plate, String color, List<Integer> holdSlots) {
        super(plate, color, holdSlots);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.getPlate() + " " + super.getColor() + " Jeep [");
        super.getHoldingSlots().forEach(s -> sb.append(s).append(","));
        sb.append("]");
        return sb.toString();
    }
}
