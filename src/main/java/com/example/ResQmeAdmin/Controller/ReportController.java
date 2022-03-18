package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.Report;
import com.example.ResQmeAdmin.Service.ReportsService;
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
public class ReportController {

    @Autowired
    private ReportsService reportsService;


    @GetMapping("/getReports")
    public ResponseEntity<ArrayList<Report>> getReports() throws JSONException {
        return new ResponseEntity<>(reportsService.getReports(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateReport")
    public ResponseEntity<Report> updateReport(@RequestBody Report report)
    {
        return new ResponseEntity<>(reportsService.updateReport(report),HttpStatus.ACCEPTED);
    }
}
