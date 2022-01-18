package Code.Solve;


import Code.Components.PieceType;
import Code.GUI.Grid;

/**
 * @Author : Meryeme Haman
 * @Author : Emilie Pathammavong
 * Solves a grid
 */

public class Solver {

	/**
	 * solves a given grid
	 * @param grid Grid
	 * @return the solved grid
	 */
	public static Grid solveGrid(Grid grid) {
		return solve(0, 0, grid);
	}

	/**
	 * solves a grid
	 * @param i the first line
	 * @param j the first column
	 * @param grid the given grid
	 * @return the solved grid
	 */
	public static Grid solve(int i, int j, Grid grid) {
		boolean type = false;
		if (Checker.check(grid)) {
			return grid;
		}
		if (i == grid.getHeight() || j == grid.getWidth()) {
			return null;
		}
		Grid grid1 = new Grid(grid);
		Grid grid2 = new Grid(grid);
		Grid grid3 = new Grid(grid);
		Grid grid4 = new Grid(grid);
		if (grid.getPiece(i, j).getType() != PieceType.VOID) {
			grid2.getPiece(i, j).turn();
			grid3.getPiece(i, j).turn();
			grid3.getPiece(i, j).turn();
			grid4.getPiece(i, j).turn();
			grid4.getPiece(i, j).turn();
			grid4.getPiece(i, j).turn();
		} else {
			type = true;
		}
		if (j == grid.getWidth() - 1) {
			j = 0;
			i += 1;
		} else {
			j += 1;
		}


		if (type) {
			return solve(i, j, grid1);
		}
		Grid grid1New = solve(i, j, grid1);
		if (grid1New != null) {
			return grid1New;
		}
		Grid grid2New = solve(i, j, grid2);
		if (grid2New != null) {
			return grid2New;
		}
		Grid grid3New = solve(i, j, grid3);
		if (grid3New != null) {
			return grid3New;
		}
		return solve(i, j, grid4);
	}


}
