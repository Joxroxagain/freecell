/**
 * Represents a single Tableau pile and its functionality
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Tableau.java
 */

public class Tableau extends Cell {

	public Tableau() {
		super();
	}

	public boolean add(Card c) {
		return cards.add(c);
	}
	
	public boolean canMoveToTableau(Card c) {
		String topCardSuit = topCard().getSuit().toString();
		String moveCardSuit = c.getSuit().toString();
		
		if ((topCardSuit == "spades" || topCardSuit == "clubs") 
				&& (moveCardSuit == "spades" || moveCardSuit == "clubs"))
			return false;
		if ((topCardSuit== "hearts" || topCardSuit == "diamonds") 
				&& (moveCardSuit == "hearts" || moveCardSuit == "diamonds"))
			return false;
	    if (!(topCard().compareTo(c) == 1))
	    	return false;
	    else
	    	return true;
	}
	
	
	
}