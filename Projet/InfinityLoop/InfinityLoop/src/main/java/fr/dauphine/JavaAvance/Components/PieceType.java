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
    VOID(0) {
        public Orientation getOrientation(Orientation orientation) {
            return Orientation.NORTH;
        }

        public LinkedList<Orientation> setConnectorsList(Orientation orientation) {
            return null;
        }

        public ArrayList<Orientation> getListOfPossibleOri() {
            ArrayList<Orientation> temp = new ArrayList<>();
            temp.add(Orientation.NORTH);
            return temp;
        }
    },
    ONECONN(1) {
        public Orientation getOrientation(Orientation orientation) {
            return orientation;
        }

        public LinkedList<Orientation> setConnectorsList(Orientation orientation) {
            LinkedList<Orientation> connectors = new LinkedList<Orientation>();
            switch (orientation) {
                case NORTH:
                    connectors.add(Orientation.NORTH);
                case EAST:
                    connectors.add(Orientation.EAST);
                case WEST:
                    connectors.add(Orientation.WEST);
                case SOUTH:
                    connectors.add(Orientation.SOUTH);
            }
            return connectors;
        }

        public ArrayList<Orientation> getListOfPossibleOri() {
            ArrayList<Orientation> temp = new ArrayList<>();
            temp.add(Orientation.NORTH);
            temp.add(Orientation.EAST);
            temp.add(Orientation.SOUTH);
            temp.add(Orientation.WEST);
            return temp;
        }
    },
    BAR(2) {
        public Orientation getOrientation(Orientation orientation) {
            if (orientation == Orientation.NORTH || orientation == Orientation.SOUTH)
                return Orientation.NORTH;
            if (orientation == Orientation.EAST || orientation == Orientation.WEST)
                return Orientation.EAST;
            return null;
        }

        public LinkedList<Orientation> setConnectorsList(Orientation orientation) {
            LinkedList<Orientation> connectors = new LinkedList<Orientation>();
            switch (orientation) {
                case NORTH, SOUTH:
                    connectors.add(Orientation.NORTH);
                    connectors.add(Orientation.SOUTH);
                case EAST, WEST:
                    connectors.add(Orientation.EAST);
                    connectors.add(Orientation.WEST);
            }
            return connectors;
        }

        public ArrayList<Orientation> getListOfPossibleOri() {
            ArrayList<Orientation> temp = new ArrayList<>();
            temp.add(Orientation.NORTH);
            temp.add(Orientation.EAST);
            return temp;
        }
    },
    TTYPE(3) {
        public Orientation getOrientation(Orientation orientation) {
            return orientation;
        }

        public LinkedList<Orientation> setConnectorsList(Orientation orientation) {
            LinkedList<Orientation> connectors = new LinkedList<Orientation>();
            switch (orientation) {
                case NORTH:
                    connectors.add(Orientation.NORTH);
                    connectors.add(Orientation.WEST);
                    connectors.add(Orientation.EAST);
                case EAST:
                    connectors.add(Orientation.NORTH);
                    connectors.add(Orientation.EAST);
                    connectors.add(Orientation.SOUTH);
                case SOUTH:
                    connectors.add(Orientation.EAST);
                    connectors.add(Orientation.SOUTH);
                    connectors.add(Orientation.WEST);
                case WEST:
                    connectors.add(Orientation.NORTH);
                    connectors.add(Orientation.WEST);
                    connectors.add(Orientation.SOUTH);
            }
            return connectors;
        }

        public ArrayList<Orientation> getListOfPossibleOri() {
            ArrayList<Orientation> temp = new ArrayList<>();
            temp.add(Orientation.NORTH);
            temp.add(Orientation.EAST);
            temp.add(Orientation.SOUTH);
            temp.add(Orientation.WEST);
            return temp;
        }
    },
    FOURCONN(4) {
        public Orientation getOrientation(Orientation orientation) {
            return Orientation.NORTH;
        }

        public LinkedList<Orientation> setConnectorsList(Orientation orientation) {
            return null;
        }

        public ArrayList<Orientation> getListOfPossibleOri() {
            ArrayList<Orientation> temp = new ArrayList<>();
            temp.add(Orientation.NORTH);
            return temp;
        }
    },
    LTYPE(2) {
        public Orientation getOrientation(Orientation orientation) {
            return orientation;
        }

        public LinkedList<Orientation> setConnectorsList(Orientation orientation) {
            LinkedList<Orientation> connectors = new LinkedList<Orientation>();
            switch (orientation) {
                case NORTH:
                    connectors.add(Orientation.NORTH);
                    connectors.add(Orientation.EAST);
                case EAST:
                    connectors.add(Orientation.EAST);
                    connectors.add(Orientation.SOUTH);
                case SOUTH:
                    connectors.add(Orientation.SOUTH);
                    connectors.add(Orientation.WEST);
                case WEST:
                    connectors.add(Orientation.WEST);
                    connectors.add(Orientation.NORTH);
            }
            return connectors;
        }

        public ArrayList<Orientation> getListOfPossibleOri() {
            ArrayList<Orientation> orientations = new ArrayList<>();
            orientations.add(Orientation.NORTH);
            orientations.add(Orientation.EAST);
            orientations.add(Orientation.SOUTH);
            orientations.add(Orientation.WEST);
            return orientations;
        }
    };

    private int connectors;

    private PieceType(int connectors) {
        this.connectors = connectors;
    }

    public static PieceType getTypefromValue(int value) {
        switch(value){
            case 0:
                return PieceType.VOID;
            case 1:
                return PieceType.ONECONN;
            case 2:
                return PieceType.BAR;
            case 3:
                return PieceType.TTYPE;
            case 4:
                return PieceType.FOURCONN;
            case 5:
                return PieceType.LTYPE;
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
    }

    abstract public Orientation getOrientation(Orientation orientation);

    abstract public LinkedList<Orientation> setConnectorsList(Orientation orientation);

    abstract public ArrayList<Orientation> getListOfPossibleOri();

    public int getNbConnectors() {
        return this.connectors;
    }
}
