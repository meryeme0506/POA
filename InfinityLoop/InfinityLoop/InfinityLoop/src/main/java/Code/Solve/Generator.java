package Code.Solve;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import Code.Components.Orientation;
import Code.Components.Piece;
import Code.Components.PieceType;
import Code.GUI.Grid;

/**
 * Generate a solution, number of connexe composant is not finished
 *
 */

public class Generator {

	/**
	 * Copy a grid into another one
	 * @param copy grid
	 * @param input input Grid
	 * @param i index i
	 * @param j index j
	 * @return
	 */
	public static int[] copyGrid(Grid copy, Grid input, int i, int j) {
		Piece p;
		int h = input.getHeight();
		int w = input.getWidth();
	//if both grids don't have the same height we change the size of our copied file to match the input
		if (input.getHeight() != copy.getHeight())
			h = copy.getHeight() + i;
		if (input.getWidth() != copy.getWidth())
			w = copy.getWidth() + j;

		int tmpi = 0;// temporary variable to stock the last index
		int tmpj = 0;

		for (int x = i; x < h; x++) {
			for (int y = j; y < w; y++) {
				p = copy.getPiece(x - i, y - j);
				input.setPiece(x, y, new Piece(x, y, p.getType(), p.getOrientation()));
				tmpj = y;
			}
			tmpi = x;
		}
		return new int[] { tmpi, tmpj };
	}

	/**
	 * writes a grid into a file
	 * @param name name of the file
	 * @param grid the grid we wand write
	 */
	public static void gridToFile(String name, Grid grid) {
		try {

			FileWriter myWriter = new FileWriter(name);
			myWriter.write(grid.getWidth()+"\n");
			myWriter.write(grid.getHeight()+"\n");
			Piece[][] pieces = grid.getPieces();
			for(int i = 0; i < grid.getHeight(); i++) {
				for (int j = 0; j < grid.getWidth(); j++) {
					//for each piece in the grid write the value of it in the file
					String value = Piece.getIntTypeFromPiece(pieces[i][j])+" "+pieces[i][j].getOrientation().getValue()+"\n";
					myWriter.write(value);
				}
			}
			myWriter.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * generates a solvable grid
	 * @param fname
	 *            file name
	 * @param grid the grid we want generate
	 * @throws IOException
	 *             - if an I/O error occurs.
	 * @return a File that contains a grid filled with pieces (a level)
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static Grid generateLevel(String fname, Grid grid) {
		Random random = new Random();
		int height =grid.getHeight();
		int width =grid.getWidth();

		//set the new Height
		int newHeight = height * 2 - 1;
		int[][] input = new int[newHeight][width];

		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < width; j++) {
				if (random.nextInt(0, 2) == 1) {
					input[i][j] = 1;
				} else {
					input[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < newHeight; i+=2) {
			for (int j = 0; j < width; j++) {
				boolean north = false;
				boolean east = false;
				boolean south = false;
				boolean west = false;
				int nb = 0;
				if (j < width - 1 && input[i][j] == 1) {
					west = true;
					nb++;
				}
				if (i > 0 && input[i - 1][j] == 1) {
					north = true;
					nb++;
				}
				if (i < height * 2 - 2 && input[i + 1][j] == 1) {
					south = true;
					nb++;
				}
				if (j > 0 && input[i][j - 1] == 1) {
					east = true;
					nb++;
				}


				Piece piece = null;
				// If the piece has no connector it must be VOID and oriented to the north
				if (nb == 0) {
					piece = new Piece(i, j, PieceType.VOID, Orientation.NORTH);
				}
				// If the piece has one connector, it must be ONECONN and oriented to the north
				else if (nb == 1) {
					piece = new Piece(i, j, PieceType.ONECONN, Orientation.NORTH);
				}
				// If the piece has two connector
				else if (nb == 2) {
					// if it has a neighbor in the west and the south or in east and the west it must be a Bar oriented to the north
					if ((north && south) || (east && west))
						piece = new Piece(i, j, PieceType.BAR, Orientation.NORTH);
						// a LTYPE otherwise
					else
						piece = new Piece(i, j, PieceType.LTYPE, Orientation.NORTH);
				}
				// If the piece has 3 connectors, it must be TTYPE and oriented to the north
				else if (nb == 3) {
					piece = new Piece(i, j, PieceType.TTYPE, Orientation.NORTH);
				}
				// If the piece has 4 connectors it must be FOURCONN and oriented to the north
				else if (nb == 4) {
					piece = new Piece(i, j, PieceType.FOURCONN, Orientation.NORTH);
				}
				//Shuffle the positions
				piece.setOrientation(random.nextInt(4));
				grid.setPiece(i / 2, j, piece);
			}
		}
		gridToFile(fname, grid);
		return grid;
	}
}