import java.util.Arrays;
import java.util.List;

/**
 * Represents the creation of a Free Cell card game and provides logic and
 * functionality for the game
 * 
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson File: Game.java
 */

public class Game {

	private Deck deck;

	private Cell[] tableaux = new Cell[8];
	private Cell[] freeCells = new Cell[4];
	private Cell[] homeCells = new Cell[4];

	public Game() {
		// Create deck
		deck = new Deck();
		// Shuffle the deck
		deck.shuffle();
		// Flip over all cards
		deck.turnAllCards();

		// Fill tableaux array with tableaus
		for (int i = 0; i < tableaux.length; i++) {
			tableaux[i] = new Tableau();
		}

		for (int i = 0; i < freeCells.length; i++) {
			freeCells[i] = new FreeCell();
		}

		for (int i = 0; i < homeCells.length; i++) {
			homeCells[i] = new HomeCell();
		}

		// Deal the cards to empty tableaux
		int i = 0;
		int mod = i % 8;
		while (!deck.isEmpty()) {
			tableaux[mod].add(deck.deal());
			i++;
			mod = i % 8;
		}

	}

	public boolean makeMove(AbstractCell fromPile, AbstractCell toPile) {
		if (canMoveFrom(fromPile) &&
				toPile.canAddTo(fromPile.getTopCard())) {
			toPile.add(fromPile.pop());
			return true;
		}
		return false;
	}

	public boolean makeMultipleMoves(AbstractCell fromPile, AbstractCell toPile) {
		Card bottomCard = toPile.getTopCard();
		for (Card c : fromPile) {
			// If card can be moved to the toPile
			if (bottomCard.greaterByOne(c) && !bottomCard.sameColor(c)) {
				System.out.println("HERE!");
				// Check that all cards below can also be moved
				System.out.println(recursiveCardComparison(fromPile.getCards(), 0, 1));
			}

		}
		return false;

	}

	private boolean recursiveCardComparison(List<Card> cards, int i1, int i2) {
		try {
			Card c1 = cards.get(i1);
			Card c2 = cards.get(i2);
			if (!c1.greaterByOne(c2) || c1.sameColor(c2)) return false;
			return recursiveCardComparison(cards, i1 + 1, i2 + 1);
		} catch (IndexOutOfBoundsException e) {
			return true;
		}
			
	}
	
	private boolean canMoveFrom(AbstractCell source) {
		return !(source.isEmpty() || source instanceof HomeCell);
	}

	public void reset() {
		deck = new Deck();
		deck.shuffle();
		// Flip over all cards
		deck.turnAllCards();

		// Reset tableaux
		for (int i = 0; i < 8; i++) {
			tableaux[i].clear();
		}

		// Reset freeCells and homeCells
		for (int i = 0; i < 4; i++) {
			freeCells[i].clear();
			homeCells[i].clear();
		}

		// Deal the cards to empty tableaux
		int i = 0 % 8;
		int mod = i % 8;
		while (!deck.isEmpty()) {
			tableaux[mod].add(deck.deal());
			i++;
			mod = i % 8;
		}
	}

	@Override
	public String toString() {

		String s = "";

		for (int i = 0; i < 8; i++) {
			s += tableaux[i] + "\n";
		}

		return s;
	}

	public final boolean hasWinner() {
		// Can only tell if the game is won, not if it can be won.
		for (int i = 0; i < 4; i++) {
			if (!(homeCells[i].getTopCard().getRank() == 13))
				return false;
		}

		return true;
	}

	public boolean hasLoser() {
		// Checks to see if freecells are empty
		for (int i = 0; i < 4; i++) {

			if (!(freeCells[i].isEmpty()))
				return false;

			// Check to see if tableau can move between each other
			for (int z = 0; z < 8; z++) {
				Card tabTopCard = tableaux[z].getTopCard();
				for (int b = 0; b < 8; b++) {
					if (!tableaux[b].canAddTo(tabTopCard))
						return false;
				}

				// Check to see if tableau can move to home
				for (int k = 0; k < 8; k++) {
					Card topCard = tableaux[k].getTopCard();
					for (int j = 4; j < 4; j++) {
						if (!homeCells[j].canAddTo(topCard))
							return false;
					}
				}

			}
		}

		return true;

	}

	/*
	 * Getters and setters
	 */

	public Cell getFreeCell(int i) {
		return freeCells[i];
	}

	public Cell getHomeCell(int i) {
		return homeCells[i];
	}

	public Cell getTableau(int i) {
		return tableaux[i];
	}

}
