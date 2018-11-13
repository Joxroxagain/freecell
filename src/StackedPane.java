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
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Icon image;

    	// Paint wireframe if list is empty
    	if (cards.isEmpty()) {
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    		
    		return;
    	}
    	
      	// Iterate over the cards and paint each one
		for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
    		image = card.getImage();
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		image.paintIcon(this, g, x, y);
		}
		
    }
	
	
}
