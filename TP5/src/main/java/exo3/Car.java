package main.java.exo3;

public class Car extends Vehicule {

    private int vetuste;

    public Car(String brand, long value) throws NullPointerException{
        super(brand,value);
        this.vetuste = 0;
    }

    public Car(String brand, long value, int vatuste) throws NullPointerException{
        super(brand,value);
        this.vetuste = vatuste;
    }

    public long getValue() {
        if(super.isOnSolde())
            return super.getVehicleDiscount();
        return (super.getValue() - vetuste*1000);
    }

    @Override
    public int hashCode() {
        return (int) (super.getValue()^(super.getValue()));
    }

}
