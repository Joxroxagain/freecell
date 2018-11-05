public class Tester {

	public static void main(String[] args) {

		//Create a game and deal out the cards to the tableaux
		Game game = new Game();

		// Testing free cells
		while (true)
			if (game.getTableau1().canRemoveFrom(game.getTableau1().getTopCard())
					&& game.getFreeCell1().canAddTo(game.getTableau1().getTopCard())) {
				System.out.println("Moving top card of tableau 1 to free cell 1");
				game.makeMove(game.getTableau1(), game.getFreeCell1());
			} else {
				System.out.println("Cannot make move: free cell 1 already has a card");
				break;
			}
		
		
		
	}

}
