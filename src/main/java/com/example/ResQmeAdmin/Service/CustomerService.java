package com.example.ResQmeAdmin.Service;

import com.example.ResQmeAdmin.Model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.firebase.database.*;
import com.google.firebase.internal.NonNull;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class CustomerService {

    @Autowired
    private WebClient.Builder webClientBuilder;


    public ArrayList<Customer> getCustomers() throws JSONException, ExecutionException, InterruptedException {

        String customers = new String();
        customers = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Customer.json")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        ArrayList<Customer> response = new ArrayList<>();

        try
        {
            JSONObject obj = new JSONObject(customers);
            Iterator<String> keys = obj.keys();
            while(keys.hasNext()) {
                String key = keys.next();
                if (obj.get(key) instanceof JSONObject) {
                    response.add(getCustomer(key));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("No Customers");
        }
        return response;

    }

    public Customer addNewCustomer(Customer customer) throws ExecutionException, InterruptedException {

        customer = webClientBuilder.build()
                .post()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Customer.json")
                .body(Mono.just(customer),Customer.class)
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
        return customer;
    }

    public Customer getCustomer(String userId) throws ExecutionException, InterruptedException {
        Customer customer = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Customer/"+ userId +".json")
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
        return customer;
    }

    public String deleteCustomer(String userId) throws ExecutionException, InterruptedException {
        webClientBuilder.build()
                .delete()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Customer/"+ userId +".json")
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
        return "Done";
    }



    public Customer updateCustomer(Customer customer)
    {

        return webClientBuilder.build()
                .put()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Customer/"+ customer.getUserId() +".json")
                .body(Mono.just(customer), Customer.class)
                .retrieve()
                .bodyToMono(Customer.class)
                .block();

    }



}
