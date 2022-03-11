package com.example.ResQmeAdmin.Service;

import com.example.ResQmeAdmin.Model.Customer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@Service
public class CustomerService {

    @Autowired
    private WebClient.Builder webClientBuilder;

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
