package src.main.java.model;


import java.awt.Graphics;

/**
 * Author : Meryeme HAMAN
 */

public class Point extends Shape {
	
	private final int x;
	private final int y;
	private static int nbPoints;

	/**
	 * The first constructor of the class Point
	 * @param px integer field
	 * @param py integer field
	 */
	public Point(int px,int py) {
		this.x=px;
		this.y=py;
		this.nbPoints++;
	}

	/**
	 * The second constructor of the class Point
	 * @param p2 a point instance of Point
	 */
	public Point(Point p2) {
		this.x=p2.x;
		this.y=p2.y;
		this.nbPoints++;
	}

	/**
	 * returns the value of x
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * returns the value of y
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * describes the object Point
	 * @return a string describing the Object  Point
	 */
	@Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}

	/**
	 * checks if an object is a Point and has the same content as the current Point or not
	 * @param obj a Point
	 * @return true if the obj is equal to the point, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		return (this.x==other.x) && (this.y==other.y);
	}

	/**
	 * translates a point
	 * @param dx
	 * @param dy
	 * @return a new Point that represents the translated point
	 */
	public Point translate(int dx, int dy){
		 return new Point(x+dx,y+dy);
	}



	public void paintShape(Graphics g){
		g.drawLine(x,y,x+20,y+20);
	}

}
