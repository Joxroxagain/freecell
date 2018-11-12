import java.util.Arrays; 

public class Tester {

	private static Deck deck;
	
    private static Tableau[] tableaux = new Tableau[8];
    private static FreeCell[] freeCells = new FreeCell[4];
    private static HomeCell[] homeCells = new HomeCell[4];
	
	public static void main(String[] args) {
		
	    // Create deck and empty tableau cells
		deck = new Deck();

		Arrays.fill(tableaux, new Tableau());
		Arrays.fill(freeCells, new FreeCell());
		Arrays.fill(homeCells, new HomeCell());

		// Shuffle the deck
		deck.shuffle();
		
		//Create a game and deal out the cards to the tableaux
		Game game = new Game();

		int i = 0 % 8;
		int mod = i % 8;
		while(!deck.isEmpty()) {
			tableaux[mod].add(deck.deal());
			i++;
			mod = i % 8; 
		}
		
		// Print the game
		System.out.println(game);
		
		
		
		
		// Testing free cells
		while (true)
			if (tableaux[1].canRemoveFrom(tableaux[1].getTopCard())
					&& freeCells[1].canAddTo(tableaux[1].getTopCard())) {
				System.out.println("Moving top card of tableau 1 to free cell 1");
				game.makeMove(tableaux[1], freeCells[1]);
			} else {
				System.out.println("Cannot make move: free cell 1 already has a card");
				break;
			}
		
		// Blindly test tableaux by trying to move the top card from
		// tableau 1 to tableau 2
		if (tableaux[1].canRemoveFrom(tableaux[1].getTopCard())
				&& tableaux[2].canAddTo(tableaux[1].getTopCard())) {
			System.out.println("Can move " + tableaux[1].getTopCard() 
					+ " to tableau 2 which has a " + tableaux[2].getTopCard());
		} else {
			System.out.println("Can NOT move " + tableaux[1].getTopCard() 
					+ " to tableau 2 which has a " + tableaux[2].getTopCard());
		}
		
		
		// Blindly test home cells by trying to move the top card from
		// tableau 1 to home cell 1
		if (tableaux[1].canRemoveFrom(tableaux[1].getTopCard())
				&& homeCells[1].canAddTo(tableaux[1].getTopCard())) {
			System.out.println("Can move " + tableaux[1].getTopCard() 
					+ " to home cell 1 because its an ace!");
		} else {
			System.out.println("Can NOT move " + tableaux[1].getTopCard() 
			+ " to home cell 1 because it is not an ace!");
		}
		
		
	}

}
