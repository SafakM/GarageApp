package com.smkizilirmak.garage.domain;

import java.util.UUID;

public class Ticket {
    private Vehicle vehicle;
    private String ticketNumber;

    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.ticketNumber = UUID.randomUUID().toString();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
