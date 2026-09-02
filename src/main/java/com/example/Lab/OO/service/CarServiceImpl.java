package com.example.Lab.OO.service;

import com.example.Lab.OO.data.Car;
import com.example.Lab.OO.exception.CarAlreadyRentedException;
import com.example.Lab.OO.exception.CarNotFoundException;
import com.example.Lab.OO.exception.CarNotRentedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("Renault", "FF15XDD", 15000));
        cars.add(new Car("Citroen", "PL4QUE", 46000));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Car getCarByPlate(String plate) {
        return cars.stream()
                .filter(car -> car.getPlate().equalsIgnoreCase(plate))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("No car found with plate: " + plate));
    }

    @Override
    public Car rentCar(String plate) {
        Car car = getCarByPlate(plate);
        if (car.isRented()) {
            throw new CarAlreadyRentedException("Car with plate " + plate + " is already rented");
        }
        car.rent(true);
        return car;
    }

    @Override
    public Car getBackCar(String plate) {
        Car car = getCarByPlate(plate);
        if (!car.isRented()) {
            throw new CarNotRentedException("Car with plate " + plate + " is not currently rented");
        }
        car.rent(false);
        return car;
    }
}
