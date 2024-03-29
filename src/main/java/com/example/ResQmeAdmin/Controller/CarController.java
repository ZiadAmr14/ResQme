package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Model.Customer;
import com.example.ResQmeAdmin.Service.CarService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/getCars")
    public ResponseEntity<ArrayList<Car>> getCars() throws ExecutionException, InterruptedException, JSONException {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.CREATED);
    }
    @GetMapping("/getCar")
    public ResponseEntity<Car> getCar(@RequestParam String carID) throws ExecutionException, InterruptedException, JSONException {
        return new ResponseEntity<>(carService.getCar(carID), HttpStatus.CREATED);
    }

    @PutMapping("/updateCar")
    public ResponseEntity<Car>updateCar(@RequestBody Car car)
    {
        return new ResponseEntity<>(carService.updateCar(car),HttpStatus.ACCEPTED);
    }
}
