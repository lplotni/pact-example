package example.vehicles.clients;

import example.vehicles.Vehicles;

import java.io.IOException;

public interface InformationProvider {
    public Vehicles getInformation() throws IOException;
}
