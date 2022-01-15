package fr.dauphine.JavaAvance.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;
import javax.swing.*;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.Solve.Checker;

/**
 * This class handles the GUI
 *
 * @Author Meryeme Haman
 * @Author Emilie Pathammavong
 *
 */
public class GUI {

	private JFrame frame;
	private final int width = 50; // width of the piece
	private final  int height = 50; // height of the piece

	/**
	 * 
	 * @param inputFile
	 *            String from IO
	 * @throws IOException
	 *             if there is a problem with the gui
	 */
	public static void startGUI(String inputFile) throws NullPointerException {
		// We have to check that the grid is generated before to launch the GUI
		// construction
		Runnable task = new Runnable() {
			public void run() {

				try {
					Grid grid = Checker.constructLevel(inputFile);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							GUI window;
							window = new GUI(grid);
							window.frame.setVisible(true);
						}
					});
				} catch (IOException e) {
					throw new NullPointerException("Error with input file");
				}

			}
		};
		new Thread(task).start();

	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public GUI(Grid grid)   {
		try{
			initialize(grid);
		}catch(MalformedURLException e){
			System.out.println("Error : "+e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize(Grid grid) throws MalformedURLException {

		JFrame gridFrame = new JFrame("Level");
		gridFrame.setLayout(new BoxLayout(gridFrame,BoxLayout.LINE_AXIS));
		gridFrame.setBounds(0, 0, grid.getHeight() * height, grid.getWidth() * width);

		for (int i = 0; i < grid.getHeight(); i++) { // Les lignes de la grille
			for (int j = 0; j < grid.getWidth(); j++) { // les colones de la grille
				JButton jButton = new JButton(getImageIcon(grid.getPiece(i, j)));
			}
		}

		gridFrame.setVisible(true);
	}

	/**
	 * Display the correct image from the piece's type and orientation
	 * 
	 * @param p the piece
	 * @return an image icon
	 */
	private ImageIcon getImageIcon(Piece p) {
		String path = "";
		switch (p.getType()) {
			case VOID -> {
				path = "InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/background.png";
			}
			case ONECONN -> {
				switch (p.getOrientation()) {
					case NORTH -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/1.png";
					case EAST -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/2.png";
					case SOUTH -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/3.png";
					case WEST -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/4.png";
				}
			}
			case BAR -> {
				switch (p.getOrientation()) {
					case NORTH -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/5.png";
					case EAST -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/6.png";
				}
			}
			case TTYPE -> {
				switch (p.getOrientation()) {
					case NORTH -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/7.png";
					case EAST -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/8.png";
					case SOUTH -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/9.png";
					case WEST -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/10.png";
				}
			}
			case FOURCONN -> {
				if (p.getOrientation() == Orientation.NORTH) {
					path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/11.png";
				}
			}
			case LTYPE -> {
				switch (p.getOrientation()) {
					case NORTH -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/12.png";
					case EAST -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/13.png";
					case SOUTH -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/14.png";
					case WEST -> path = "file://InfinityLoop/src/main/resources/fr/dauphine/JavaAvance/icons/io/15.png";
				}
			}
		}
		return new ImageIcon(path);
		
		
	}

}
