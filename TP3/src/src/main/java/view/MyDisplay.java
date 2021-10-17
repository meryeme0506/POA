package src.main.java.view;

import src.main.java.controller.MouseController;
import src.main.java.model.Shape;
import src.main.java.model.Circle;
import src.main.java.fr.dauphine.hamanmeryeme.ja.shapes.Point;
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

    public static void main(String []args){
        JFrame frame = new JFrame("Java Avancé - Graphic Display");
        frame.setSize(new Dimension(500,500));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDisplay d = new MyDisplay(new Circle(new Point(250,250),100));
        frame.add(d);
     }
}
