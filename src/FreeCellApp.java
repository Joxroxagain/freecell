import java.awt.Color;

import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application. Instantiates a
 * model and passes it to a new view.
 * 
 * @author Joe Scott
 */
public class FreeCellApp {

	public static void main(String[] args) {
		final Game game = new Game();
		final JFrame view = new AppView(game);
		view.setTitle("Freecell");
		view.getContentPane().setBackground(new Color(51, 204, 51));
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 500);
		view.setVisible(true);
	}

}