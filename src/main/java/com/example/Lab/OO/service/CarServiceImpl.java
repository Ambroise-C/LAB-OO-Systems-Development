package com.example.Lab.OO.service;

import com.example.Lab.OO.entity.Car;
import com.example.Lab.OO.entity.CarRepository;
import com.example.Lab.OO.exception.CarAlreadyRentedException;
import com.example.Lab.OO.exception.CarNotFoundException;
import com.example.Lab.OO.exception.CarNotRentedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
    private CarRepository carRepository;
    private final List<Car> cars = new ArrayList<>();


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car getCarByPlate(String plate) {
        return carRepository.findByPlateIgnoreCase(plate)
                .orElseThrow(() -> new CarNotFoundException("No car found with plate: " + plate));
    }

    @Override
    public Car rentCar(String plate) {
        Car car = getCarByPlate(plate);
        if (car.isRented()) {
            throw new CarAlreadyRentedException("Car with plate " + plate + " is already rented");
        }
        car.rent(true);
        return carRepository.save(car);
    }

    @Override
    public Car getBackCar(String plate) {
        Car car = getCarByPlate(plate);
        if (!car.isRented()) {
            throw new CarNotRentedException("Car with plate " + plate + " is not currently rented");
        }
        car.rent(false);
        return carRepository.save(car);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
        logger.info("Car saved to database: {}", car.getPlate());
    }

}
