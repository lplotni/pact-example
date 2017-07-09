package example.vehicles;

import example.vehicles.clients.CologneClient;
import example.vehicles.clients.HamburgClient;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VehiclesRegistry {

    private final CologneClient cologne;
    private final HamburgClient hamburg;

    @Autowired
    public VehiclesRegistry(CologneClient cologne, HamburgClient hamburg) {
        this.cologne = cologne;
        this.hamburg = hamburg;
    }

    Vehicles informationFor(String city) throws IOException {
        switch (city.toLowerCase()) {
            case "hamburg":
                return hamburg.getInformation();
            case "cologne":
                return cologne.getInformation();
            default:
                throw new IllegalArgumentException("Unknown City / No service available");
        }
    }



}
