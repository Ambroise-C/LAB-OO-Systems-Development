package com.example.Lab.OO.entity;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long>{
    Optional<Car> findByPlateIgnoreCase(String plate);
}
