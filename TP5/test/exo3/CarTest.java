package exo3;

import main.java.exo3.Car;
import main.java.exo3.Vehicule;

public class CarTest extends VehiculeTest{

    @Override
    protected Vehicule myVehicule() {
        return new Car("Audi",45699);
    }
}
