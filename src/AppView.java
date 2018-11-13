import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The main window for dealing from a deck of cards.
 * 
 * @author lambertk
 *
 */
public class AppView extends JFrame {

	private Game game;
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints constraints = new GridBagConstraints();

	public AppView(Game game) {
		JButton widget1 = new JButton("One");
		JButton widget2 = new JButton("Two");
		JButton widget3 = new JButton("Three");

		// Create layout and constraints objects and set the window's layout.
		setLayout(layout);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		int y = 0;
		for (int x = 0; x < 8; x++) {
			// Freecells
			if (x < 4) {
				constraints.insets = new Insets(0, 0, 0, 5);
				addGB(new SinglePane(null), x, y);
			}

			// Homecells
			if (x >= 4 && x < 8) {
				constraints.insets = new Insets(0, 5, 0, 0);
				addGB(new SinglePane(null), x, y);
			}
		}

		constraints.weightx = 2.0;
		constraints.weighty = 2.0;

		constraints.insets = new Insets(5, 5, 0, 5);
		y = 2;
		for (int x = 0; x < 8; x++) {
			List<Card> cards = game.getTableau(x).getCards();

			// Turn over all cards
			for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
				Card card = (Card) iterator.next();
				card.turn();
			}

			addGB(new StackedPane(cards), x, y);
		}

		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.insets = new Insets(5, 5, 0, 5);
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		constraints.gridy = 3;
		constraints.gridx = 3;

		JButton newGameButton = new JButton("New game");

		add(newGameButton, constraints);

		newGameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private void addGB(Component component, int x, int y) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(component, constraints);
	}
}
