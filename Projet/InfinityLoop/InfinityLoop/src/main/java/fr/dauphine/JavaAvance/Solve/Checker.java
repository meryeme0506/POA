package fr.dauphine.JavaAvance.Solve;



import fr.dauphine.JavaAvance.Components.*;
import fr.dauphine.JavaAvance.GUI.Grid;
import java.io.*;


public class Checker {

	/**
	 * Translates a level file in a grid, to be checked.
	 * @param inputFile, the file we want to check
	 * @return the grid, translation of the input file
	 */
	public static Grid buildGrid(String inputFile) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		int width = new Integer(reader.readLine());
		int height = new Integer(reader.readLine());
		Grid g = new Grid(width, height);
		Piece piece;
		PieceType pt;
		Orientation ori;
		for (int i = 0 ; i < height ; i++) {
			for (int j = 0 ; j < width ; j++) {
				String p = String.valueOf(reader.read());
				if (p==" ") {
					pt = PieceType.VOID;
					ori = Orientation.NORTH;
				}
				else if (p=="\u2579") {
					pt = PieceType.ONECONN;
					ori = Orientation.NORTH;
				}
				else if (p=="\u257A") {
					pt = PieceType.ONECONN;
					ori = Orientation.EAST;
				}
				else if (p=="\u257B") {
					pt = PieceType.ONECONN;
					ori = Orientation.SOUTH;
				}
				else if (p=="\u2578") {
					pt = PieceType.ONECONN;
					ori = Orientation.WEST;
				}
				else if (p=="\u2502") {
					pt = PieceType.BAR;
					ori = Orientation.NORTH;
				}
				else if (p=="\u2500") {
					pt = PieceType.BAR;
					ori = Orientation.EAST;
				}
				else if (p=="\u2534") {
					pt = PieceType.TTYPE;
					ori = Orientation.NORTH;
				}
				else if (p=="\u251C") {
					pt = PieceType.TTYPE;
					ori = Orientation.EAST;
				}
				else if (p=="\u252C") {
					pt = PieceType.TTYPE;
					ori = Orientation.SOUTH;
				}
				else if (p=="\u2524") {
					pt = PieceType.TTYPE;
					ori = Orientation.WEST;
				}
				else if (p=="\u253C") {
					pt = PieceType.FOURCONN;
					ori = Orientation.NORTH;
				}
				else if (p=="\u2514") {
					pt = PieceType.LTYPE;
					ori = Orientation.NORTH;
				}
				else if (p=="\u250C") {
					pt = PieceType.LTYPE;
					ori = Orientation.EAST;
				}
				else if (p=="\u2510") {
					pt = PieceType.LTYPE;
					ori = Orientation.SOUTH;
				}
				else if (p=="\u2518") {
					pt = PieceType.LTYPE;
					ori = Orientation.WEST;
				}
				piece = new Piece(j,i,pt,ori);
				g.setPiece(i,j,piece);
			}
		}
		reader.close();
		return g;
	}

	/**
	 * returns True if the input file is a solution grid
	 * @return True if the input file is a solution grid
	 */
public static boolean isSolution(String inputFile){
	Grid g = buildGrid(inputFile);
	return g.connected();
}

}
