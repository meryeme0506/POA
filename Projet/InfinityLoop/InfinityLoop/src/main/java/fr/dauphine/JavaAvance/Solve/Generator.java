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

	private static Grid filledGrid;

	/**
	 * @param fileName
	 *            file name
	 * @throws IOException
	 *             - if an I/O error occurs.
	 * @return a File that contains a grid filled with pieces (a level)
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */

	public static void generateLevel(String fileName, Grid inputGrid) {
		try {
      FileWriter gridtxt = new FileWriter(fileName);
			int width = inputGrid.getWidth();
			int height = inputGrid.getHeight();
			Grid g = constructLevel(inputGrid);
			gridtxt.write(width);
			gridtxt.write(height);
			gridtxt.write(g.toString());
      gridtxt.close();
    }
    catch (IOException e) {
      System.out.println("An error occurred.");
      // e.printStackTrace();
    }
	}

	/**
	 * Constructs a level by generating an already solved grid, choosing each piece randomly
	 * among the possibilities depending on its position in the grid and its neighbors,
	 * and then shuffling each piece's position.
	 * private because meant to be solely used by generateLevel
	 * @param g the file we want to check
	 * @return the grid, translation of the input file
	 */
	private static Grid constructLevel(Grid g){
		Piece p;
		for (int i = 0 ; i < g.getWidth() ; i++) {
			for (int j = 0 ; j < g.getHeight() ; j++) {
				int pt=0;
				int ori=0;
				// la première pièce en haut à gauche est la seule qu'on peut choisir
				//  sans prendre en compte voisins car première
				if (i==0 && j==0) {
					pt = new Random().nextInt(3);
					if (pt==1) {
						ori  = new Random().nextInt(2)+1;
					}
					if (pt==2) {
						pt = 5;
						ori = 1;
					}
				}
				// si c'est la ligne d'en haut, on ne s'occupe que du voisin à gauche
				else if (j==0) {
					if (g.getPiece(i-1,j).hasRightConnector()) {
						pt = new Random().nextInt(4);
						if (pt==0) {
							pt = 5;
							ori = new Random().nextInt(2)-1;
						}
						if (pt==1) { ori = 3; }
						if (pt==2) { ori = 1; }
						if (pt==3) { ori = 2; }
					}
					else {
						pt = new Random().nextInt(3);
						if (pt==1) {
							ori = new Random().nextInt(2)+1;
						}
						if (pt==2) {
							pt = 5;
							ori = 1;
						}
					}
				}
				// si c'est la colonne de gauche, on ne s'occupe que du voisin du dessus
				else if (j==0) {
					if (g.getPiece(i-1,j).hasBottomConnector() ) {
						pt = new Random().nextInt(4)+1;
						if (pt==1) { ori = 0; }
						if (pt==2) { ori = 0; }
						if (pt==3) { ori = 1; }
						if (pt==4) {
							pt = 5;
							ori = 0;
						}
					}
					else {
						pt = new Random().nextInt(4);
						if (pt==1) {
							ori = new Random().nextInt(2)+1;
						}
						if (pt==2) {
							ori = 1;
						}
						if (pt==3) {
							pt = 5;
							ori = 1;
						}
					}
				}
				// si c'est la colonne de droite on regarde le voisin au dessus et à gauche
				else if (i==g.getWidth()-1) {
					if (g.getPiece(i,j-1).hasBottomConnector() && g.getPiece(i-1,j).hasRightConnector()) {
						pt = new Random().nextInt(2);
						if (pt==0) {
							pt = 3;
							ori = 3;
						}
						else {
							pt = 5;
							ori = 3;
						}
					}
					else if (g.getPiece(i,j-1).hasBottomConnector()) {
						pt = new Random().nextInt(2)+1;
						ori = 0;
					}
					else if (g.getPiece(i-1,j).hasRightConnector()) {
						pt = new Random().nextInt(2)+1;
						if (pt==1) { ori = 3; }
						else {
							pt = 5;
							ori = 2;
						}
					}
					else {
						pt = new Random().nextInt(2);
						if (pt==0) { ori = 0; }
						if (pt==1) { ori = 2; }
					}
				}
				//  si c'est la dernière ligne, on s'occupe du voisin de gauche et du dessus
				else if (j==g.getHeight()-1) {
					if (g.getPiece(i-1,j).hasRightConnector() && g.getPiece(i,j-1).hasBottomConnector()) {
						pt = 5;
						ori = 3;
					}
					else if (g.getPiece(i-1,j).hasRightConnector()) {
						pt = new Random().nextInt(2)+1;
						if (pt==1) {
							ori = 3;
						}
						if (pt==2) {
							ori = 1;
						}
					}
					else if (g.getPiece(i,j-1).hasBottomConnector()) {
						pt = 1;
						ori = 0;
					}
					else {
						pt = new Random().nextInt(2);
						if (pt==0) {
							ori = 0;
						}
						if (pt==1) {
							ori = 1;
						}
					}
				}
				// sinon, on regarde en haut et à gauche, mais plus de pièces sont autorisé
				else if(j!=0 && i!=0) {
					if (g.getPiece(i-1,j).hasBottomConnector() && g.getPiece(i,j-1).hasRightConnector()) {
						pt = new Random().nextInt(2)+4;
						if (pt==4) {
							ori = 0;
						}
						else {
							ori = 3;
						}
					}
					else if (g.getPiece(i,j-1).hasBottomConnector()) {
						pt = new Random().nextInt(4)+1;
						if (pt==1) {
							ori = 0;
						}
						if (pt==2) {
							ori = 0;
						}
						if (pt==3) {
							ori = 1;
						}
						if (pt==4) {
							pt = 5;
							ori = 0;
						}
					}
					else if (g.getPiece(i-1,j).hasRightConnector()) {
						pt = new Random().nextInt(4)+1;
						if (pt==1) {
							ori = 3;
						}
						if (pt==2) {
							ori = 1;
						}
						if (pt==3) {
							ori = 2;
						}
						if (pt==4) {
							pt = 5;
							ori = 2;
						}
					}
					else {
						pt = new Random().nextInt(2);
						if (pt==0) {
							ori = 0;
						}
						if (pt==1) {
							pt = 1;
						}
					}
				}
				p = new Piece(i,j,pt,ori);
				g.setPiece(i,j,p);
			}
		}
		// on mélange les positions
		for (int k = 0 ; k < g.getWidth() ; k++) {
			for (int l = 0 ; l < g.getHeight() ; l++) {
				int ori = new Random().nextInt(4);
				g.getPiece(k,l).setOrientation(ori);
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
