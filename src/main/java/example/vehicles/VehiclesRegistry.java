package example.vehicles;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VehiclesRegistry {

    private final OkHttpClient httpClient = new OkHttpClient();

    public Vehicles informationFor(String city) throws IOException {
        Request getInfo = new Request.Builder().url("http://localhost:8080/vehicles/registrations/all").build();

        Response res = httpClient.newCall(getInfo).execute();
        return parseInformation(res.body().string());

//        return Vehicles.builder()
//                .city(city)
//                .diesel(ImmutableMap.of(2017, 10L))
//                .gasoline(ImmutableMap.of(2017,100L))
//                .build();
    }

    private Vehicles parseInformation(String json) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.fromJson(json, Vehicles.class);
    }
}
