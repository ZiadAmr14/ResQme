package com.example.ResQmeAdmin.Service;

import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Model.Report;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class ReportsService {

    @Autowired
    private WebClient.Builder webClientBuilder;


    public ArrayList<Report> getReports() throws JSONException {
        String reports = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Reports.json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ArrayList<Report> response = new ArrayList<>();

        try
        {
            JSONObject object = new JSONObject(reports);
            Iterator<String> keys = object.keys();
            while (keys.hasNext())
            {
                String key = keys.next();
                if(object.get(key) instanceof JSONObject)
                {
                    if(((JSONObject) object.get(key)).get("reportStatus").toString().equals("Pending"))
                    {
                        response.add(getReport(key));
                    }
                }
            }

        }
        catch (Exception e)
        {
            System.out.println("No Reports");
        }
        return  response;
    }

    private Report getReport(String reportID)
    {
        Report report = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Reports/" + reportID + ".json")
                .retrieve()
                .bodyToMono(Report.class)
                .block();

        return  report;

    }

    public Report updateReport(Report report)
    {
        return webClientBuilder.build()
                .put()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Reports/"+ report.getReportID() +".json")
                .body(Mono.just(report), Report.class)
                .retrieve()
                .bodyToMono(Report.class)
                .block();
    }
}
