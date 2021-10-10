package exo3;

/**
 * Author : Meryeme HAMAN
 */

public class Main {
    public static void main(String[] args) {
        Expr val = new Value(1337.0);
        System.out.println(val.eval()); //affiche 1337.0
        Expr add = new Add(new Value(327.0), val);
        System.out.println(add.eval()); //affiche 1664.0
        Expr e = new Add(new Value(350.0), add);
        System.out.println(e.eval()); //affiche 2014.0
        System.out.println(add.toString());
        Expr multip = new Multip(val,val);
        System.out.println(multip.eval());
        Expr sqrt = new Sqrt(new Value(1337.0));
        System.out.println(sqrt.eval());
        System.out.println(sqrt.toString());

    }
}
