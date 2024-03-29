package com.bbiu.api.endpoint;

import com.bbiu.api.domain.Car;
import com.bbiu.api.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarsEndpoint {

    @Autowired
    private CarsService carsService;

    @PostMapping
    public ResponseEntity<Void> addCar(@RequestBody Car car) {
        carsService.addCar(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCar(@PathVariable String carId) {
        return new ResponseEntity<>(carsService.getCar(carId), HttpStatus.OK);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Void> updateCar(@RequestBody Car car, @PathVariable Long carId) {
        carsService.updateCar(car, carId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> removeCar(@PathVariable Long carId) {
        carsService.removeCar(carId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carsService.getAllCars(), HttpStatus.OK);
    }
}
