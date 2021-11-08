package main.java.exo3;


public class Vehicule {
    private final String brand;
    private final long value;
    private Discount discount;
    private boolean isOnSolde;

    public Vehicule(String brand, long value) throws NullPointerException{
        if(value==0)
            throw new NullPointerException("Please enter a valid value !");
        this.brand = brand;
        this.value = value;
        this.discount = new Discount(0);
        this.isOnSolde = false;
    }


    public String getBrand() {
        return brand;
    }

    public long getValue() {
        if(isOnSolde)
            return this.getVehicleDiscount();
        return value;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vehicule) {
            Vehicule Vehicule =(Vehicule) obj;
            if((brand== Vehicule.brand)&(value== Vehicule.value)) {
                return true;
            }
        }
        return false;
    }

    public long getVehicleDiscount(){
        return discount.getDiscount();
    }

    public void setVehicleDiscount(long disc){
        discount.setDiscount(disc);
    }

    public void setVehicleOnSolde(){
        isOnSolde=true;
    }

    public boolean isOnSolde(){
        return isOnSolde;
    }



}
