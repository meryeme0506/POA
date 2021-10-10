package exo3;

/**
 * Author : Meryeme HAMAN
 */

import java.lang.Math;


public class Sqrt extends Expr{

    private Expr e;

    /**
     * The constructor of the class Sqrt
     * @param e an expression Exp
     */
    public Sqrt(Expr e){
        this.e = e;
    }
    /**
     * returns the sqrt of the current expression
     * @return a double value, the sqrt of the current expression
     */
    public double eval(){
        return Math.sqrt(e.eval());
    }

    /**
     * prints the expression
     * @return the expression
     */
    public String toString(){
        return "\u221A"+e.toString();
    }
}
