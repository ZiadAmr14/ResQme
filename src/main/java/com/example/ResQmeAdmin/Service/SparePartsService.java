package com.example.ResQmeAdmin.Service;

import com.example.ResQmeAdmin.Model.CMC;
import com.example.ResQmeAdmin.Model.SparePart;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

@Service
public class SparePartsService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public ArrayList<SparePart> getSpareParts() throws JSONException, ExecutionException, InterruptedException {
        String spareParts = new String();
        spareParts = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/SpareParts.json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ArrayList<SparePart> response = new ArrayList<>();
        try
        {
            JSONObject obj = new JSONObject(spareParts);
            Iterator<String> keys = obj.keys();

            while(keys.hasNext()) {
                String key = keys.next();
                if (obj.get(key) instanceof JSONObject) {
                    if(((JSONObject) obj.get(key)).get("itemStatus").toString().equals("Pending"))
                    {
                        response.add(getSparePart(key));
                    }
                }
            }
        }

        catch (Exception e)
        {
            System.out.println("No SpareParts");
        }

        return response;
    }

    private SparePart getSparePart(String sparePartID) throws ExecutionException, InterruptedException {
        SparePart sparePart = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/SpareParts/"+ sparePartID +".json")
                .retrieve()
                .bodyToMono(SparePart.class)
                .block();
        return sparePart;
    }


    public SparePart updateSparePart(SparePart sparePart)
    {
        return webClientBuilder.build()
                .put()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/SpareParts/"+ sparePart.getItemID() +".json")
                .body(Mono.just(sparePart), SparePart.class)
                .retrieve()
                .bodyToMono(SparePart.class)
                .block();
    }

}
