package example.vehicles;

import lombok.*;

import java.util.Map;

@Value
@Builder
public class VehicleRegistrations {
    String city;
    Map<Integer, Long> gasoline;
    Map<Integer, Long> diesel;
}
