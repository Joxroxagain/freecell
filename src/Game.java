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
			if (deck.isEmpty()) break;
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

	public boolean makeMove(AbstractCell fromPile, AbstractCell toPile) {
        if(canMoveFrom(fromPile)) {
            toPile.add(fromPile.pop());
            return true;
        }
        return false;
	}
	
	private boolean canMoveFrom(AbstractCell source) {
		return !(source.isEmpty() || source instanceof HomeCell);
	}
	
	public void reset() {
		deck = new Deck();
		deck.shuffle();
		tableau1.clear();
		tableau2.clear();
		tableau3.clear();
		tableau4.clear();
		tableau5.clear();
		tableau6.clear();
		tableau7.clear();
		tableau8.clear();
		freeCell1.clear();
		freeCell2.clear();
		freeCell3.clear();
		freeCell4.clear();
		homeCell1.clear();
		homeCell2.clear();
		homeCell3.clear();
		homeCell4.clear();
		
		// Deal the cards to empty tableaux
		while(!deck.isEmpty()) {
			tableau1.add(deck.deal());
			tableau2.add(deck.deal());
			tableau3.add(deck.deal());
			tableau4.add(deck.deal());
			if (deck.isEmpty()) break;
			tableau5.add(deck.deal());
			tableau6.add(deck.deal());
			tableau7.add(deck.deal());
			tableau8.add(deck.deal());	
		}
	}
	
	@Override
	public String toString() {

		return "\nTableau 1\n" 
				+ tableau1.toString()
				+ "\nTableau 2\n"
				+ tableau2.toString()
				+ "\nTableau 3\n"
				+ tableau3.toString()
				+ "\nTableau 4\n" 
				+ tableau4.toString()
				+ "\nTableau 5\n" 
				+ tableau5.toString()
				+ "\nTableau 6\n" 
				+ tableau6.toString()
				+ "\nTableau 7\n" 
				+ tableau7.toString()
				+ "\nTableau 8\n" 
				+ tableau8.toString();
	}
	
	
	// For testing in the tester class
	public Tableau getTableau1() {
		return tableau1;
	}
	public Tableau getTableau2() {
		return tableau1;
	}
	public FreeCell getFreeCell1() {
		return freeCell1;
	}	
	public HomeCell getHomeCell1() {
		return homeCell1;
	}
}