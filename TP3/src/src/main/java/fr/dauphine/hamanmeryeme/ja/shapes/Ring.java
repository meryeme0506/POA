package src.main.java.fr.dauphine.hamanmeryeme.ja.shapes;

import src.main.java.fr.dauphine.hamanmeryeme.ja.shapes.exceptions.WrongRaduis;

import java.awt.*;
import java.util.ArrayList;

/**
 * Author : Meryeme HAMAN
 */

public class Ring extends Shape{

    private Point center;
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
        this.center = center;
        this.raduisInner= raduisInner;
        this.raduisOuter = raduisOuter ;
    }

    /**
     * checks if an object is a Ring and has the same content as the current Ring or not
     * @param obj a Ring
     * @return true if the obj is equal to the ring, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Ring))
            return false;
        Ring other = (Ring) obj;
        return (this.raduisInner==other.raduisInner) && (this.raduisOuter==other.raduisOuter) && (this.center.equals(((Ring) obj).center));
    }

    /**
     * describes the object Ring
     * @return a string describing the Object Ring
     */
    @Override
    public String toString() {
        return "(center : "+this.center+", inner radius : "+this.raduisInner+", outer radius : "+this.raduisOuter+")";
    }

    /**
     * Checks if a ring contains a Point p
     * @param p a point
     * @return True if the ring contains the point p False otherwise
     */
    public boolean contains(Point p){
        Circle c1 = new Circle(center,raduisInner);
        Circle c2 = new Circle(center,raduisOuter);
        return ((c2.contains(p)) && !(c1.contains(p)));
    }
    /**
     *
     * @param p a point
     * @param rings an ArrayList that contains different rings
     * @return True if the point is inside one the rings False otherwise
     */
    public static boolean contains(Point p, ArrayList<Ring> rings) {
        for (Ring r : rings) {
            if (!r.contains(p))
                return false;
        }
        return true;
    }

    public void paintShape(Graphics g){
        int x1 = center.getX()-(raduisInner/2);
        int y1 = center.getY()-(raduisInner/2);
        int x2 = center.getX()-(raduisOuter/2);
        int y2 = center.getY()-(raduisOuter/2);
        g.drawOval(x1,y1,raduisInner,raduisInner);
        g.drawOval(x2,y2,raduisOuter,raduisOuter);
    }
}
