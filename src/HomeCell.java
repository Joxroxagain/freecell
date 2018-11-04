/**
 * Represents a single Home Cell pile and its functionality
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: HomeCell.java
 */

public class HomeCell extends Cell {

	public HomeCell() {
		super();
	}
	
	public boolean canMoveToHome(Card c) {
		if ((isEmpty()) & (c.getRank() == 1))
			return true;
		if (!constructor[length(constructor)].getSuit() == c.getSuit())
			return false;
		if (!constructor[length(constructor)].compareTo(c) == -1)
			return false;
		else
			return true;
	}
	

}
