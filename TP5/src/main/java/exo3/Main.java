package main.java.exo3;


public class Main {
    public static void main(String[] args){
        Garage garage = new Garage();
        Vehicule a = new Car("Audi",10000);
        Vehicule b = new Car("BMW",10000);
        Vehicule c = new Bike("BMW");
        garage.add(a);
        garage.add(b);
        garage.add(c);
        garage.protectionism("BMW");
        System.out.println(garage.getVehicles());
    }
}
