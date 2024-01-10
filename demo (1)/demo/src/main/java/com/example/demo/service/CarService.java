package com.example.demo.service;

import com.example.demo.model.Car;

import java.util.List;

public interface CarService {


    Car create(Car car);

    Car update(Integer id, Car student);

    void delete(Integer id);

     Car get(Integer id);

    List<Car> getAll();
}
