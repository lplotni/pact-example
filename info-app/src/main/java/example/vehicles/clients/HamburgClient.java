package example.vehicles.clients;

import example.vehicles.Vehicles;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HamburgClient implements InformationProvider {

    @Value("${hamburg.service.url}")
    private String hamburgServiceUrl;
    private final OkHttpClient httpClient = new OkHttpClient();


    public Vehicles getInformation() throws IOException {
        Request getInfo = new Request.Builder().url(hamburgService() + "/vehicles/registrations/all").build();

        Response res = httpClient.newCall(getInfo).execute();
        return Vehicles.fromJson(res.body().string());

//        return Vehicles.builder()
//                .city(city)
//                .diesel(ImmutableMap.of(2017, 10L))
//                .gasoline(ImmutableMap.of(2017,100L))
//                .build();
    }


    private String hamburgService() {
        return hamburgServiceUrl == null ? "http://localhost:8080" : hamburgServiceUrl;
    }

}
