import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author Joe Scott
 *
 */
public class FreeCellApp {

    public static void main(String[] args){
        final Game game = new Game();
        final JFrame view = new AppView(game);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(200, 200);
        view.setVisible(true);
    }
    
}