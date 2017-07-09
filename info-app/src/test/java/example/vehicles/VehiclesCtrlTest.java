package example.vehicles;

import com.google.common.collect.ImmutableMap;
import example.vehicles.Vehicles;
import example.vehicles.VehiclesCtrl;
import example.vehicles.VehiclesRegistry;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VehiclesCtrlTest {

    @Test
    public void shouldReturnVehiclesForSpecifiedCity() throws Exception {
        Vehicles vehicles = Vehicles.builder()
                .city("Hamburg")
                .gasoline(ImmutableMap.of(2017, 19L))
                .diesel(ImmutableMap.of(2017, 0L))
                .build();

        VehiclesRegistry vehiclesRegistry = mock(VehiclesRegistry.class);
        when(vehiclesRegistry.informationFor("Hamburg"))
                .thenReturn(
                        vehicles);


        VehiclesCtrl sut = new VehiclesCtrl(vehiclesRegistry);

        Vehicles vehicleRegistrationInHamburg = sut.get("Hamburg");
        assertThat(vehicleRegistrationInHamburg, is(vehicles));
    }
}