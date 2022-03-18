package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.Winch;
import com.example.ResQmeAdmin.Service.WinchService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WinchController {

    @Autowired
    private WinchService winchService;

    @GetMapping("/getWinches")
    public ResponseEntity<ArrayList<Winch>> getWinches() throws JSONException {
        return new ResponseEntity<>(winchService.getWinches(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateWinch")
    public ResponseEntity<Winch> updateWinch(@RequestBody Winch winch)
    {
        return new ResponseEntity<>(winchService.updateWinch(winch),HttpStatus.ACCEPTED);
    }

}
