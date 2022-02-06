package com.smkizilirmak.garage.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ParkingDto {
    @NotEmpty
    @Size(min=5,message = "Plaka en az 5 karakterli olmalıdır")
    private String plate;
    @NotEmpty
    @Size(message = "Renk bos olmamalı!")
    private String color;
    @NotEmpty
    @Size(message = "Arac tipi bos olmamalıdır!")
    private String vehicleType;


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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
