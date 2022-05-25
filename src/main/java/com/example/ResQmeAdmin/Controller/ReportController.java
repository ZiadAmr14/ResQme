package com.example.ResQmeAdmin.Controller;

import com.example.ResQmeAdmin.Model.Report;
import com.example.ResQmeAdmin.Model.SparePart;
import com.example.ResQmeAdmin.Service.ReportsService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportsService reportsService;


    @GetMapping("/getReports")
    public ResponseEntity<ArrayList<Report>> getReports() throws JSONException {
        return new ResponseEntity<>(reportsService.getReports(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getReport")
    public ResponseEntity<Report> getSparePart(@RequestParam String reportID) throws ExecutionException, InterruptedException, JSONException {
        return new ResponseEntity<>(reportsService.getReport(reportID), HttpStatus.CREATED);
    }

    @PutMapping("/updateReport")
    public ResponseEntity<Report> updateReport(@RequestBody Report report)
    {
        return new ResponseEntity<>(reportsService.updateReport(report),HttpStatus.ACCEPTED);
    }
}
