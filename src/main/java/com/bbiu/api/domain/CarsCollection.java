package com.bbiu.api.domain;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CarsCollection {

    @Getter
    private final List<Car> listOfCars;

    private static CarsCollection instance;

    public CarsCollection() {
        List<Car> exampleList = new ArrayList<>();
        exampleList.add(Car.builder()
                .id(1L)
                .company("Audi")
                .model("A4")
                .numberOfDoors(5)
                .build());

        exampleList.add(Car.builder()
                .id(2L)
                .company("BMW")
                .model("3")
                .numberOfDoors(3)
                .build());
        this.listOfCars = exampleList;
    }

    public static CarsCollection getInstance() {
        if (instance == null) {
            instance = new CarsCollection();
        }
        return instance;
    }

    public void updateCarById(Car newCarData, Long carId) {
        for (Car car : listOfCars) {
            if (car.getId().equals(carId)) {
                car.setCompany(newCarData.getCompany());
                car.setModel(newCarData.getModel());
                car.setNumberOfDoors(newCarData.getNumberOfDoors());
            }
        }
    }

    public void removeCarById(Long carId) {
        listOfCars.removeIf(car -> car.getId().equals(carId));
    }
}
