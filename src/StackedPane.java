import java.awt.Graphics;
import java.util.List;

public class StackedPane extends AbstractPane {

	private List<Card> cards; 
	
	public StackedPane(List<Card> cards) {
		super();
		this.cards = cards;
	}

	@Override
    public void paintComponent(Graphics g){
		
    }
	
	
}
