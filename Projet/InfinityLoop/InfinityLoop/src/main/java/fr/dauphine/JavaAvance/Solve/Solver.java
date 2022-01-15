package fr.dauphine.JavaAvance.Solve;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Objects;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Pair;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;

public class Solver {

	// La solution de la grille générée
	private Grid solutionGrid;

	/**
	 * Une fonction structure la solution de la grille selon 3 situations différentes
	 * @param testPiece la pièce à tester
	 * @param inputGrid La grille d'entrée
	 */
	public void solve(Piece testPiece, Grid inputGrid){
		//Pas possible de résoudre le niveau avec les choix actuels
		if(solutionGrid!=null){
			return;
		}
		//Pas possible de résoudre le niveau avec les choix actuels
		if (inputGrid.connected()) {
			System.out.println("SOLVED:True");
			solutionGrid = new Grid(inputGrid.getHeight(),inputGrid.getWidth());
			Generator.copyGrid(inputGrid,solutionGrid,0,0);
			return;
		}
		//Le niveau n'est pas encore résolu, on choisit une nouvelle pièce (non encore étudiée) et on recommence le jeu pour chaque position possible
		if(testPiece!=null){
			Grid grid = new Grid(inputGrid.getHeight(), inputGrid.getWidth());
			Generator.copyGrid(inputGrid, grid, 0, 0);
			for (Orientation o : testPiece.getPossibleOrientations()) {
				grid.setPiece(testPiece.getPosY(), testPiece.getPosX(), new Piece(testPiece.getPosY(), testPiece.getPosX(), testPiece.getType(), o));
				// Récursivité
				solve(grid.getNextPiece(grid.getPiece(testPiece.getPosY(), testPiece.getPosX())), grid);
			}
		}

	}

	/**
	 * renvoie la grille résolue
	 * @return Grid the inputGrid solved
	 */
	public Grid getSolution(){
		return solutionGrid;

	}
	public static void main(String[] args) {

		// To be implemented

	}
}
