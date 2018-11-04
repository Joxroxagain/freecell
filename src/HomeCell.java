/**
 * Represents a single Home Cell pile and its functionality
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: HomeCell.java
 */

public class HomeCell extends AbstractCell {

	public HomeCell() {
		super();
	}
	
	public boolean canMoveToHome(Card c) {
		
		// If empty, allow move if card rank is ace
		if (isEmpty()) {
			return c.getRank() == 1;
		} 
		// If not empty, allow move if cards match suit and rank of card is one higher than top card
		else {
			return getTopCard().getSuit() == c.getSuit()
					&& getTopCard().compareTo(c) == 1;
		}

	}
	

}
