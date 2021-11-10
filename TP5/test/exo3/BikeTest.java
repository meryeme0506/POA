package exo3;

import main.java.exo3.Bike;
import main.java.exo3.Vehicule;

public class BikeTest extends VehiculeTest{
    @Override
    protected Vehicule myVehicule() {
        return new Bike("Dacia");
    }
}
