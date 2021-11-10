package main.java.exo3;

import java.util.*;

public class Garage  {

    private List<Vehicule> vehicules;
    private static int id;


    public Garage() {
        this.vehicules = new ArrayList<Vehicule>();
        id++;
    }

    public void add(Vehicule v) {
        vehicules.add(Objects.requireNonNull(v));
        Collections.sort(vehicules);
    }

    public boolean contains(Vehicule v){
        return vehicules.contains(v);
    }


    public static int getId() {
        return id;
    }

    public List<Vehicule> getVehicles() {
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
                vehicules.remove(vehicule);
    }

    public void protectionism(String brand) {
        for (Iterator<Vehicule> iter = vehicules.iterator(); iter.hasNext(); ) {
            Vehicule v = iter.next();
            if (v.getBrand().equals(brand)) {
                iter.remove();
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Garage) {
            Garage garage2 =(Garage) obj;
            if(vehicules.equals(garage2.getVehicles())) {
                return true;
            }
        }
        return false;
    }



}
