package src.main.java.controller;

import src.main.java.model.Shape;
import src.main.java.view.MyDisplay;
import src.main.java.model.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author : Meryeme Haman
 *
 */

public class MouseController implements MouseMotionListener {
    private MyDisplay view;
    private Shape model;
    public MouseController(MyDisplay myDisplay,Shape shape){
        this.view = myDisplay;
        this.model= shape;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        return;
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        model.setPoint(new Point(e.getX(), e.getY()));
        view.notifyView();
    }
}
