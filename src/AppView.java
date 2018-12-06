import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * The main window for dealing from a deck of cards.
 * 
 * @author lambertk
 *
 */
public class AppView extends JFrame {

	// Game instance variable
	private Game game;

	private AppViewInformer appViewInformer;

	// Layout variables
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints constraints = new GridBagConstraints();

	// Tracks first panel that is clicked
	private AbstractPane fromPane = null;

	// instance variable of a list of cards in tableau
	private List<Card> tablist = new ArrayList<Card>();

	// Panes
	private SinglePane[] freeCellPanes = new SinglePane[4];
	private SinglePane[] homeCellPanes = new SinglePane[4];
	private StackedPane[] tableauPanes = new StackedPane[8];

	public AppView(Game game) {

		// Sets game variable
		this.game = game;

		// Instantiate appViewInformer
		appViewInformer = new AppViewInformer();

		// Create layout and constraints objects and set the window's layout.
		setLayout(layout);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.insets = new Insets(0, 0, 0, 0);

		// Freecells
		for (int x = 0; x < 4; x++) {
			Cell cell = game.getFreeCell(x);
			freeCellPanes[x] = new SinglePane(cell, appViewInformer);
			addGB(freeCellPanes[x], x, 1);
		}

		// Homecells
		for (int x = 0; x < 4; x++) {
			Cell cell = game.getHomeCell(x);
			homeCellPanes[x] = new SinglePane(cell, appViewInformer);
			addGB(homeCellPanes[x], x + 4, 1);
		}

		constraints.weightx = 2.0;
		constraints.weighty = 2.0;

		// Tableaux
		for (int x = 0; x < 8; x++) {
			Cell cell = game.getTableau(x);
			tableauPanes[x] = new StackedPane(cell, appViewInformer);
			addGB(tableauPanes[x], x, 2);
		}

		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;

		// Create new game button
		JButton newGameButton = new JButton("New game");
		newGameButton.setPreferredSize(new Dimension(0, 30));

		addGB(newGameButton, 3, 3);

		// Action listener for new game button
		newGameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.reset();

				for (int x = 0; x < 8; x++) {

					// Redraw tableaux
					tableauPanes[x].repaint();

					// redraw Homecells and Freecells
					if (x < 4) {
						freeCellPanes[x].repaint();
						homeCellPanes[x].repaint();
					}

				}

			}
		});

		constraints.gridwidth = 3;

		// Add labels for home and free cells
		JLabel freeCellLabel = new JLabel();
		freeCellLabel.setText("Free cells");
		freeCellLabel.setPreferredSize(new Dimension(0, 20));
		addGB(freeCellLabel, 2, 0);

		JLabel homeCellLabel = new JLabel();
		homeCellLabel.setText("Home cells");
		homeCellLabel.setPreferredSize(new Dimension(0, 20));
		addGB(homeCellLabel, 5, 0);

	}

	private void addGB(Component component, int x, int y) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(component, constraints);
	}

	// Private class that overrides ViewInformer to receive the
	// panelPressed method
	private class AppViewInformer implements ViewInformer {

		@Override
		public void panelPressed(AbstractPane pane) {

			if (fromPane == null) {
				fromPane = pane;
			} else if (fromPane.getCell() instanceof Tableau) {

				game.makeMultipleMoves((AbstractCell) fromPane.getCell(), (AbstractCell) pane.getCell());
				
//					if (fromPane == tableauPanes[i]) {// If It's a tableau
//
//					}
//					// Add all cards into tablist
//					// check to see how many cards can move by iterating through the list
//
//					else {

//					}

				

			}
		}
	}
}
