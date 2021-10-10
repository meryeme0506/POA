package exo3;

/**
 * Author : Meryeme HAMAN
 */

public class Multip extends Expr{

    private Expr e1;
    private Expr e2;

    /**
     * The constructor of the class Multip
     * @param e1 an expression Exp
     * @param e2 an expression Exp
     */
    public Multip(Expr e1, Expr e2){
        this.e1 = e1;
        this.e2 = e2;
    }
    /**
     * returns the multiplication of the two expressions
     * @return a double value, the multiplication of the two expressions
     */
    public double eval(){
        return e2.eval()*e1.eval();
    }

    /**
     * prints the expression
     * @return the expression
     */
    public String toString(){
        return "First expression : "+e1.toString()+"\nSecond expression : "+e2.toString();
    }
}
