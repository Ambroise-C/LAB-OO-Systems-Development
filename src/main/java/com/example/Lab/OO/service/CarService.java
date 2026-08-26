package com.example.Lab.OO.service;

import com.example.Lab.OO.data.Car;
import java.util.List;

public interface CarService {
    List<Car> getCars();
    Car getCarByPlate(String plate);
}


