package src.main.java.model;

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
