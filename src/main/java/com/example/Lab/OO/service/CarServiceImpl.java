package com.example.Lab.OO.service;

import com.example.Lab.OO.data.Car;
import com.example.Lab.OO.exception.CarNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Multipla", "FF15XDD"));
        cars.add(new Car("Twingo", "PL4QUE"));
        return cars;
    }

    @Override
    public Car getCarByPlate(String plate) {
        List<Car> cars = getCars();
        return cars.stream()
                .filter(car -> car.getPlate().equalsIgnoreCase(plate))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("No car found with plate: " + plate));
    }
}
