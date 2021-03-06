
/**
 * Represents a single Cell and its functionality
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Cell.java
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractCell implements Cell {

	protected List<Card> cards;

	public AbstractCell() {
		cards = new ArrayList<>();
	}

	public int size() {
		return cards.size();
	}

	public void add(Card c) {
		cards.add(c);
	}

	public void remove(Card c) {
		cards.remove(c);
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}

	@Override
	public String toString() {
		String s = "";
		for (Card c : cards)
			s += c.toString() + " ";
		return s;
	}

	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}

	public void clear() {
		cards.clear();
	}

	public Card pop() {
		Card card = cards.get(cards.size() - 1);
		cards.remove(cards.size() - 1);
		return card;
	}

	public Card getTopCard() {
		return cards.get(cards.size() - 1);
	}

	public List<Card> getCards() {
		return cards;
	}

	public boolean moveFrom(Cell source) {
		if (this.canMoveFrom(source)) {
			this.add(source.pop());
			return true;
		}else
			return false;
	}
	
	public boolean canMoveFrom(Cell source) {
		return !source.isEmpty() && !(source instanceof HomeCell);
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
}
