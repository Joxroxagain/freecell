import java.util.Iterator;

/**
 * Represents a single Tableau pile and its functionality
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Tableau.java
 */

public class Tableau extends AbstractCell {

	public Tableau() {
		super();
	}

	public boolean add(Card c) {
		return cards.add(c);
	}
	
	public boolean canMoveToTableau(Card c) {
		String topCardSuit = getTopCard().getSuit().toString();
		String moveCardSuit = c.getSuit().toString();
		
		if ((topCardSuit == "spades" || topCardSuit == "clubs") 
				&& (moveCardSuit == "spades" || moveCardSuit == "clubs"))
			return false;
		if ((topCardSuit== "hearts" || topCardSuit == "diamonds") 
				&& (moveCardSuit == "hearts" || moveCardSuit == "diamonds"))
			return false;
	    if (!(getTopCard().compareTo(c) == 1))
	    	return false;
	    else
	    	return true;
	}
	
	public boolean canMoveFromTableau(Card c) {
		// If card is the top card (can always move top card)
		if (getTopCard().compareTo(c) == 0
				&& getTopCard().getSuit() == c.getSuit())
			return true;
				
		// Iterate backwards starting with top card and ending at card c
		for (int i = cards.size() - 1; i > cards.indexOf(c); i--) {
			Card current = cards.get(i);
			Card next = cards.get(i - 1);

			if (current.compareTo(next) == -1) {
				// If black
				if ((current.getSuit().toString() == "spades" || current.getSuit().toString() == "clubs"))
					return current.getSuit().toString() == "hearts" || current.getSuit().toString() == "diamonds";
				// If red
				if (current.getSuit().toString() == "hearts" || current.getSuit().toString() == "diamonds") 
					return current.getSuit().toString() == "spades" || current.getSuit().toString() == "clubs";
			} else {
				return false;
			}
		}
		
		return false;
		
	}
	
	
}