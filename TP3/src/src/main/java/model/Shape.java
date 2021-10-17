package src.main.java.model;

import src.main.java.fr.dauphine.hamanmeryeme.ja.shapes.Point;

import java.awt.*;

/**
 * @author : Meryeme Haman
 *
 */

public abstract  class Shape {
    private Point point;

    public Point getPoint()
    {
        return point;
    }

    public void setPoint(Point point)
    {
        this.point = point;
        return;
    }
    public abstract void paintShape(Graphics g);

}
