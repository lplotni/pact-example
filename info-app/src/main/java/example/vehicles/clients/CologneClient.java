package example.vehicles.clients;

import example.vehicles.Vehicles;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CologneClient implements InformationProvider {

    @Value("${cologne.service.url}")
    private String cologneServiceUrl;
    private final OkHttpClient httpClient = new OkHttpClient();

    @Override
    public Vehicles getInformation() throws IOException {
        Request getInfo = new Request.Builder().url(cologneService() + "/vehicles/registrations/all").build();

        Response res = httpClient.newCall(getInfo).execute();
        return Vehicles.fromJson(res.body().string());
    }

    private String cologneService() {
        return cologneServiceUrl == null ? "http://localhost:3000" : cologneServiceUrl;
    }

}
