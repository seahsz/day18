package vttp.sff.day18.services;

import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.sff.day18.contants.Constant;
import vttp.sff.day18.models.Carpark;

@Service
public class CarparkService {

    RestTemplate restTemplate = new RestTemplate();

    public List<Carpark> getCarparks() {

        String carparkRawData = restTemplate.getForObject(Constant.CARPARK_URL, String.class);

        JsonReader reader = Json.createReader(new StringReader(carparkRawData));

        JsonObject jsonObj = reader.readObject();

        JsonArray records = jsonObj.getJsonObject("result").getJsonArray("records");

        List<Carpark> carparkList = records.stream()
                    .map(obj -> obj.asJsonObject())
                    .map(obj -> {
                        return new Carpark(obj.getInt("_id"), 
                                           obj.getString("carpark"),
                                           obj.getString("category"),
                                           obj.getString("weekdays_rate_1"),
                                           obj.getString("weekdays_rate_2"),
                                           obj.getString("saturday_rate"),
                                           obj.getString("sunday_publicholiday_rate"));
                                        })
                    .collect(Collectors.toList());

        return carparkList;
    }
    
}
