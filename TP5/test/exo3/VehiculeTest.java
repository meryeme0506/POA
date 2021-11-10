package exo3;
import static org.junit.Assert.*;


import main.java.exo3.Vehicule;
import org.junit.Before;
import org.junit.Test;

public abstract class VehiculeTest {

    protected Vehicule vehicule;

    /**
     * foctory method to allow the creation  of the sub-classes
     */
    protected abstract Vehicule myVehicule();

    @Before
    public void init() {
        vehicule=this.myVehicule();
    }

    @Test
    public void creationTest(){
         assertNotNull(vehicule);
    }

    @Test
    public void equalsTest(){
        Vehicule v = vehicule;
        assertTrue(vehicule.equals(v));
    }

    @Test
    public void setVehiculeDiscountTest(){
        vehicule.setVehicleDiscount(15000);
        assertEquals(15000,vehicule.getVehicleDiscount());
    }

    @Test
    public void setVehicleOnSolde(){
        vehicule.setVehicleDiscount(15000);
        vehicule.setVehicleOnSolde();
        assertTrue(vehicule.isOnSolde());
        assertEquals(15000,vehicule.getValue());
    }

    @Test
    public void setVehicleOffSolde(){
        vehicule.setVehicleOffSolde();
        assertFalse(vehicule.isOnSolde());
    }

    @Test
    public void compareToTestWhenEqual(){
        Vehicule v1 = vehicule;
        assertEquals(0,vehicule.compareTo(v1));
    }





}
