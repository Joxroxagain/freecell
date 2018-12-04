/**
 * Represents a single Tableau pile and its functionality
 * 
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson File: Tableau.java
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
		if (getTopCard().compareTo(c) == 0 && getTopCard().getSuit() == c.getSuit()) // can
																						// we
																						// say
																						// getTopcard.equals(c)?
			return true;

		// Iterate backwards starting with top card and ending at card c
		for (int i = cards.size() - 1; i > cards.indexOf(c); i--) {
			Card current = cards.get(i);
			Card next = cards.get(i - 1);

			// If current is one rank less than next
			if (!next.greaterByOne(current) || next.sameColor(current))
				return false;

		}

		return true;

	}

	@Override
	public boolean canAddTo(Card c) {
		if (!c.sameColor(getTopCard()))
			return getTopCard().greaterByOne(c);
		return false;
	}

}