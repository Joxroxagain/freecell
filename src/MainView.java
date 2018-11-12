import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 *
 */
public class MainView extends JFrame{

    private Game game;

    public MainView(Game game){
        this.game = game;
        CardPanel panel1 = new CardPanel();
        CardPanel panel2 = new CardPanel();

        JButton button = new JButton("Deal");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
//                if (!game.isOver()) {
//                	game.nextMove();
//                	Card card1 = game.getCurrentCard1();
//                	Card card2 = game.getCurrentCard2();
//                	card1.turn();
//                	card2.turn();
//                	panel1.setCard(card1);
//                	panel2.setCard(card2); 	
//                }
            }});
        Container c = getContentPane();
        c.add(panel1, BorderLayout.WEST);
        c.add(panel2, BorderLayout.EAST);

        c.add(button, BorderLayout.SOUTH);
    }
}
