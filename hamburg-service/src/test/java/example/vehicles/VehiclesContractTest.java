package example.vehicles;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RestPactRunner.class)
@Provider("hamburg-service")
//@PactFolder("../pacts")
@PactBroker(host="localhost", port="80")
public class VehiclesContractTest {

    private RegistrationRepository registrations;
    private VehiclesCtrl vehiclesCtrl;

    @TestTarget
    public MockMvcTarget mockMvcTarget = new MockMvcTarget();

    @Before
    public void setup() {
       registrations = mock(RegistrationRepository.class);
       vehiclesCtrl = new VehiclesCtrl(registrations);

       mockMvcTarget.setControllers(vehiclesCtrl);
    }

    @State("data for HH from 2017 exists") //what will happen if change that?
    public void dataFrom2017() {
        when(registrations.findAll()).thenReturn(VehicleRegistrations.builder()
                .city("Hamburg")
                .diesel(ImmutableMap.of(2017, 10L))
                .gasoline(ImmutableMap.of(2017, 100L)).build());
    }

}
