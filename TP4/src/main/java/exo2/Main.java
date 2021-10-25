package main.java.exo2;

public class Main {
    public static <E,T> void main(String[] args) {
        MyList<E,T> l = new MyList<E,T>();
        l.addLast(78);
        l.add(45);
        l.add(75);
        l.addLast(20);
        System.out.println(l);
        System.out.println(l.get(2));
        System.out.println(l.contains(75));
        System.out.println(l.sumLetter());

    }
}
