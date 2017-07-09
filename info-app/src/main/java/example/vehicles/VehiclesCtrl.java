package example.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiclesCtrl {

    private final VehiclesRegistry registry;

    @Autowired
    public VehiclesCtrl(VehiclesRegistry registry) {
        this.registry = registry;
    }

    @RequestMapping("/vehicles/{city}")
    public Vehicles get(@PathVariable String city) throws Exception{
        return registry.informationFor(city);
    }
}
