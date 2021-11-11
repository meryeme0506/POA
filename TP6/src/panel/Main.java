package panel;

import java.util.Iterator;
import java.util.List;

import static panel.Panel.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Anonymous class : ");
        Iterator<Integer> it = panel1(1,5);
        for (;it.hasNext() ; ) {
            System.out.println(it.next());
        }

        System.out.println("Iterable : ");
        for (int i : panel2(1,5)) {
            System.out.println(i);
        }

        System.out.println("AbstarctList : ");
        List<Integer> l = panel(3,6);
        for (int i : l) {
            System.out.println(i);
        }

    }




}
