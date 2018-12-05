import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

public class SinglePane extends AbstractPane implements ViewInformer, MouseListener {

	public SinglePane(Cell cell, ViewInformer avi) {
		super(cell, avi);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Icon image;
		if (cell.isEmpty()) {
			image = Card.getBack();
			g.setColor(Color.yellow);
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = (getHeight() - image.getIconHeight()) / 2;
			g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
		} else {
			image = cell.getTopCard().getImage();
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = (getHeight() - image.getIconHeight()) / 2;
			image.paintIcon(this, g, x, y);
		}
	}

	public void setCard(Card c) {
		cell.add(c);
		repaint();
	}

}
