import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author lambertk
 *
 */
public class GUIApp{

    public static void main(String[] args){
        final Game game = new Game();
        final JFrame view = new MainView(game);
        view.setLayout(new BorderLayout());
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(200, 200);
        view.setVisible(true);
    }
}