package com.example.ResQmeAdmin.Controller;


import com.example.ResQmeAdmin.Model.SparePart;
import com.example.ResQmeAdmin.Service.SparePartsService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
public class SparePartController {

    @Autowired
    private SparePartsService sparePartsService;

    @GetMapping("/getSpareParts")
    public ResponseEntity<ArrayList<SparePart>> getSpareParts() throws InterruptedException, ExecutionException, JSONException {
        return new ResponseEntity<>(sparePartsService.getSpareParts(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateSparePart")
    public ResponseEntity<SparePart> getSparePart(@RequestBody SparePart sparePart)
    {
        return new ResponseEntity<>(sparePartsService.updateSparePart(sparePart),HttpStatus.ACCEPTED);
    }
}
