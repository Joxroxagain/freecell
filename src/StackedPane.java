import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.Icon;

public class StackedPane extends AbstractPane {

	private List<Card> cards;

	public StackedPane(List<Card> cards) {
		super();
		this.cards = cards;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Icon image;

		// Paint wireframe if list is empty
		if (cards == null || cards.isEmpty()) {
			image = Card.getBack();
			g.setColor(Color.yellow);
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = 0;
			g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());

			return;
		}

		// Iterate over the cards and paint each one
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			image = card.getImage();
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = 0 + (25 * i);
			image.paintIcon(this, g, x, y);
		}

	}

	public void setCard(Card c) {
		// card = c;
		// repaint();
	}

}
