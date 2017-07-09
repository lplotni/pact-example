package example.vehicles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.*;

import java.io.IOException;
import java.util.Map;

@Value
@Builder
public class Vehicles {
    String city;
    Map<Integer, Long> gasoline;
    Map<Integer, Long> diesel;


    public static Vehicles fromJson(String json) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.fromJson(json, Vehicles.class);
    }
}
