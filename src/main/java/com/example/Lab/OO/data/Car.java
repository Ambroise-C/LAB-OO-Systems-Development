package com.example.Lab.OO.data;

public class Car {
    private String name;
    private String plate;
    private Boolean Rented;

    public Car(String name, String plate) {
        this.name = name;
        this.plate = plate;
        this.Rented = false;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public Boolean getRented() { return Rented; }
    public void setRented(Boolean rented) { this.Rented = rented; }
}
