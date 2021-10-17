package src.main.java.user;

import src.main.java.controller.MouseController;
import src.main.java.fr.dauphine.hamanmeryeme.ja.shapes.Point;
import src.main.java.model.Circle;
import src.main.java.model.Shape;
import src.main.java.view.MyDisplay;
/**
 * @author : Meryeme Haman
 *
 */
public class User {

    public static void main(String[] args){
        Shape c= new Circle( new Point(10,20),5);
        MyDisplay view = new MyDisplay(c);
        MouseController mouseController = new MouseController(view,c);


    }
}
