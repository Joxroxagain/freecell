import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 *
 */
public class MainView extends JFrame{

    private Deck deck;

    public MainView(Deck deck){
        this.deck = deck;
        SinglePane pane = new SinglePane(null);
        
        JButton button = new JButton("Deal");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (! deck.isEmpty()){
                    Card card = deck.deal();
                    card.turn();
                    pane.setCard(card);
                }
            }});
        Container c = getContentPane();
        c.add(pane, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);
    }
}
