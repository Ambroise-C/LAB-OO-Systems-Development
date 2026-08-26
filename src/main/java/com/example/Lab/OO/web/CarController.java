package com.example.Lab.OO.web;

import com.example.Lab.OO.data.Car;
import com.example.Lab.OO.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> listOfCars() {
        return carService.getCars();
    }

    @GetMapping("/{plate}")
    public Car getCarPlate(@PathVariable String plate) {
        return carService.getCarByPlate(plate);
    }

    @PutMapping("/{plate}/rent")
    public Car rentCar(@PathVariable String plate) {
        return carService.rentCar(plate);
    }

    @PutMapping("/{plate}/getback")
    public Car getCarBack(@PathVariable String plate) {
        return carService.getBackCar(plate);
    }
}
