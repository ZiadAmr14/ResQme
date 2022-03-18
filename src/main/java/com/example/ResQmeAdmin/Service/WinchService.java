package com.example.ResQmeAdmin.Service;

import com.example.ResQmeAdmin.Model.Car;
import com.example.ResQmeAdmin.Model.Winch;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class WinchService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private Winch getWinch(String winchID)
    {
        Winch winch = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Winches/" +winchID +".json")
                .retrieve()
                .bodyToMono(Winch.class)
                .block();

        return winch;
    }

    public ArrayList<Winch> getWinches() throws JSONException {
        String winches = webClientBuilder.build()
                .get()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Winches.json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ArrayList<Winch> response = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(winches);
            Iterator<String> keys = object.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                if (object.get(key) instanceof JSONObject) {
                    if (((JSONObject) object.get(key)).get("winchStatus").toString().equals("Pending")) {
                        response.add(getWinch(key));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }


    public Winch updateWinch(Winch winch)
    {

        return webClientBuilder.build()
                .put()
                .uri("https://resqme-60664-default-rtdb.firebaseio.com/Winches/"+ winch.getWinchID() +".json")
                .body(Mono.just(winch), Car.class)
                .retrieve()
                .bodyToMono(Winch.class)
                .block();

    }
}
