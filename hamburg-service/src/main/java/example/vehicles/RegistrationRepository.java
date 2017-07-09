package example.vehicles;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepository {

    private final ImmutableMap<Integer, Long> gasoline = new ImmutableMap.Builder<Integer, Long>()
            .put(2017, 100L)
            .put(2016, 200L)
            .build();

    private final ImmutableMap<Integer, Long>  diesel = new ImmutableMap.Builder<Integer, Long>()
            .put(2017, 10L)
            .put(2016, 20L)
            .build();


    public VehicleRegistrations findAll() {
        return VehicleRegistrations.builder()
                .city("Hamburg")
                .diesel(diesel)
                .gasoline(gasoline)
                .build();
    }

}
