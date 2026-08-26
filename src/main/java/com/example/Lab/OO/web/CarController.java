package com.example.Lab.OO.web;

import com.example.Lab.OO.data.Car;
import com.example.Lab.OO.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
