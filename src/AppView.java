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
		constraints.insets = new Insets(0, 0, 0, 0);

		// Freecells
		for (int x = 0; x < 4; x++) {
			freeCellPanes[x] = new SinglePane(null);
			addGB(freeCellPanes[x], x, 1);
		}

		// Homecells
		for (int x = 0; x < 4; x++) {
			homeCellPanes[x] = new SinglePane(null);
			addGB(homeCellPanes[x], x + 4, 1);
		}

		constraints.weightx = 2.0;
		constraints.weighty = 2.0;

		// Tableaux
		for (int x = 0; x < 8; x++) {

			Cell cell = game.getTableau(x);

			tableauPanes[x] = new StackedPane(cell);

			addGB(tableauPanes[x], x, 2);
		}

		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;

		JButton newGameButton = new JButton("New game");
		newGameButton.setPreferredSize(new Dimension(0,30));

		addGB(newGameButton, 3, 3);

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
		
		JLabel freeCellLabel = new JLabel();
		freeCellLabel.setText("Free cells");
		freeCellLabel.setPreferredSize(new Dimension(0,20));
		addGB(freeCellLabel, 2, 0);
		
		JLabel homeCellLabel = new JLabel();
		homeCellLabel.setText("Home cells");
		homeCellLabel.setPreferredSize(new Dimension(0,20));
		addGB(homeCellLabel, 5, 0);
		
	}

	private void addGB(Component component, int x, int y) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(component, constraints);
	}

}
