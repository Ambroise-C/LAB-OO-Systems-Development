package com.example.Lab.OO.service;

import com.example.Lab.OO.entity.Car;
import java.util.List;

public interface CarService {
    List<Car> getCars();
    Car getCarByPlate(String plate);
    Car rentCar(String plate);
    Car getBackCar(String plate);
    void addCar(Car car);
}
