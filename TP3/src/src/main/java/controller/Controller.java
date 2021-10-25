package src.main.java.controller;

import src.main.java.model.Circle;
import src.main.java.view.MyDisplay;
import src.main.java.model.Shape;

import java.awt.event.MouseMotionListener;

public class Controller implements MouseMotionListener {
    Shape m;
    MyDisplay view;
    public Controller(..){
        view.addMouseMotionListener(this);
    }
    public void mouseMoved(event e){
        List<Shape> shapes = m.shapes;
        Circle c = shapes.get(shapes.size()-1);
        if(c.contain(new Point(e.getx(),e.getY()))){
            m.add(new Circle(new Point(e.getx(),e.getY()),cm.getR())));
            view.drawing();
        }
    }


}
