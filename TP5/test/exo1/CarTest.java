package exo1;

import main.java.exo1.Car;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    Car c1;
    Car c2;
    Car c3;
    Car c4;

    @Before
    public void setUp(){
        c1 = new Car("brabus",1587963);
        c2 = new Car("Gbrabus",1587789,1);
        c3 = new Car("brabus2020",1585642,3);
    }

    @Test(expected = NullPointerException.class)
    public void creationWhenNotOk() throws NullPointerException{
        c4 = new Car("brabus",0);
    }

    @Test
    public void testGetBrand(){
        assertEquals("Gbrabus",c2.getBrand());
    }

    @Test
    public void testGetValueWhenVetusteNull(){
        assertEquals(1587963,c1.getValue());
    }

    @Test
    public void testGetValueWhenVetusteNotNull(){
        assertEquals((1587789-1000),c2.getValue());
        assertEquals((1585642-3000),c3.getValue());
    }


}
