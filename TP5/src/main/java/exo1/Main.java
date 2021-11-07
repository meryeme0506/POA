package main.java.exo1;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        Car a = new Car("Audi",10000);
        Car b = new Car("BMW",9000);
        Car c = new Car("BMW",9000);
        Car d = a;
    	System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(a==d);
		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(a.equals(d));

        ArrayList<Car> list = new ArrayList<>();
        list.add(a);
        list.add(b);
       // System.out.println(list.indexOf(a));
		//System.out.println(list.indexOf(b));
		//System.out.println(list.indexOf(c));
		//System.out.println(b.equals(c));
        System.out.println("---------");
        HashSet<Car> set = new HashSet<Car>();
		set.add(b);
		System.out.println(set.contains(c));
    }
}
