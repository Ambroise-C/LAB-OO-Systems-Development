package com.example.Lab.OO.config;

import com.example.Lab.OO.entity.Car;
import com.example.Lab.OO.entity.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Bean
    CommandLineRunner initDatabase(CarRepository carRepository) {
        return args -> {
            if (carRepository.count() == 0) {
                carRepository.save(new Car("Renault", "FF15XDD", 15000));
                carRepository.save(new Car("Citroen", "PL4QUE", 46000));

                logger.info("Database initialized: Cars have been inserted.");
            } else {
                logger.info("Database already populated. Skipping initialization.");
            }
        };
    }
}
