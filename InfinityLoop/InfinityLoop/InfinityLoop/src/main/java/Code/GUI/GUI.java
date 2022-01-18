package Code.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.*;

import Code.Components.Orientation;
import Code.Components.Piece;
import Code.Components.PieceType;
import Code.Solve.Checker;

/**
 * This class handles the GUI
 * 
 *
 */


public class GUI implements ActionListener {

	private final JFrame frame;
	private final int width = 100;
	private final int height = 100;
	JButton[][] buttons;
	Grid grid;
	Checker check;
	/**
	 *
	 * @param inputFile
	 *            String from IO
	 * @throws IOException
	 *             if there is a problem with the gui
	 */

	public static void startGUI(String inputFile) throws NullPointerException {
		Runnable task = new Runnable() {
			public void run() {
				try {
					Grid grid = Checker.buildGrid(inputFile);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							GUI window = null;
							try {
								window = new GUI(grid);
							} catch (MalformedURLException e) {
								e.printStackTrace();
							}
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
	public GUI(Grid grid) throws MalformedURLException {
		this.grid = grid;
		this.frame = new JFrame("InfinityLoops");
		this.buttons = new JButton[grid.getHeight()][grid.getWidth()];
		initializeGrid(grid);
	}


	/**
	 * Creates a GUI gro the grid
	 * @throws MalformedURLException
	 */
	private void initializeGrid(Grid grid) throws MalformedURLException {
		//initialize frame
		frame.setVisible(true);
		frame.getContentPane().setBackground( Color.white );
		frame.setSize(grid.getWidth() * width,grid.getHeight() * height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel for buttons
		JPanel buttonspanel = new JPanel();
		buttonspanel.setLayout(new GridLayout(grid.getHeight(), grid.getWidth()));

		for (int i = 0; i < grid.getHeight(); i++) {
			for (int j = 0; j < grid.getWidth(); j++) {

				ImageIcon icon = new ImageIcon(this.getImageIcon(grid.getPiece(i, j)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
				JButton button = new JButton(icon);
				button.setBackground(Color.white);
				button.setOpaque(true);
				button.setBorderPainted(false);
				buttonspanel.add(button);
				button.addActionListener(this);
				buttons[i][j] = button;
			}
		}
		frame.setBackground(Color.white);
		frame.add(buttonspanel);
		frame.setVisible(true);
	}

	/**
	 * 
	 * @param grid the grid we want to solve
	 * @return Grid  the solved grid
	 * @throws MalformedURLException
	 */
	public static Grid solve( Grid grid) throws MalformedURLException {
		GUI gui = new GUI(grid);
		return gui.solveGrid(0, 0, grid);
	}

	/**
	 * 
	 * @param i index i
	 * @param j index j
	 * @param grid grid
	 * @return Grid the solution of grid
	 * @throws MalformedURLException
	 */
	public Grid solveGrid(int i, int j, Grid grid) throws MalformedURLException {
		boolean voidType = false;
		if (Checker.check(grid)) {
			return grid;
		}
		if (i == grid.getHeight() || j == grid.getWidth()) {
			return null;
		}
		Grid g1 = new Grid(grid);
		Grid g2 = new Grid(grid);
		Grid g3 = new Grid(grid);
		Grid g4 = new Grid(grid);
		if (grid.getPiece(i, j).getType() != PieceType.VOID) {
			g2.getPiece(i, j).turn();
			g3.getPiece(i, j).turn();
			g3.getPiece(i, j).turn();
			g4.getPiece(i, j).turn();
			g4.getPiece(i, j).turn();
			g4.getPiece(i, j).turn();
		} else {
			voidType = true;
		}

		if (j == grid.getWidth() - 1) {
			j = 0;
			i += 1;
		} else {
			j += 1;
		}
		initializeGrid(g1);
		if (voidType) {
			return solveGrid(i, j, g1);
		}
		Grid g1New = solveGrid(i, j, g1);
		if (g1New != null) {
			return g1New;
		}
		initializeGrid(g2);
		Grid g2New = solveGrid(i, j, g2);
		if (g2New != null) {
			return g2New;
		}
		initializeGrid(g3);
		Grid g3New = solveGrid(i, j, g3);
		if (g3New != null) {
			return g3New;
		}
		initializeGrid(g4);
		return solveGrid(i, j, g4);
	}
	/**
	 * Rotates the piece
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < grid.getHeight(); i++) {
			for (int j = 0; j < grid.getWidth(); j++) {
				boolean done=false;
				if (e.getSource() == buttons[i][j]) {
					grid.getPiece(i, j).turn();
					try {
						ImageIcon icon = new ImageIcon(this.getImageIcon(grid.getPiece(i, j)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
						buttons[i][j].setIcon(icon);
						check = new Checker();
						done= check.check(grid);

					} catch (MalformedURLException ex) {
						ex.printStackTrace();
					}
					if(done ==true){
						JOptionPane.showMessageDialog(frame, "SOLVED", "CONGRATULATIONS !!", JOptionPane.PLAIN_MESSAGE);
						break;
					}
				}
			}
		}

		frame.repaint();
	}


	/**
	 * Display the correct image from the piece's type and orientation
	 *
	 * @param p the piece
	 * @return an image icon
	 */
	private ImageIcon getImageIcon(Piece p) throws MalformedURLException {
		String img = "";
		switch (p.getType()) {
			case VOID -> {
				img = "src/main/resources/fr/dauphine/JavaAvance/icons/io/background.png";
			}
			case ONECONN -> {
				switch (p.getOrientation()) {
					case NORTH -> img = "src/main/resources/fr/dauphine/JavaAvance/icons/io/1.png";
					case EAST -> img = "src/main/resources/fr/dauphine/JavaAvance/icons/io/2.png";
					case SOUTH -> img = "src/main/resources/fr/dauphine/JavaAvance/icons/io/3.png";
					case WEST -> img = "src/main/resources/fr/dauphine/JavaAvance/icons/io/4.png";
				}
			}
			case BAR -> {
				switch (p.getOrientation()) {
					case NORTH -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/5.png";
					case EAST -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/6.png";
				}
			}
			case TTYPE -> {
				switch (p.getOrientation()) {
					case NORTH -> img = "src/main/resources/fr/dauphine/JavaAvance/icons/io/7.png";
					case EAST -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/8.png";
					case SOUTH -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/9.png";
					case WEST -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/10.png";
				}
			}
			case FOURCONN -> {
				if (p.getOrientation() == Orientation.NORTH) {
					img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/1.png";
				}
			}
			case LTYPE -> {
				switch (p.getOrientation()) {
					case NORTH -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/icons12.png";
					case EAST -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/13.png";
					case SOUTH -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/14.png";
					case WEST -> img =  "src/main/resources/fr/dauphine/JavaAvance/icons/io/15.png";
				}
			}
		}
		return new ImageIcon(img);
	}


}