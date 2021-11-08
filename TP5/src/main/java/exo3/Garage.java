package main.java.exo3;

import java.util.ArrayList;
import java.util.Objects;

public class Garage {

    private ArrayList<Vehicule> vehicules;
    private static int id;


    public Garage() {
        this.vehicules = new ArrayList<Vehicule>();
        id++;
    }

    public void add(Vehicule v) {
        vehicules.add(Objects.requireNonNull(v));
    }

    public boolean contains(Vehicule v){
        return vehicules.contains(v);
    }


    public static int getId() {
        return id;
    }

    public ArrayList<Vehicule> getVehicles() {
        return vehicules;
    }

    @Override
    public String toString() {
        StringBuilder garage = new StringBuilder("vehicle : ");
        for(Vehicule v : vehicules)
            garage.append(v);
            garage.append(";");
        garage.deleteCharAt(garage.length()-1);
        return garage.toString();
    }

    public int valueOfGarage(){
        int sum =0;
        for ( Vehicule v : vehicules)
            sum+=v.getValue();
        return sum;
    }

    public Vehicule firstCarByBrand(String brand){
        for( Vehicule c : vehicules)
            if(c.getBrand().equals(brand))
                return c;
        return null;
    }

    public void remove(Vehicule vehicule) {
        for(Vehicule v : vehicules) {
            if(v.equals(vehicule)) {
                vehicules.remove(v);
            }
        }
    }

    public void protectionism(String brand) {
        for(int i=0;i<vehicules.size();i++) {
            if(vehicules.get(i).getBrand().equals(brand)) {
                vehicules.remove(i);
            }
        }
    }
}
