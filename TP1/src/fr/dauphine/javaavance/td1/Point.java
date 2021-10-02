package fr.dauphine.javaavance.td1;

import java.util.ArrayList;

public class Point {
	
	private int x;
	private int y;
	private static int nbPoints;
	
	public Point(int px,int py) {
		this.x=px;
		this.y=py;
		this.nbPoints++;
	}
	
	public Point(Point p2) {
		this.x=p2.x;
		this.y=p2.y;
		this.nbPoints++;
	}
	
	public int getX() {
		return x;
	}
	public static int getNbPoints() {
		return nbPoints;
	}
	public int getY() {
		return y;
	}
	@Override
	public String toString() {
		
		return "("+this.x+","+this.y+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		return (this.x==other.x) && (this.y==other.y);
	}


	public static void main(String[] args) {
		Point p1 = new Point(4,5);
		Point p2=p1;
		Point p3 = new Point(4,5);
		System.out.println(p1.x+" "+p1.y);
		System.out.println(p1);

	}

}
