package fr.dauphine.JavaAvance.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class GUI  implements ActionListener {

	private JFrame gridFrame;
	private final int width = 80;
	private final  int height = 80;
	JButton[][] button;
	Grid output;
	Checker check;

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
					Grid grid = Checker.buildGrid(inputFile);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							GUI window;
							window = new GUI(grid);
							window.gridFrame.setVisible(true);
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
			this.output = grid;
			this.gridFrame = new JFrame("InfinityLoop");
			this.button = new JButton[grid.getHeight()][grid.getWidth()];
			initializeGrid();
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
		JOptionPane.showMessageDialog(gridFrame, "Done", "Congratulations", JOptionPane.PLAIN_MESSAGE);
	}


	private void initializeGrid() throws MalformedURLException {
		gridFrame.setVisible(true);
		gridFrame.getContentPane().setBackground(Color.PINK);
		gridFrame.setSize(output.getWidth() * width,output.getHeight() * height);
		gridFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel for buttons
		JPanel buttonspanel = new JPanel();
		buttonspanel.setLayout(new GridLayout(output.getHeight(), output.getWidth()));



		for (int i = 0; i < output.getHeight(); i++) {
			for (int j = 0; j < output.getWidth(); j++) {
				ImageIcon icon = new ImageIcon(this.getImageIcon(output.getPiece(i, j)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
				JButton jButton = new JButton(getImageIcon(output.getPiece(i, j)));
				jButton.setBackground(Color.white);
				jButton.setOpaque(true);
				jButton.setBorderPainted(false);
				buttonspanel.add(jButton);
				jButton.addActionListener(this);
				button[i][j] = jButton;
			}
		}
		gridFrame.setBackground(Color.pink);
		gridFrame.add(buttonspanel);
		gridFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < output.getHeight(); i++) {
			for (int j = 0; j < output.getWidth(); j++) {
				boolean done=false;
				if (e.getSource() == button[i][j]) {
					//set the piece that was clicked on to the rotated piece in the grid
					output.getPiece(i, j).turn();
					//for each piece that was clicked on we get the image of it and put it in the buttons
					ImageIcon icon = new ImageIcon(this.getImageIcon(output.getPiece(i, j)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
					button[i][j].setIcon(icon);
					check = new Checker();
					done= check.isSolution(output);
					if(done ==true){
						JOptionPane.showMessageDialog(gridFrame, "You Win!", "Winner winner chicken dinner", JOptionPane.PLAIN_MESSAGE);
						break;
					}

				}
			}
		}

		gridFrame.repaint();
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
				path = "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\background.png";
			}
			case ONECONN -> {
				switch (p.getOrientation()) {
					case NORTH -> path = "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\1.png";
					case EAST -> path = "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\2.png";
					case SOUTH -> path = "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\3.png";
					case WEST -> path = "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\4.png";
				}
			}
			case BAR -> {
				switch (p.getOrientation()) {
					case NORTH -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\5.png";
					case EAST -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\6.png";
				}
			}
			case TTYPE -> {
				switch (p.getOrientation()) {
					case NORTH -> path = "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\7.png";
					case EAST -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\8.png";
					case SOUTH -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\9.png";
					case WEST -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\10.png";
				}
			}
			case FOURCONN -> {
				if (p.getOrientation() == Orientation.NORTH) {
					path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\1.png";
				}
			}
			case LTYPE -> {
				switch (p.getOrientation()) {
					case NORTH -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\icons12.png";
					case EAST -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\13.png";
					case SOUTH -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\14.png";
					case WEST -> path =  "C:\\Users\\sarah\\Downloads\\01-Dauphine_Project_Loop\\Dauphine_Project_Loop\\Dauphine_Java_Loop\\src\\main\\resources\\icons\\15.png";
				}
			}
		}
		return new ImageIcon(path);
	}
		
		
		
}


