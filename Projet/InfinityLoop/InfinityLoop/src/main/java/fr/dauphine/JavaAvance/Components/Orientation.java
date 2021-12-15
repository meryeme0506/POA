package fr.dauphine.JavaAvance.Components;

import java.util.HashMap;

/**
 * 
 * Orientation of the piece enum
 * 
 */
public enum Orientation {
	/* Implement all the possible orientations and 
	 *  required methods to rotate
	 */
	NORTH,EAST,SOUTH,WEST;

	public static Orientation getOrifromValue(int orientationValue) {
	if(orientationValue==0)
		return Orientation.NORTH;
	if(orientationValue==1)
		return Orientation.EAST;
	if(orientationValue==2)
		return Orientation.SOUTH;
	if(orientationValue==3)
		return Orientation.WEST;
	return null;
	}

	public Orientation turn90() {
		switch(this) {
			case NORTH:
				return Orientation.EAST;

			case EAST:
				return Orientation.SOUTH;

			case SOUTH:
				return Orientation.WEST;

			case WEST:
				return Orientation.NORTH;
		}
		return null;
	}
}
