/**
 * Represents a single Tableau pile and its functionality
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Tableau.java
 */

public class Tableau extends AbstractCell {

	public Tableau() {
		super();
	}

	public void add(Card c) {
		cards.add(c);
	}
	

	@Override
	public boolean canRemoveFrom(Card c) {
		// If card is the top card (can always move top card)
		if (getTopCard().compareTo(c) == 0
				&& getTopCard().getSuit() == c.getSuit())
			return true;
				
		// Iterate backwards starting with top card and ending at card c
		for (int i = cards.size() - 1; i > cards.indexOf(c); i--) {
			Card current = cards.get(i);
			Card next = cards.get(i - 1);

			// If current is one rank less than next
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

	@Override
	public boolean canAddTo(Card c) {
		String topCardSuit = getTopCard().getSuit().toString();
		String moveCardSuit = c.getSuit().toString();
		
		// If suit  is black
		if ((topCardSuit == "spades" || topCardSuit == "clubs") 
				&& (moveCardSuit == "spades" || moveCardSuit == "clubs"))
			return false;
		// If suit is red
		if ((topCardSuit== "hearts" || topCardSuit == "diamonds") 
				&& (moveCardSuit == "hearts" || moveCardSuit == "diamonds"))
			return false;
	    return getTopCard().compareTo(c) == 1;
	}
	
	
}