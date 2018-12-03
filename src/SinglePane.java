import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

public class SinglePane extends AbstractPane {

	private Card card;
	
	public SinglePane(Cell cell) {
		super(cell);
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(card);
	}

	@Override
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Icon image;
    	if (card == null) {
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    	} else {
    		image = card.getImage();
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		image.paintIcon(this, g, x, y);
    	}
    }
	
    public void setCard(Card c){
    	card = c;
    	repaint();
    }
	
}
