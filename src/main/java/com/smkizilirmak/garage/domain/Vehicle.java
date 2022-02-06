package com.smkizilirmak.garage.domain;

import java.util.List;

public abstract class Vehicle {
    private String plate;
    private String color;
    private List<Integer> holdingSlots;

    public Vehicle(String plate, String color, List<Integer> holdSlots) {
        this.plate = plate;
        this.color = color;
        this.holdingSlots = holdSlots;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Integer> getHoldingSlots() {
        return holdingSlots;
    }

    public void setHoldingSlots(List<Integer> holdingSlots) {
        this.holdingSlots = holdingSlots;
    }

    public abstract String toString();
}
