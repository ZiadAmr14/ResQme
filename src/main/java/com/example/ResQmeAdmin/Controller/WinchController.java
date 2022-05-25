package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Model.Winch;
import com.example.ResQmeAdmin.Service.WinchService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
public class WinchController {

    @Autowired
    private WinchService winchService;

    @GetMapping("/getWinches")
    public ResponseEntity<ArrayList<Winch>> getWinches() throws JSONException {
        return new ResponseEntity<>(winchService.getWinches(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getWinch")
    public ResponseEntity<Winch> getWinch(@RequestParam String winchID) throws ExecutionException, InterruptedException, JSONException {
        return new ResponseEntity<>(winchService.getWinch(winchID), HttpStatus.CREATED);
    }


    @PutMapping("/updateWinch")
    public ResponseEntity<Winch> updateWinch(@RequestBody Winch winch)
    {
        return new ResponseEntity<>(winchService.updateWinch(winch),HttpStatus.ACCEPTED);
    }

}
