package fr.dauphine.javaavance.td1;

import java.util.ArrayList;

public class Polyline {

	private Point[] points;
	
	public Polyline() {

		this.points = new Point[2];
	}
	
	public void add(Point p) throws ArrayIndexOutOfBoundsException{
			for(int i = 0; i<this.points.length; i++)
				if(this.points[i]==null)
					this.points[i]=p;
				else
					throw new ArrayIndexOutOfBoundsException("The array is full");
	}

	public static void main(String[] args) {
		Polyline p = new Polyline();
		Point p1=new Point(1,2);
		Point p2 = new Point(1,2);
		p.add(p1);
		p.add(p2);
		p.add(p1);

	}

}
