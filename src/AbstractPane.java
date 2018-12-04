import java.awt.Color;
import java.util.List;

import javax.swing.JLayeredPane;

public abstract class AbstractPane extends JLayeredPane implements ViewInformer {
	
	protected Cell cell;
	
    public AbstractPane(Cell cell){
    	setOpaque(true);
		this.cell = cell;
    }

    public Cell getCell() {
    	return cell;
    }
   


    
}
