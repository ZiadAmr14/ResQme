package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.CMC;
import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Service.CmcService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
public class CmcController {
    @Autowired
    private CmcService cmcService;


    @GetMapping("/getCMCs")
    public ResponseEntity<ArrayList<CMC>> getCMCS() throws InterruptedException, ExecutionException, JSONException {
        return new ResponseEntity<>(cmcService.getCMCS(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getCMC")
    public ResponseEntity<CMC> getCMC(@RequestParam String CmcID) throws ExecutionException, InterruptedException, JSONException {
        return new ResponseEntity<>(cmcService.getCMC(CmcID), HttpStatus.CREATED);
    }

    @PutMapping("/updateCMC")
    public ResponseEntity<CMC> updateCMC(@RequestBody CMC cmc)
    {
        return new ResponseEntity<>(cmcService.updateCMC(cmc),HttpStatus.ACCEPTED);
    }

}
