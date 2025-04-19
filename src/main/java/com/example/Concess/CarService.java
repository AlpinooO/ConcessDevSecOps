package com.example.Concess;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarService {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> getAllCars() {
        return cars;
    }

    public Car addCar(Car car) {
        cars.add(car);
        return car;
    }
}
