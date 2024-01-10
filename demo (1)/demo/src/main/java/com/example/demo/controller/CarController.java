package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car/v1")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public Car get(@PathVariable Integer id) {
        return carService.get(id);
    }

    @GetMapping()
    public List<Car> getAll() {
        return carService.getAll();
    }

    @PostMapping
    public Car create(@RequestBody Car car){
        return carService.create(car);
    }

    @PutMapping("{id}")
    public Car update(@PathVariable Integer id, @RequestBody Car car){
        return carService.update(id, car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        carService.delete(id);
    }
}
