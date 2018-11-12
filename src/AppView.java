import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 *
 */
public class AppView extends JFrame{

    private Game game;

    public AppView(Game game){
        this.game = game;
        SinglePane pane1 = new SinglePane(null);
        StackedPane pane2 = new StackedPane(null);

        JButton button = new JButton("Deal");

        Container c = getContentPane();
        c.add(pane1, BorderLayout.CENTER);
        c.add(pane2, BorderLayout.EAST);

        c.add(button, BorderLayout.SOUTH);
    }
    
}
