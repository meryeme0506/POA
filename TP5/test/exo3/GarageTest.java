package exo3;

import main.java.exo3.Car;
import main.java.exo3.Garage;
import main.java.exo3.Vehicule;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GarageTest {
    Garage garage;
    Car c1;
    Car c2;
    Car c3;
    Car c4;

    @Before
    public void setUp(){
        garage = new Garage();
        c1 = new Car("brabus",1587963);
        c2 = new Car("Gbrabus",1587789);
        c3 = new Car("brabus2020",1585642);
        c4 = new Car("Gbrabus",3587789);
        garage.add(c1);
        garage.add(c2);
        garage.add(c3);
        garage.add(c4);
    }
    @Test
    public void addTestWhenOK(){
        assertTrue(garage.contains(c3));
    }

    @Test(expected=NullPointerException.class)
    public void addTestWhenNotOk(){
        garage.add(null);
    }

    @Test
    public void testId(){
        assertEquals(1,garage.getId());
    }

    @Test
    public void valueOfGarage(){
        assertEquals((1587963+1587789+1585642+3587789),garage.valueOfGarage());
    }

    @Test
    public void firstCarByBrandWhenCarExist(){
        Vehicule c = garage.firstCarByBrand("Gbrabus");
        assertEquals(c2,c);
    }

    @Test
    public void firstCarByBrandWhenCarDoesntExist(){
        Vehicule c = garage.firstCarByBrand("4x4");
        assertNull(c);
    }

    @Test
    public void removeTest(){
        garage.remove(c4);
        assertFalse(garage.getVehicles().contains(c4));
    }
    @Test
    public void protectionismTest(){
        garage.protectionism("Gbrabus");
        assertFalse(garage.contains(c2));
        assertFalse(garage.contains(c4));
    }

    @Test
    public void equalsTest(){
        Garage garage2 = garage;
        garage2.add(c1);
        garage2.add(c2);
        garage2.add(c3);
        garage2.add(c4);
        assertEquals(true, garage.equals(garage2));

    }
}
