package main.java.exo1;

import java.util.ArrayList;
import java.util.Objects;

public class Garage {

    private ArrayList<Car> cars;
    private static int id;


    public Garage() {
        this.cars = new ArrayList<Car>();
        id++;
    }

    public void add(Car car) {
        cars.add(Objects.requireNonNull(car));
    }

    public boolean contains(Car c){
        return cars.contains(c);
    }


    public static int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder garage = new StringBuilder("Cars : ");
        for(Car c : cars)
            garage.append(c);
            garage.append(";");
        garage.deleteCharAt(garage.length()-1);
        return garage.toString();
    }

    public int valueOfGarage(){
        int sum =0;
        for ( Car c : cars)
            sum+=c.getValue();
        return sum;
    }

    public Car firstCarByBrand(String brand){
        for( Car c : cars)
            if(c.getBrand().equals(brand))
                return c;
        return null;
    }
}
