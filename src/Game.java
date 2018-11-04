/**
 * Represents the creation of a Free Cell card game and 
 * provides logic and functionality for the game
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Game.java
 */

public class Game {

	public Game() {
	    // Create deck and empty tableau cells
		Deck deck = new Deck();
		Tableau tableau1 = new Tableau();
		Tableau tableau2 = new Tableau();
		Tableau tableau3 = new Tableau();
		Tableau tableau4 = new Tableau();
		Tableau tableau5 = new Tableau();
		Tableau tableau6 = new Tableau();
		Tableau tableau7 = new Tableau();
		Tableau tableau8 = new Tableau();
		
		// Shuffle the deck
		deck.shuffle();
		
		// Deal the cards to empty tableaux
		while(!deck.isEmpty()) {
			tableau1.add(deck.deal());
			tableau2.add(deck.deal());
			tableau3.add(deck.deal());
			tableau4.add(deck.deal());
			tableau5.add(deck.deal());
			tableau6.add(deck.deal());
			tableau7.add(deck.deal());
			tableau8.add(deck.deal());	
		}
		
		// Create the four free cells
		FreeCell freeCell1 = new FreeCell();
		FreeCell freeCell2 = new FreeCell();
		FreeCell freeCell3 = new FreeCell();
		FreeCell freeCell4 = new FreeCell();
		
		// Create four home cells
		HomeCell homeCell1 = new HomeCell();
		HomeCell homeCell2 = new HomeCell();
		HomeCell homeCell3 = new HomeCell();
		HomeCell homeCell4 = new HomeCell();
		
	}

	public boolean makeMove(Cell fromPile, Cell toPile) {
            if(canMoveFrom(fromPile)) {
                toPile.add(fromPile.pop());
                return true;
            }
            return false;
	}
	
	public boolean canMoveFrom(Cell source) {
		return source.isEmpty() || source instanceof HomeCell;
	}
	
}