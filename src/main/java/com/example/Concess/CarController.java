package com.example.Concess;

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
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping("/{plate}/rent")
    public Car rentCar(@PathVariable String plate) {
        return carService.rentCar(plate);
    }

    @PutMapping("/{plate}/return")
    public Car returnCar(@PathVariable String plate) {
        return carService.returnCar(plate);
    }

    @DeleteMapping("/{plate}/buy")
    public void buyCar(@PathVariable String plate) {
        carService.buyCar(plate);
    }
}
