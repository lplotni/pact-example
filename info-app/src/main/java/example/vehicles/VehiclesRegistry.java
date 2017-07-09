package example.vehicles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VehiclesRegistry {

    private final OkHttpClient httpClient = new OkHttpClient();

    @Value("${hamburg.service.url}")
    private String hamburgServiceUrl;
    @Value("${cologne.service.url}")
    private String cologneServiceUrl;


    public Vehicles informationFor(String city) throws IOException {
        switch (city.toLowerCase()) {
            case "hamburg":
                return getInformationForHamburg();
            case "cologne":
                return getInformationForCologne();
            default:
                throw new IllegalArgumentException("Unknown City / No service available");
        }
    }

    private Vehicles getInformationForCologne() throws IOException {
        Request getInfo = new Request.Builder().url(cologneService() + "/vehicles/registrations/all").build();

        Response res = httpClient.newCall(getInfo).execute();
        return parseInformation(res.body().string());
    }

    private Vehicles getInformationForHamburg() throws IOException {
        Request getInfo = new Request.Builder().url(hamburgService() + "/vehicles/registrations/all").build();

        Response res = httpClient.newCall(getInfo).execute();
        return parseInformation(res.body().string());

//        return Vehicles.builder()
//                .city(city)
//                .diesel(ImmutableMap.of(2017, 10L))
//                .gasoline(ImmutableMap.of(2017,100L))
//                .build();
    }

    private String hamburgService() {
        return hamburgServiceUrl == null ? "http://localhost:8080" : hamburgServiceUrl;
    }


    private String cologneService() {
        return cologneServiceUrl == null ? "http://localhost:3000" : cologneServiceUrl;
    }

    private Vehicles parseInformation(String json) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.fromJson(json, Vehicles.class);
    }
}
