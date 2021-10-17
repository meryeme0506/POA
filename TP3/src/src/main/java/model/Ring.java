package src.main.java.model;

import src.main.java.exceptions.WrongRaduis;

import java.awt.Graphics;


/**
 * Author : Meryeme HAMAN
 */

public class Ring extends Shape {

    private final int raduisInner;
    private final int raduisOuter;

    /**
     * The constructor of the class Ring
     * @param center the center of the ring
     * @param raduisInner the inner radius of the ring
     * @param raduisOuter the outer radius of the ring
     * @throws WrongRaduis an exception signals that raduisInner has to be smaller than the radiusOuter
     */
    public Ring(Point center, int raduisInner, int raduisOuter) throws WrongRaduis {
        if(!(raduisInner<raduisOuter))
            throw new WrongRaduis("the inner radius must always be smaller than the outer one");
        super.setPoint(center);
        this.raduisInner= raduisInner;
        this.raduisOuter = raduisOuter ;
    }



    public void paintShape(Graphics g){
        int x1 = this.getPoint().getX()-(raduisInner/2);
        int y1 = this.getPoint().getY()-(raduisInner/2);
        int x2 = this.getPoint().getX()-(raduisOuter/2);
        int y2 = this.getPoint().getY()-(raduisOuter/2);
        g.drawOval(x1,y1,raduisInner,raduisInner);
        g.drawOval(x2,y2,raduisOuter,raduisOuter);
    }
}
