package src.main.java.view;

import src.main.java.controller.MouseController;
import src.main.java.exceptions.WrongRaduis;
import src.main.java.model.*;
import src.main.java.model.Point;
import src.main.java.model.Shape;

import javax.swing.*;
import java.awt.*;

/**
 * @author : Meryeme Haman
 *
 */

public class MyDisplay extends JPanel {
    

    private MouseController controller;
    private Shape model;

    public MyDisplay(Shape model)
    {
        this.model = model;
        controller = new MouseController(this,this.model);
        super.addMouseMotionListener(controller);
    }

    public void notifyView()
    {
        super.repaint();

        return;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        model.paintShape(g);

    }

    public static void main(String []args) throws WrongRaduis {
        JFrame frame = new JFrame("Java Avancé - Graphic Display");
        frame.setSize(new Dimension(500,500));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       /* MyDisplay d1 = new MyDisplay(new Point(250,250));
        frame.add(d1);
        MyDisplay d2 = new MyDisplay(new Circle(new Point(250,250),100));
        frame.add(d2);*/
        MyDisplay d3 = new MyDisplay(new Ring(new Point(250,250),100,200));
        frame.add(d3);
     }
}
