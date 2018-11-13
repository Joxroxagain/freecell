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

	private SinglePane[] freeCellPanes = new SinglePane[4];
	private SinglePane[] homeCellPanes = new SinglePane[4];
	private StackedPane[] tableauPanes = new StackedPane[8];
	
	public AppView(Game game) {
		
		this.game = game;
		
		// Create layout and constraints objects and set the window's layout.
		setLayout(layout);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.insets = new Insets(0, 0, 0, 5);

		// Freecells
		for (int x = 0; x < 4; x++) {
			freeCellPanes[x] = new SinglePane(null);
			addGB(freeCellPanes[x], x, 0);
		}
		
		constraints.insets = new Insets(0, 5, 0, 0);

		// Homecells
		for (int x = 0; x < 4; x++) {
			homeCellPanes[x] = new SinglePane(null);
			addGB(homeCellPanes[x], x + 4, 0);
		}

		constraints.weightx = 2.0;
		constraints.weighty = 2.0;
		constraints.insets = new Insets(5, 5, 0, 5);
		
		// Tableaux
		for (int x = 0; x < 8; x++) {
			
			List<Card> cards = game.getTableau(x).getCards();

			// Turn over all cards
			for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
				Card card = (Card) iterator.next();
				card.turn();
			}
			tableauPanes[x] = new StackedPane(cards);

			addGB(tableauPanes[x], x, 1);
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
				game.reset();
				
				for (int x = 0; x < 8; x++) {
					
					// redraw Homecells and Freecells
					if (x < 4) {
						freeCellPanes[x].setCard(null);
						homeCellPanes[x].setCard(null);
					} 
					
					List<Card> cards = game.getTableau(x).getCards();

					// Turn over all cards
					for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
						Card card = (Card) iterator.next();
						card.turn();
					}
					
					// Set tableau cards
					tableauPanes[x].setCard(cards);

				}
				
				
			}
		});
	}

	private void addGB(Component component, int x, int y) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(component, constraints);
	}
	
	
}
