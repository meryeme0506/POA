package fr.dauphine.JavaAvance.Solve;


import java.util.Random;
import java.io.*;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.DisplayUnicode;
import fr.dauphine.JavaAvance.GUI.Grid;

/**
 * Generate a solution, number of connexe composant is not finished
 *
 */

public class Generator {

	/**
	 * @param fileName
	 *            file name
	 * @throws IOException
	 *             - if an I/O error occurs.
	 * @return a File that contains a grid filled with pieces (a level)
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */

	public static Grid generateLevel(String fileName, Grid inputGrid) {
		try {
			FileWriter gridtxt = new FileWriter(fileName);
			Grid g = constructLevel(inputGrid);
			int width = g.getWidth();
			int height = g.getHeight();
			gridtxt.write(width);
			gridtxt.write("\n");
			gridtxt.write(height);
			gridtxt.write("\n");
			Piece[][] p = g.getAllPieces();
			for(int i = 0; i < height; i++) {
				for (int j = 0; j <width ; j++) {
					String value = Piece.getTypeFromPiece(p[i][j])+" "+p[i][j].getOrientation().getValue()+"\n";
					gridtxt.write(value);
				}
			}
			gridtxt.close();
			return g;
    	}
		catch (IOException e) {
    	  System.out.println("An error occurred ");
   		 }
		return null;
	}

	/**
	 * Constructs a level by generating an already solved grid, choosing each piece randomly
	 * among the possibilities depending on its position in the grid and its neighbors,
	 * and then shuffling each piece's position.
	 * private because meant to be solely used by generateLevel
	 * @param g the file we want to check
	 * @return the grid, translation of the input file
	 */
	public static Grid constructLevel(Grid g) {
		int height = g.getHeight() * 2 - 1;
		int width = g.getHeight();
		int[][] p = new int[height][width];
		Random random = new Random();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int temp = random.nextInt(2);
				if (temp == 1) {
					p[i][j] = 1;
				} else {
					p[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < height; i+=2) {
			for (int j = 0; j < width; j++) {
				boolean north = false;
				boolean east = false;
				boolean south = false;
				boolean west = false;
				int nb = 0;
				if (j < width - 1 && p[i][j] == 1) {
					west = true;
					nb++;
				}
				if (i > 0 && p[i - 1][j] == 1) {
					north = true;
					nb++;
				}
				if (i < height-1 && p[i + 1][j] == 1) {
					south = true;
					nb++;
				}
				if (j > 0 && p[i][j - 1] == 1) {
					east = true;
					nb++;
				}

				Piece piece = null;
				switch (nb) {
					case 0:
						piece = new Piece(i, j, PieceType.VOID, Orientation.NORTH);
						break;
					case 1:
						piece = new Piece(i, j, PieceType.ONECONN, Orientation.NORTH);
						break;
					case 2:
						if ((north && south) || (east && west))
							piece = new Piece(i, j, PieceType.BAR, Orientation.NORTH);
						else
							piece = new Piece(i, j, PieceType.LTYPE, Orientation.NORTH);
						break;
					case 3:
						piece = new Piece(i, j, PieceType.TTYPE, Orientation.NORTH);
						break;
					case 4:
						piece = new Piece(i, j, PieceType.FOURCONN, Orientation.NORTH);
						break;
				}
				piece.setOrientation(random.nextInt(4));
				g.setPiece(i/2 , j, piece);
			}
		}
		return g;
	}



	public static int[] copyGrid(Grid filledGrid, Grid inputGrid, int i, int j) {
		Piece p;
		int hmax = inputGrid.getHeight();
		int wmax = inputGrid.getWidth();

		if (inputGrid.getHeight() != filledGrid.getHeight())
			hmax = filledGrid.getHeight() + i; // we must adjust hmax to have the height of the original grid
		if (inputGrid.getWidth() != filledGrid.getWidth())
			wmax = filledGrid.getWidth() + j;

		int tmpi = 0;// temporary variable to stock the last index
		int tmpj = 0;

		// DEBUG System.out.println("copyGrid : i =" + i + " & j = " + j);
		// DEBUG System.out.println("hmax = " + hmax + " - wmax = " + wmax);
		for (int x = i; x < hmax; x++) {
			for (int y = j; y < wmax; y++) {
				// DEBUG System.out.println("x = " + x + " - y = " + y);
				p = filledGrid.getPiece(x - i, y - j);
				// DEBUG System.out.println("x = " + x + " - y = " +
				// y);System.out.println(p);
				inputGrid.setPiece(x, y, new Piece(x, y, p.getType(), p.getOrientation()));
				// DEBUG System.out.println("x = " + x + " - y = " +
				// y);System.out.println(inputGrid.getPiece(x, y));
				tmpj = y;
			}
			tmpi = x;
		}
		//DEBUGSystem.out.println("tmpi =" + tmpi + " & tmpj = " + tmpj);
		return new int[] { tmpi, tmpj };
	}

}
