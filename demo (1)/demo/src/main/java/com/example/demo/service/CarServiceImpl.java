package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Integer id, Car car){
        Car carInDb = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));

        if(car.getBrand() != null)
            carInDb.setBrand(car.getBrand());
        if(car.getModel() != null)
            carInDb.setModel(car.getModel());
        if(car.getYear() != null)
            carInDb.setYear(car.getYear());
        if(car.getPrice() != null)
            carInDb.setPrice(car.getPrice());
        if(car.getFuelType() != null)
            carInDb.setFuelType(car.getFuelType());
        if(car.getEngineSize() != null)
            carInDb.setEngineSize(car.getEngineSize());
        if(car.getColor() != null)
            carInDb.setColor(car.getColor());
        carInDb = carRepository.save(carInDb);
        return carInDb;
    }

    @Override
    public void delete(Integer id){
        carRepository.deleteById(id);
    }

    @Override
    public Car get(Integer id) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isEmpty()){
            throw new RuntimeException("Car not found");
        }
        return car.get();
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
