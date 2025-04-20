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

    public Car rentCar(String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                if (!car.isRent()) {
                    car.setRent(true);
                    return car;
                } else {
                    throw new RuntimeException("Voiture déjà louée");
                }
            }
        }
        throw new RuntimeException("Voiture introuvable");
    }

    public Car returnCar(String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                if (car.isRent()) {
                    car.setRent(false);
                    return car;
                } else {
                    throw new RuntimeException("Cette voiture n'est pas louée");
                }
            }
        }
        throw new RuntimeException("Voiture introuvable");
    }

    public void buyCar(String plateNumber) {
        boolean removed = cars.removeIf(car -> car.getPlateNumber().equalsIgnoreCase(plateNumber));
        if (!removed) {
            throw new RuntimeException("Voiture introuvable");
        }
    }
}
