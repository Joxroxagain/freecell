public class Tester {

	private static Deck deck;
	
	private static Tableau tableau1;
	private static Tableau tableau2;
	private static Tableau tableau3;
	private static Tableau tableau4;
	private static Tableau tableau5;
	private static Tableau tableau6;
	private static Tableau tableau7;
	private static Tableau tableau8;
	
	private static FreeCell freeCell1;
	private static FreeCell freeCell2;
	private static FreeCell freeCell3;
	private static FreeCell freeCell4;
	
	private static HomeCell homeCell1;
	private static HomeCell homeCell2;
	private static HomeCell homeCell3;
	private static HomeCell homeCell4;
	
	public static void main(String[] args) {
		
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
		
		
		
		//Create a game and deal out the cards to the tableaux
		Game game = new Game();
		// Print the game
		System.out.println(game);
		
		// Testing free cells
		while (true)
			if (tableau1.canRemoveFrom(tableau1.getTopCard())
					&& freeCell1.canAddTo(tableau1.getTopCard())) {
				System.out.println("Moving top card of tableau 1 to free cell 1");
				game.makeMove(tableau1, freeCell1);
			} else {
				System.out.println("Cannot make move: free cell 1 already has a card");
				break;
			}
		
		// Blindly test tableaux by trying to move the top card from
		// tableau 1 to tableau 2
		if (tableau1.canRemoveFrom(tableau1.getTopCard())
				&& tableau2.canAddTo(tableau1.getTopCard())) {
			System.out.println("Can move " + tableau1.getTopCard() 
					+ " to tableau 2 which has a " + tableau2.getTopCard());
		} else {
			System.out.println("Can NOT move " + tableau1.getTopCard() 
					+ " to tableau 2 which has a " + tableau2.getTopCard());
		}
		
		
		// Blindly test home cells by trying to move the top card from
		// tableau 1 to home cell 1
		if (tableau1.canRemoveFrom(tableau1.getTopCard())
				&& homeCell1.canAddTo(tableau1.getTopCard())) {
			System.out.println("Can move " + tableau1.getTopCard() 
					+ " to home cell 1 because its an ace!");
		} else {
			System.out.println("Can NOT move " + tableau1.getTopCard() 
			+ " to home cell 1 because it is not an ace!");
		}
		
		
	}

}
