package src.main.java.model;


import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Objects;

public class Polyline extends Shape {

	private LinkedList<Point> points;
	
	public Polyline() {
		this.points = new LinkedList<Point>();
	}

	public void add(Point p)  {
		this.points.add( Objects.requireNonNull(p));
	}
	/*
	public int pointCapacity(){
		int x=0;
		for(int i = 0; i<this.points.length; i++)
			if(this.points[i]==null)
				x++;
		return x;
	}
	*/
	public int nbPoints(){

		return this.points.size();
	}
	public boolean contains(Point p){
		for (Point point : this.points) {
			if(point.equals(p))
				return true;
		}
		return false;
	}

	public int[] getXsin(){
		int[] xSin = new int[this.nbPoints()];
		for(int i=0; i<this.nbPoints();i++){
			xSin[i]= points.get(i).getX();
		}
		return xSin;
	}

	public int[] getYsin(){
		int[] xYin = new int[this.nbPoints()];
		for(int i=0; i<this.nbPoints();i++){
			xYin[i]= points.get(i).getY();
		}
		return xYin;
	}

	public void paintShape(Graphics g){
		g.drawPolyline(this.getXsin(), this.getYsin(), this.nbPoints());
	}


}
