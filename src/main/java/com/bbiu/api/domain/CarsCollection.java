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
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);
        prepareExampleCarsList(exampleList);

        this.listOfCars = exampleList;
    }

    private void prepareExampleCarsList(List<Car> exampleList) {
        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Audi")
                .model("A4")
                .numberOfDoors(5)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Bmw")
                .model("3")
                .numberOfDoors(3)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Bmw")
                .model("5")
                .numberOfDoors(4)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Mercedes")
                .model("3")
                .numberOfDoors(3)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Peugeot")
                .model("206")
                .numberOfDoors(3)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Porsche")
                .model("911")
                .numberOfDoors(3)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Skoda")
                .model("Superb")
                .numberOfDoors(5)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Toyota")
                .model("Yaris")
                .numberOfDoors(3)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Hyundai")
                .model("XXX")
                .numberOfDoors(3)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Nissan")
                .model("GTR")
                .numberOfDoors(3)
                .build());

        exampleList.add(Car.builder()
                .id((long) exampleList.size() + 1)
                .company("Nissan")
                .model("GTR Nismo")
                .numberOfDoors(3)
                .build());
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

    public Car findCarById(String carId) {
        return listOfCars.stream().filter(car -> car.getId().equals(Long.parseLong(carId))).findFirst().get();
    }
}
