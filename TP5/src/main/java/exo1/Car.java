package main.java.exo1;

public class Car {

    private final String brand;
    private final long value;
    private int vetuste;

    public Car(String brand, long value) throws NullPointerException{
        if(value==0)
            throw new NullPointerException("Please enter a valid value !");
        this.brand = brand;
        this.value = value;
        this.vetuste = 0;
    }
    public Car(String brand, long value, int vatuste) throws NullPointerException{
        if(value==0)
            throw new NullPointerException("Please enter a valid value !");
        this.brand = brand;
        this.value = value;
        this.vetuste = vatuste;
    }

    public String getBrand() {
        return brand;
    }

    public long getValue() {
        return (value - vetuste*1000);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car) {
            Car car =(Car) obj;
            if((brand==car.brand)&(value==car.value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int res = 0;
        for (int i = 0 ; i<brand.length() ; i++) {
            res+= brand.codePointAt(i);
        }
        return (int) value + res;
    }

}
