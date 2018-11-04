/**
 * Represents the creation of a Free Cell card game and 
 * provides logic and functionality for the game
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Game.java
 */

public class Game {

	private Deck deck;
	
	private Tableau tableau1;
	private Tableau tableau2;
	private Tableau tableau3;
	private Tableau tableau4;
	private Tableau tableau5;
	private Tableau tableau6;
	private Tableau tableau7;
	private Tableau tableau8;
	
	private FreeCell freeCell1;
	private FreeCell freeCell2;
	private FreeCell freeCell3;
	private FreeCell freeCell4;
	
	private HomeCell homeCell1;
	private HomeCell homeCell2;
	private HomeCell homeCell3;
	private HomeCell homeCell4;

	public Game() {
	    // Create deck and empty tableau cells
		deck = new Deck();
		tableau1 = new Tableau();
		tableau2 = new Tableau();
		tableau3 = new Tableau();
		tableau4 = new Tableau();
		tableau5 = new Tableau();
		tableau6 = new Tableau();
		tableau7 = new Tableau();
		tableau8 = new Tableau();
		
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
		freeCell1 = new FreeCell();
		freeCell2 = new FreeCell();
		freeCell3 = new FreeCell();
		freeCell4 = new FreeCell();
		
		// Create four home cells
		homeCell1 = new HomeCell();
		homeCell2 = new HomeCell();
		homeCell3 = new HomeCell();
		homeCell4 = new HomeCell();
		
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