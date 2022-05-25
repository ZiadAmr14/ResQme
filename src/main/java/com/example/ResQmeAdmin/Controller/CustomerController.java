package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.Customer;
import com.example.ResQmeAdmin.Service.CustomerService;
//import com.example.ResQmeAdmin.Repository.Firebase;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Controller
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws ExecutionException, InterruptedException {

        return new ResponseEntity<Customer>(customerService.addNewCustomer(customer),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<ArrayList<Customer>> getCustomers() throws JSONException, ExecutionException, InterruptedException {

        return new ResponseEntity<>(customerService.getCustomers(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<Customer> getCustomer(@RequestParam String userId) throws ExecutionException, InterruptedException {
            return new ResponseEntity<>(customerService.getCustomer(userId), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<String> deleteCustomer(@RequestParam String userId) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(customerService.deleteCustomer(userId),HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)throws ExecutionException, InterruptedException
    {
        return new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.ACCEPTED);
    }
}
