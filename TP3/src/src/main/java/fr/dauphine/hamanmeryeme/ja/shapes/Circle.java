package src.main.java.fr.dauphine.hamanmeryeme.ja.shapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * Author : Meryeme HAMAN
 */

public class Circle extends Shape{

    private Point center;
    private final int radius;

    /**
     * The constructor of the class Circle
     * @param center the center of the circle
     * @param r the raduis of the circle
     */
    public Circle(Point center, int r){
        this.center=center;
        this.radius = r;
    }

    /**
     * Translates the center of the circle
     * @param dx
     * @param dy
     */
    public void translate(int dx, int dy){
        center.translate(dx,dy);
    }

    /**
     * returns the center of the circle
     * @return a Point `center`
     */
    public Point getCenter(){
        return center;
    }

    /**
     * describes the object Circle
     * @return a string describing the Object Circle
     */
    @Override
    public String toString() {
        return "(("+center.getX()+","+center.getY()+"),"+this.radius+","+this.area()+")";
    }

    /**
     * returns the area of the circle
     * @return a double, the area of the circle
     */
    public double area(){
        return Math.PI*radius*radius;
    }

    /**
     * Checks if a circle contains a Point p
     * @param p a point
     * @return True if the circle contains the point p False otherwise
     */
    public boolean contains(Point p){
        return ((p.getX()- center.getX())*(p.getX()- center.getX()) + (p.getY()- center.getY())*(p.getY()- center.getY()) <= radius*radius);
    }

    /**
     *
     * @param p a point
     * @param circles ArrayList that contains different circles
     * @return True if the point is inside one the circles False otherwise
     */
    public static boolean contains(Point p, ArrayList<Circle> circles) {
        for (Circle c : circles) {
            if (!(c.contains(p)))
                return false;
        }
        return true;
    }

    public void paintShape(Graphics g){
        int x = center.getX()-(radius/2);
        int y = center.getY()-(radius/2);
        g.drawOval(x,y,radius,radius);
    }



}
