package fr.dauphine.JavaAvance.Components;

import java.io.StringBufferInputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

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

	private static final Map<Integer,Orientation> map= new HashMap<Integer,Orientation>();

	static {
		int i=0;
		for (Orientation c : Orientation.values())
			map.put(i, c);
			i++;
	}


	public static Orientation getOrifromValue(int orientationValue) {
		return map.get(orientationValue);
	}

	public static int getValueFromOri(Orientation orientation) {
		switch (orientation){
			case NORTH -> {
				return 0;
			}
			case EAST -> {
				return 1;
			}case SOUTH -> {
				return 2;
			}
			case WEST -> {
				return 3;
			}
		}
		return 0;
	}

	public Orientation turn90() {
		switch(this) {
			case NORTH:
				return EAST;
			case EAST:
				return SOUTH;
			case SOUTH:
				return WEST;
			case WEST:
				return NORTH;
		}
		return null;
	}
	public int[] getOpposedPieceCoordinates(Piece p) {
		switch (this){
			case NORTH -> {
				return new int[]{p.getPosY()-1,p.getPosX()};
			}
			case EAST -> {
				return new int[]{p.getPosY(),p.getPosX()+1};
			}
			case SOUTH -> {
				return new int[]{p.getPosY()+1,p.getPosX()};
			}
			case WEST -> {
				return new int[]{p.getPosY(),p.getPosX()-1};
			}
		}
		return null;
	}
	public Orientation getOpposedOrientation() {
		switch (this){
			case NORTH -> {
				return SOUTH;
			}
			case SOUTH -> {
				return NORTH;
			}
			case EAST -> {
				return WEST;
			}
			case WEST -> {
				return EAST;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		switch (this){
			case NORTH -> {
				return "NORTH";
			}
			case EAST -> {
				return "EAST";
			}
			case SOUTH -> {
				return "SOUTH";
			}

			case WEST -> {
				return "WEST";
			}
		}
		return null;
	}
}
