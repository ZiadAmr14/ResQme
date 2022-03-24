package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.CMC;
import com.example.ResQmeAdmin.Service.CmcService;
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
public class CmcController {
    @Autowired
    private CmcService cmcService;


    @GetMapping("/getCMCs")
    public ResponseEntity<ArrayList<CMC>> getCMCS() throws InterruptedException, ExecutionException, JSONException {
        return new ResponseEntity<>(cmcService.getCMCS(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCMC")
    public ResponseEntity<CMC> updateCMC(@RequestBody CMC cmc)
    {
        return new ResponseEntity<>(cmcService.updateCMC(cmc),HttpStatus.ACCEPTED);
    }

}
