package Code.Solve;


import Code.Components.Orientation;
import Code.Components.Piece;
import Code.Components.PieceType;
import Code.GUI.Grid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Checker {

    private static boolean[][] checked;

    /**
     * Constructs a grid from a file
     * @param inputFile from wich the grid will be read
     * @return the grid created from the file
     * @exception FileNotFoundException if the file isn't found
     */
    public static Grid buildGrid(String inputFile) throws FileNotFoundException {
        BufferedReader fr = new BufferedReader(new FileReader(inputFile));
        try {
            Grid grid = new Grid(Integer.parseInt(fr.readLine()), Integer.parseInt(fr.readLine()));
            for (int i = 0; i < grid.getHeight(); i++) {
                for (int j = 0; j < grid.getWidth(); j++) {
                    String[] str = fr.readLine().split(" ");
                    if (str.length != 0) {
                        grid.setPiece(i, j, new Piece(i, j, PieceType.getTypeFromValue(Integer.parseInt(str[0])), Orientation.getOriFromValue(Integer.parseInt(str[1]))));
                    }
                }
            }
            return grid;
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NumberFormatException e){

        }
        return null;
    }

    /**
     *  checks if the grid is solved or not.
     * @return boolean true If the grid is solved, false otherwise
     */
    public static boolean check(Grid grid) {
        int height=grid.getHeight();
        int width= grid.getWidth();
        // Initially the pieces aren't checked
        checked = new boolean[height][width];
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                checked[i][j] = false;
            }
        }
        boolean solved = true; // If the whole grid is solved
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                boolean next = false;
                try {
                    // We check if the connectors of each piece match
                    LinkedList<Orientation> currConnectors = new LinkedList<>(grid.getPiece(i, j).getConnectors());
                } catch (NullPointerException e) {
                    next = true;
                }
                if (next) {
                    break;
                }
                LinkedList<Orientation> connectors = new LinkedList<>(grid.getPiece(i, j).getConnectors());
                boolean matchesNeighbors = true; // True if the piece (i,j) matches all its neighbors
                for (Orientation ori : connectors) {
                    boolean matched = false; //  True if the current connector of the piece(i, j) checked matches its connector's neighbor.
                    switch (ori.getValue()) {
                        // NORTH, we check if the piece above has a connector SOUTH
                        case 0:
                            try {
                                if (grid.getPiece(i - 1, j).getConnectors() != null) {
                                    for (Orientation oriNeighbor : grid.getPiece(i - 1, j).getConnectors()) {
                                        if (oriNeighbor.getValue() == 2) {
                                            matched = true;
                                        }
                                    }
                                    // if no matched connector had been found, return false
                                    if (matched == false) {
                                        solved = false;
                                        matchesNeighbors = false;
                                    }
                                }
                            } catch (IndexOutOfBoundsException e) {
                                solved = false;
                                matchesNeighbors = false;
                            }
                            break;
                        // EAST, we check if the piece on the right has a connector WEST
                        case 1:
                            try {
                                if (grid.getPiece(i, j+1).getConnectors() != null) {
                                    for (Orientation oriNeighbor : grid.getPiece(i, j + 1).getConnectors()) {
                                        if (oriNeighbor.getValue() == 3) {
                                            matched = true;
                                        }
                                    }
                                    // if no matched connector had been found, return false
                                    if (matched == false) {
                                        solved = false;
                                        matchesNeighbors = false;
                                    }
                                }
                            } catch (IndexOutOfBoundsException e) {
                                solved = false;
                                matchesNeighbors = false;
                            }
                            break;
                        // SOUTH, we check if the piece below has a connector NORTH
                        case 2:
                            try {
                                if (grid.getPiece(i + 1, j).getConnectors() != null) {
                                    for (Orientation oriNeighbor : grid.getPiece(i + 1, j).getConnectors()) {
                                        if (oriNeighbor.getValue() == 0) {
                                            matched = true;
                                        }
                                    }
                                    // if no matched connector had been found, return false
                                    if (matched == false) {
                                        solved = false;
                                        matchesNeighbors = false;
                                    }
                                }
                            } catch (IndexOutOfBoundsException e) {
                                solved = false;
                                matchesNeighbors = false;
                            }
                            break;
                        // WEST, we check if the piece on the left has a connector EAST
                        case 3:
                            try {
                                if (grid.getPiece(i, j - 1).getConnectors() != null) {
                                    for (Orientation oriNeighbor : grid.getPiece(i, j - 1).getConnectors()) {
                                        if (oriNeighbor.getValue() == 1) {
                                            matched = true;
                                        }
                                    }
                                    // if no matched connector had been found
                                    if (matched == false) {
                                        solved = false;
                                        matchesNeighbors = false;
                                    }
                                }
                            } catch (IndexOutOfBoundsException e) {
                                solved = false;
                                matchesNeighbors = false;
                            }
                            break;
                    }
                }
                if (matchesNeighbors) {
                    checked[i][j] = true;
                }
            }
        }
        if (solved) {
            return true;
        }
        return false;
    }


}
