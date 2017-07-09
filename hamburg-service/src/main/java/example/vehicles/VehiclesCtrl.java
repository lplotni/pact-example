package example.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiclesCtrl {

    private final RegistrationRepository registry;

    @Autowired
    public VehiclesCtrl(RegistrationRepository registry) {
        this.registry = registry;
    }

    @RequestMapping("/vehicles/registrations/all")
    public VehicleRegistrations get() throws Exception{
        return registry.findAll();
    }
}
