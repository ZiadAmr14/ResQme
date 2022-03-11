package com.example.ResQmeAdmin.Service;

import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Model.Customer;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;

@Service
public class CarService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public String getCars()  {
        String Cars = new String();
        Cars = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Cars.json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return  Cars;
    }

    public Car updateCar(Car car)
    {

        return webClientBuilder.build()
                .put()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Customer/"+ car.getCarID() +".json")
                .body(Mono.just(car), Car.class)
                .retrieve()
                .bodyToMono(Car.class)
                .block();

    }




}
