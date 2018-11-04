/**
 * Represents a single Free Cell pile
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: FreeCell.java
 */

public class FreeCell extends Cell {

	public FreeCell() {

	}

	public boolean canMoveToFree(Cell source) {
		return isEmpty();
	}
}