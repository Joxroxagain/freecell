/**
 * Interface for the Cell class
 * Authors: Joe Scott, JD Wilson, Kevin Dennin, Zach Francis
 * File: Cell.java
 * Project 6
*/
import java.util.Iterator;

public interface Cell {

    /**
    * Determines the number of Card objects in a Cell
    * @return the number of Card object observations
    */
	public int size();
	
    /**
    * Adds a Card c to a Cell
    * @param Card c - the Card object to be added
    */
    public void add(Card c);
	
    /**
    * Removes a Card c from a Cell
    * @param Card c - the Card object to be removed
    */
    public void remove(Card c);
    
    /**
    * Determines if a cell is empty or not
    * @return boolean of whether cell is empty
    */
    public boolean isEmpty();

    /**
    * Determines if a Card object can be removed from a Cell
    * @param Card c - the Card object to be removed
    * @return either true or false
    */
    public boolean canRemoveFrom(Card c);

    /**
    * Determines if a Card object can be added to a Cell
    * @param Card c - the Card object to be added
    * @return either true or false
    */
    public boolean canAddTo(Card c);

    /**
    * Creates an iterator over the Card object
    * @return an iterator over Card objects
    */
	public Iterator<Card> iterator();

    /**
    * Removes all Card objects from a Cell
    */
	public void clear();

    /**
    * Removes a Card object from a Cell and returns the Card object
    * @return the Card object that was removed
    */
	public Card pop();
	
    /**
    * Returns the top Card object in a Cell
    * @return the top Card object from the Cell 
    */
	public Card getTopCard();

    /**
    * Creates a string representation of a Cell
    * @return the string representation of the Card objects in a Cell
    */
    @Override
	public String toString();
    
}