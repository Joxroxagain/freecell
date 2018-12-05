import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLayeredPane;

public class StackedPane extends AbstractPane implements ViewInformer, MouseListener {

	public StackedPane(Cell cell, ViewInformer avi) {
		super(cell, avi);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Icon image;

		// Paint wireframe if list is empty
		if (cell == null || cell.isEmpty()) {
			image = Card.getBack();
			g.setColor(Color.yellow);
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = 0;
			g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
			return;
		}

		int i = 0;
		// Iterate over the cards and paint each one
		for (Card c : cell) {
			JLayeredPane layeredPane = new JLayeredPane();
			image = c.getImage();
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = 0 + (25 * i);
			layeredPane.setPreferredSize(new Dimension(x, y));
			layeredPane.addMouseListener(this);
			layeredPane.setBackground(Color.RED);
			image.paintIcon(this, g, x, y);
			i++;
		}

	}

	 public void setCard(List<Card> c) {
		 for (Card card : c)
			 cell.add(card);
		 repaint();
	 }

}
