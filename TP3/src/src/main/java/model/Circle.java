package src.main.java.model;

import src.main.java.fr.dauphine.hamanmeryeme.ja.shapes.Point;

import java.awt.*;

/**
 * @author : Meryeme HAMAN
 */

public class Circle extends Shape {


    private final int radius;

    /**
     * The constructor of the class Circle
     * @param center the center of the circle
     * @param r the raduis of the circle
     */
    public Circle(Point center, int r){
        super.setPoint(center);
        this.radius = r;
    }



    public void paintShape(Graphics g){
        int x = this.getPoint().getX()-(radius/2);
        int y = this.getPoint().getY()-(radius/2);
        g.drawOval(x,y,radius,radius);
    }



}
