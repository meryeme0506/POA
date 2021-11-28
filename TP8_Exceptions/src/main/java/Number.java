import exceptions.ErrConst;
import exceptions.ErrD;
import exceptions.ErrP;
import exceptions.ErrS;

public class Number {

    private int  number;
    static final int maxValue = Integer.MAX_VALUE;

    public Number(int number) throws ErrConst {
        if(number<0)
            throw new ErrConst("No negative numbers !!");
        this.number=number;

    }

    public int getN() {
        return number;
    }

    public static Number sum(Number y, Number x) throws ErrS, ErrConst {
        if (x.getN() > maxValue || x.getN()<0  || y.getN() > maxValue || y.getN()<0)
            throw new ErrS("No valid number for addition");
        return new Number(y.getN()+x.getN());
    }

    public static Number soust(Number y, Number x) throws ErrD, ErrConst {
        if (x.getN() > maxValue || x.getN()<0 || y.getN() > maxValue || y.getN()<0)
            throw new ErrD("No valid number for soustraction");
        return new Number(y.getN() - x.getN());
    }

    public static Number prod(Number y,Number x) throws ErrP, ErrConst {
        if (x.getN() > maxValue || x.getN()<0 || y.getN() > maxValue || y.getN()<0)
            throw new ErrP("No valid number for product");
        return new Number(y.getN()*x.getN());
    }


}
