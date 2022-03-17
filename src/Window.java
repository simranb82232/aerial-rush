import java.awt.Dimension;

import javax.swing.JFrame;
/**
 * 
 * Window class creates the window of the game
 *
 */
public class Window {
	/**
	 * Constructor for the window of game
	 * Essentially creates the GUI
	 * @param width - width of game screen
	 * @param height - height of game screen
	 * @param title - title of the game
	 * @param game - current game
	 */
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}

}
