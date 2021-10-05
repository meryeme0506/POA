package fr.dauphine.javaavance.td1;

import java.util.LinkedList;
import java.util.Objects;

public class Polyline {

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

	public static void main(String[] args) {
		Polyline p = new Polyline();
		Point p1 =new Point(1,2);
		Point p2 = new Point(1,2);
		p.add(p1);
		p.add(p2);
		System.out.println(p.contains(p1));


	}

}
