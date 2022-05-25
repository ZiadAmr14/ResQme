package com.example.ResQmeAdmin.Controller;


import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Model.SparePart;
import com.example.ResQmeAdmin.Service.SparePartsService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
public class SparePartController {

    @Autowired
    private SparePartsService sparePartsService;

    @GetMapping("/getSpareParts")
    public ResponseEntity<ArrayList<SparePart>> getSpareParts() throws InterruptedException, ExecutionException, JSONException {
        return new ResponseEntity<>(sparePartsService.getSpareParts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getSparePart")
    public ResponseEntity<SparePart> getSparePart(@RequestParam String sparePartID) throws ExecutionException, InterruptedException, JSONException {
        return new ResponseEntity<>(sparePartsService.getSparePart(sparePartID), HttpStatus.CREATED);
    }

    @PutMapping("/updateSparePart")
    public ResponseEntity<SparePart> getSparePart(@RequestBody SparePart sparePart)
    {
        return new ResponseEntity<>(sparePartsService.updateSparePart(sparePart),HttpStatus.ACCEPTED);
    }
}
