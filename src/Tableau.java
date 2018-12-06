import java.util.ArrayList;

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
	public boolean canMoveFrom(Cell source) {
		ArrayList<Card> tempList = new ArrayList<Card>();
		for (Card c : source) {
			tempList.add(c);
		}
		Card current = tempList.get(0);
		Card next = tempList.get(1);
		if (current.compareTo(next)) == 1 
		}
		
		}

	}

	@Override
	public boolean canAddTo(Card c) {
		if (!c.sameColor(getTopCard()))
			return getTopCard().greaterByOne(c);
		return false;
	}
	
	public boolean isOrdered(Cell source) {
		for (Card c : source) {
			Card current = cards.get(0)
	}

}