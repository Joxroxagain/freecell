/**
 * Represents a single Free Cell pile
 * 
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson File: FreeCell.java
 */

public class FreeCell extends AbstractCell {

	public FreeCell() {

	}

	@Override
	public boolean canRemoveFrom(Card c) {
		return true;
	}

	@Override
	public boolean canAddTo(Card c) {
		return isEmpty();
	}
}