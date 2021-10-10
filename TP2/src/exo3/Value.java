package exo3;

/**
 * Author : Meryeme HAMAN
 */

public class Value extends Expr{

    private double x;
    /**
     * The constructor of the class Value
     * @param x a real value
     */
    public Value(double x){
        this.x = x;
    }

    /**
     * returns the evaluation of the current expression
     * @return a double value of the current expression
     */
    public double eval(){
        return this.x;
    }

    /**
     * prints the expression
     * @return the expression
     */
    public String toString(){
        return ""+this.x+"";
    }



}
