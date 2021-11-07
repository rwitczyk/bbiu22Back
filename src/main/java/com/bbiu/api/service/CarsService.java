package com.bbiu.api.service;

import com.bbiu.api.domain.Car;
import com.bbiu.api.domain.CarsCollection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    public void addCar(Car car) {
        car.setId((long) CarsCollection.getInstance().getListOfCars().size() + 1);
        CarsCollection.getInstance().getListOfCars().add(car);
    }

    public void updateCar(Car car, Long carId) {
        CarsCollection.getInstance().updateCarById(car, carId);
    }

    public void removeCar(Long carId) {
        CarsCollection.getInstance().removeCarById(carId);
    }

    public List<Car> getAllCars() {
        return CarsCollection.getInstance().getListOfCars();
    }

    public Car getCar(String carId) {
        return CarsCollection.getInstance().findCarById(carId);
    }
}
