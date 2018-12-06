/**
 * Represents a single Free Cell pile
 * 
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson File: FreeCell.java
 */

public class FreeCell extends AbstractCell {

	public FreeCell() {
		super();

	}
	
	public boolean canMoveFrom(Cell source) {
		return super.canMoveFrom(source) && this.isEmpty();
	}

}