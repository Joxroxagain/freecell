import java.util.Arrays;

/**
 * Represents the creation of a Free Cell card game and 
 * provides logic and functionality for the game
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Game.java
 */

public  class Game {

	private Deck deck;
	
	private static Tableau[] tableaux = new Tableau[8];
	private static FreeCell[] freeCells = new FreeCell[4];
	private static HomeCell[] homeCells = new HomeCell[4];

	public Game() {
	    // Create deck and empty tableau cells
		deck = new Deck();
		Arrays.fill(tableaux, new Tableau());
		// Create the four free cells
		Arrays.fill(freeCells, new FreeCell());
		// Create four home cells
		Arrays.fill(homeCells, new HomeCell());
		
		// Shuffle the deck
		deck.shuffle();
		
		// Deal the cards to empty tableaux
		int i = 0 % 8;
		int mod = i % 8;
		while(!deck.isEmpty()) {
			tableaux[mod].add(deck.deal());
			i++;
			mod = i % 8; 
		}
	
		
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
		
	    for(int i = 0; i < 8; i++) {
	    	tableaux[i].clear();
	    	    }
	    for(int i = 0; i < 4; i++) {
	    	freeCells[i].clear();
	    	homeCells[i].clear();
	    	    }
		
		// Deal the cards to empty tableaux
		int i = 0 % 8;
		int mod = i % 8;
		while(!deck.isEmpty()) {
			tableaux[mod].add(deck.deal());
			i++;
			mod = i % 8; 
		}
	}
	
	@Override
	public String toString() {

		String s = "";
		
		for(int i = 0; i < 8; i++) {
			s += tableaux[i];
		}
		
		return s;
	}	
	
	public final boolean hasWinner() { //Can only tell if the game is won, not if it can be won.
	for(int i = 0; i < 4; i++) {
		if (!(homeCells[i].getTopCard().getRank() ==  13))
		return false;
	}
	return true;
	}
    public boolean hasLoser() {
    	//Checks to see if freecells are empty
    	for(int i = 0; i < 4; i++) {
    		if (!(freeCells[i].isEmpty()))
    				return false;
    		//Check to see if tableau can move between each other
    		for(int z = 0; z < 8; z++) {
    			Card tabTopCard = tableaux[z].getTopCard();
    		    for(int b = 0; b < 8; b++) {
    		    	if(!tableaux[b].canAddTo(tabTopCard))
    		    		return false;
    		    }
    		//Check to see if tableau can move to home 
    		for(int k = 0; k < 8; k++) {
    			Card topCard = tableaux[k].getTopCard();
    			for (int j = 4; j < 4; j++){
    				if(!homeCells[j].canAddTo(topCard))
    					return false;
    			}
      		}
    		
    }
}return true;
}
    }
