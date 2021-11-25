import exceptions.ErrConst;
import exceptions.ErrD;

public class Main {
    public static void main(String[] args) throws ErrConst, ErrD {
        Number a = new Number(45);
        Number b = new Number(75);
        Number c = Number.soust(a,b);
        System.out.println(c.getN());

    }
}
