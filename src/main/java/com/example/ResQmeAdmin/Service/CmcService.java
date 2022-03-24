package com.example.ResQmeAdmin.Service;

import com.example.ResQmeAdmin.Model.CMC;
import com.example.ResQmeAdmin.Model.Car;
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
public class CmcService {

    @Autowired
    private WebClient.Builder webClientBuilder;




    public ArrayList<CMC> getCMCS() throws JSONException, ExecutionException, InterruptedException {
        String cmcs = new String();
        cmcs = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/CMCs.json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ArrayList<CMC> response = new ArrayList<>();
        try
        {
            JSONObject obj = new JSONObject(cmcs);
            Iterator<String> keys = obj.keys();

            while(keys.hasNext()) {
                String key = keys.next();
                if (obj.get(key) instanceof JSONObject) {
                    if(((JSONObject) obj.get(key)).get("cmcStatus").toString().equals("Pending"))
                    {
                        response.add(getCMC(key));
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("No Cars");
        }

        return response;
    }
    private CMC getCMC(String cmcID) throws ExecutionException, InterruptedException {
        CMC cmc = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/CMCs/"+ cmcID +".json")
                .retrieve()
                .bodyToMono(CMC.class)
                .block();
        return cmc;
    }

    public CMC updateCMC(CMC cmc)
    {

        return webClientBuilder.build()
                .put()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/CMCs/"+ cmc.getCmcID() +".json")
                .body(Mono.just(cmc), CMC.class)
                .retrieve()
                .bodyToMono(CMC.class)
                .block();

    }

}
