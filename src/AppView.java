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
    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    
    public AppView(Game game){
    	JButton widget1 = new JButton("One");
        JButton widget2 = new JButton("Two");
        JButton widget3 = new JButton("Three");

        // Create layout and constraints objects and set the window's layout.
        setLayout(layout);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        
        int y = 0;
        for (int x = 0; x < 8; x++) {
        	// Freecells
        	if (x < 4) {
                constraints.insets = new Insets(0, 0, 0, 5);
        		addGB(new JButton(), x, y);
        	}
        	
            
        	// Homecells
        	if (x >= 4 && x < 8) {
                constraints.insets = new Insets(0, 5, 0, 0);
        		addGB(new JButton(), x, y);
        	}
		} 
        
        constraints.weightx = 2.0;
        constraints.weighty = 2.0;
      
        constraints.insets = new Insets(5, 5, 0, 5);
        y = 2;
        for (int x = 0; x < 8; x++) {
    		addGB(new JButton(), x, y);
		} 

    }
    
    private void addGB(Component component, int x, int y) {
    	constraints.gridx = x;
    	constraints.gridy = y;
    	add(component, constraints);
    }
    
}
