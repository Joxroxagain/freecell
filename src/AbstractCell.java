/**
 * Represents a single Cell and its functionality
 * @author Joe Scott, Zach Francis, Kevin Dennin, JD Wilson
 * File: Cell.java
 */

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractCell extends AbstractCollection<Card> implements Cell {
 
	protected List<Card> cards;
	
	public AbstractCell() {
		cards = new ArrayList<>();
	}

	public int size() {
		return cards.size();
	}
	
    public boolean add(Card c) {
    	return cards.add(c);
    }
        
    public boolean remove(Card c) {
    	return cards.remove(c);
    }
    
	public boolean isEmpty() {
	    return cards.isEmpty();
	}

    @Override
	public String toString() {
    	String s = "";
    	for (Card c: cards)
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
	
}
