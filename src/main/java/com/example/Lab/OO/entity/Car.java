package com.example.Lab.OO.entity;

import org.slf4j.Logger;
import java.time.LocalDate;
import jakarta.persistence.*;


@Entity
public class Car {

    private String plate;
    private String brand;
    private int price;
    private Boolean rented;
    private LocalDate rentedDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name ="car_seq", sequenceName = "car_id_seq", allocationSize = 1)
    private Long id;

    public Car(String brand, String plate, int price) {
        this.brand = brand;
        this.plate = plate;
        this.price = price;
        this.rented = false;
    }

    public Car() {}

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public Boolean isRented() { return rented; }
    public void setRented(Boolean rented) { this.rented = rented; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public LocalDate getRentedDate() { return rentedDate; }
    public void rent(boolean Rented){
        if(Rented){
            this.rentedDate = LocalDate.now();
        }
        else{
            this.rentedDate = null;
        }
        this.rented = Rented;
        System.out.println("Car Rented at: " + this.rentedDate);
    }
}
