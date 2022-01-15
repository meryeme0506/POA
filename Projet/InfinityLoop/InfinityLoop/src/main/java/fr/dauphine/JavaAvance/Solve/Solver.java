package fr.dauphine.JavaAvance.Solve;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Pair;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;

/**
 * @Author Meryeme Haman
 * @Author Emilie Pathammavong
 * Generate the solution of a given grid
 */
public class Solver {

	// La solution de la grille générée
	private Grid output;



	/**
	 * Une fonction structure la solution de la grille selon 3 situations différentes
	 * @param testPiece la pièce à tester
	 * @param inputGrid La grille d'entrée
	 */
	public void solve(Piece testPiece, Grid inputGrid){

		//Pas possible de résoudre le niveau avec les choix actuels
		if (inputGrid.connected()) {
			System.out.println("SOLVED:True");
			output = new Grid(inputGrid.getHeight(),inputGrid.getWidth());
			Generator.copyGrid(inputGrid,output,0,0);
			return;
		}
		//Pas possible de résoudre le niveau avec les choix actuels
		if(output!=null){
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
		return output;
	}

	// Exhaustive Solving
	public Grid possibleGrid(Grid inputGrid) {
		int w = inputGrid.getWidth();
		int h = inputGrid.getHeight();
		Grid output = new Grid(h, w);
		Piece[][] p = inputGrid.getAllPieces();
		ArrayList<Orientation> orientations = new ArrayList<>(); // Les orientations possibles
		for (int i = 0; i < h; i++) { // Parcours de toutes les lignes de la grille
			for (int j = 0; j < h; j++) { //Parcours de toutes les colonnes de la grille
				// Traitement des positions où on peut avoir que deux pièces ONECONN et LTYPE
				if (i == 0 && j == 0) { // La première pièce en haut à gauche
					if (p[i][j].getType().equals(PieceType.ONECONN)) {
						orientations.add(Orientation.EAST);
						orientations.add(Orientation.SOUTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					} else if (p[i][j].getType().equals(PieceType.LTYPE)) { // LTYPE
						orientations.add(Orientation.EAST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}
				} else if (i == 0 && j == w - 1) { // La dernière pièce en haut: deux pièces possibles
					if (p[i][j].getType().equals(PieceType.ONECONN)) {
						orientations.add(Orientation.WEST);
						orientations.add(Orientation.SOUTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					} else if (p[i][j].getType().equals(PieceType.LTYPE)) {
						orientations.add(Orientation.EAST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}
				} else if (i == h - 1 && j == 0) { // La pièce en bas à gauche
					if (p[i][j].getType().equals(PieceType.LTYPE)) {
						orientations.add(Orientation.NORTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					} else if (p[i][j].getType().equals(PieceType.ONECONN)) {
						orientations.add(Orientation.NORTH);
						orientations.add(Orientation.EAST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}
				} else if (i == h - 1 && j == w - 1) { // La dernière pièce en bas à droite
					if (p[i][j].getType().equals(PieceType.LTYPE)) {
						orientations.add(Orientation.WEST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					} else if (p[i][j].getType().equals(PieceType.ONECONN)) {
						orientations.add(Orientation.NORTH);
						orientations.add(Orientation.WEST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}
				}//Traitement des pièces qui se trouvent entre la première et la dernière pièce de la première lignes en haut
				// On traite toutes les pièces possibles
				else if (i == 0 && (j > 0 && j < w - 1)) {
					if (p[i][j].getType().equals(PieceType.LTYPE)) {
						orientations.add(Orientation.EAST);
						orientations.add(Orientation.SOUTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					} else if (p[i][j].getType().equals(PieceType.ONECONN)) {
						orientations.add(Orientation.EAST);
						orientations.add(Orientation.SOUTH);
						orientations.add(Orientation.WEST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					} else if (p[i][j].getType().equals(PieceType.BAR)) {
						orientations.add(Orientation.EAST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					} else if (p[i][j].getType().equals(PieceType.TTYPE)) {
						orientations.add(Orientation.SOUTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}
				//Traitement des pièces se trouvant à droite entre la première et la dernière ligne
				// On traite toutes les pièces possibles
				}else if((i>0 && i<h-1) && (j==w-1)){
					if(p[i][j].getType().equals(PieceType.LTYPE)){
						orientations.add(Orientation.SOUTH);
						orientations.add(Orientation.WEST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.ONECONN)){
						orientations.add(Orientation.NORTH);
						orientations.add(Orientation.SOUTH);
						orientations.add(Orientation.WEST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.BAR)){
						orientations.add(Orientation.NORTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.TTYPE)){
						orientations.add(Orientation.WEST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}
				}//Traitement des pièces se trouvant à gauche entre la première et la dernière ligne
				// On traite toutes les pièces possibles
				else if((i>0 && i<h-1) && j==0){
					if(p[i][j].getType().equals(PieceType.LTYPE)){
						orientations.add(Orientation.NORTH);
						orientations.add(Orientation.EAST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.ONECONN)){
						orientations.add(Orientation.NORTH);
						orientations.add(Orientation.EAST);
						orientations.add(Orientation.SOUTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.BAR)){
						orientations.add(Orientation.NORTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.TTYPE)){
						ArrayList<Orientation> ar = new ArrayList<Orientation>();
						ar.add(Orientation.EAST);
						p[i][j].setPossibleOrientations(ar);
						orientations.clear();
					}
				}//Traitement des pièces se trouvant dans la dernière ligne entre la première et la dernière pièce
				else if((i==h-1) && (j>0 && j<w-1)){
					if(p[i][j].getType().equals(PieceType.LTYPE)){
						orientations.add(Orientation.WEST);
						orientations.add(Orientation.NORTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.ONECONN)){
						orientations.add(Orientation.WEST);
						orientations.add(Orientation.NORTH);
						orientations.add(Orientation.EAST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.BAR)){
						orientations.add(Orientation.EAST);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}else if(p[i][j].getType().equals(PieceType.TTYPE)){
						orientations.add(Orientation.NORTH);
						p[i][j].setPossibleOrientations(orientations);
						orientations.clear();
					}
				}
				output.setPiece(i,j,p[i][j]);
			}
		}
		 return output;
	}




	public static void main(String[] args) {
	}
}
