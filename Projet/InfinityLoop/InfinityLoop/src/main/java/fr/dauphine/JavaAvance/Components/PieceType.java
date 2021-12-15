package fr.dauphine.JavaAvance.Components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedList;

/**
 * 
 * Type of the piece enum
 * 
 */
public enum PieceType {
    VOID,ONECONN,BAR,TTYPE,FOURCONN,LTYPE;

    public static PieceType getTypefromValue(int typeValue) {
        if(typeValue==0)
            return PieceType.VOID;
        if(typeValue==1)
            return PieceType.ONECONN;
        if(typeValue==2)
            return PieceType.BAR;
        if(typeValue==3)
            return PieceType.TTYPE;
        if(typeValue==4)
            return PieceType.FOURCONN;
        if(typeValue==5)
            return PieceType.LTYPE;
        return null;
    }




    public LinkedList<Orientation> setConnectorsList(Orientation north) {

    }

    public ArrayList<Orientation> getListOfPossibleOri() {
        return new ArrayList<Orientation>(EnumSet.allOf(Orientation.class));
    }

    public Orientation getOrientation(Orientation orientation) {
        switch(this){
            case FOURCONN,VOID -> {
                return Orientation.NORTH;
            }
            case ONECONN,TTYPE, LTYPE -> {
                return orientation;
            }
            case BAR -> {
                switch(orientation){
                    case NORTH,SOUTH -> {
                        return Orientation.NORTH;
                    }
                    case EAST,WEST -> {
                        return Orientation.EAST;
                    }
                }
            }
        }
        return null;
    }
}
