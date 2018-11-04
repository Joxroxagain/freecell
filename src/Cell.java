/**
 * Represents a single Cell and its functionality
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Cell.java
 */

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Cell extends AbstractCollection<Card> {

	protected List<Card> cards;
	
	public Cell() {
		cards = new ArrayList<>();
	}

	public int size() {
		return cards.size();
	}
	
    public boolean add(Card c) {
    	return cards.add(c);
    }
        
	public boolean isEmpty() {
	    return false;
	}
	
    @Override
	public String toString() {
	    return null;
	}
	
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
	
	public void toPile(Card c) {
		
	}
	
	public void fromPile(Card c) {
		
	}
	
	public Card topCard() {
		return cards.get(cards.size() - 1);
	}
	
}
