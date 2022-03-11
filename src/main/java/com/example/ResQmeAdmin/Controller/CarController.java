package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Model.Customer;
import com.example.ResQmeAdmin.Service.CarService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/getCars")
    public ResponseEntity<String> getCars() throws ExecutionException, InterruptedException{
        return new ResponseEntity<>(carService.getCars(), HttpStatus.CREATED);
    }

    @PutMapping("/updateCar")
    public ResponseEntity<Car>updateCar(Car car)
    {
        return new ResponseEntity<>(carService.updateCar(car),HttpStatus.ACCEPTED);
    }
}
