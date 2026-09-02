package com.example.Lab.OO.data;

public class Car {

    private String plate;
    private String brand;
    private int price;
    private Boolean rented;
    private Date rentedDate;

    public Car(String brand, String plate, int price) {
        this.brand = brand;
        this.plate = plate;
        this.price = price;
        this.rented = false;
        this.rentedDate = new Date(1,1,2000);
    }

    public Car(){}

    public String getBrand() { return brand; }
    public void setBrand(String name) { this.brand = brand; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public Boolean isRented() { return rented; }
    public void setRented(Boolean rented) { this.rented = rented; }
    public Date getRentedDate() { return rentedDate; }
    public void setRentedDate(Date rentedDate) { this.rentedDate = rentedDate; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public void rent(boolean Rented){
        if(Rented){
            this.rentedDate = new Date();
        }
        this.rented = Rented;
        this.rentedDate = new Date(1,1,2000);


    }
}
