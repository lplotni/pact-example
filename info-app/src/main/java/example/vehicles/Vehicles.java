package example.vehicles;

import lombok.*;

import java.util.Map;

@Value
@Builder
public class Vehicles {
    String city;
    Map<Integer, Long> gasoline;
    Map<Integer, Long> diesel;
}
