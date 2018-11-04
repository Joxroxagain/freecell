/**
 * Represents a single Free Cell pile
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: FreeCell.java
 */

public class FreeCell extends AbstractCell {

	public FreeCell() {
                 
	}

	public boolean canMoveToFree(AbstractCell source) {
		return isEmpty();
	}
}