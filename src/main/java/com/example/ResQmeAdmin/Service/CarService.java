package com.example.ResQmeAdmin.Service;

import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Model.Customer;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

@Service
public class CarService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public ArrayList<Car> getCars() throws JSONException, ExecutionException, InterruptedException {
        String cars = new String();
        cars = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Cars.json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JSONObject obj = new JSONObject(cars);
        Iterator<String> keys = obj.keys();
        ArrayList<Car> response = new ArrayList<>();
        while(keys.hasNext()) {
            String key = keys.next();
            if (obj.get(key) instanceof JSONObject) {
                if(((JSONObject) obj.get(key)).get("carStatus").toString().equals("Pending"))
                {
                    response.add(getCar(key));
                }
            }
        }

        return response;
    }

    private Car getCar(String carID) throws ExecutionException, InterruptedException {
        Car car = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Cars/"+ carID +".json")
                .retrieve()
                .bodyToMono(Car.class)
                .block();
        return car;
    }

    public Car updateCar(Car car)
    {

        return webClientBuilder.build()
                .put()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Cars/"+ car.getCarID() +".json")
                .body(Mono.just(car), Car.class)
                .retrieve()
                .bodyToMono(Car.class)
                .block();

    }




}
