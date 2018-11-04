import java.util.Iterator;

public interface Cell {

	public int size();
	
    public boolean add(Card c);
	
    public boolean remove(Card c);

    public boolean canRemoveFrom(Card c);

    public boolean canAddTo(Card c);

	public Iterator<Card> iterator();

	public void clear();

	public Card pop();
	
	public Card getTopCard();

	
    @Override
	public String toString();
    
}
