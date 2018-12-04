import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLayeredPane;

public abstract class AbstractPane extends JLayeredPane implements ViewInformer, MouseListener {
	
	protected Cell cell;
	protected ViewInformer appViewInformer;
	
    public AbstractPane(Cell cell, ViewInformer avi){
    	setOpaque(true);
    	addMouseListener(this);
    	this.appViewInformer = avi;
		this.cell = cell;
    }

    public Cell getCell() {
    	return cell;
    }
   
	@Override
	public void mouseClicked(MouseEvent e) {
		panelPressed(getCell());
	}

	@Override
	public void panelPressed(Cell panel) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
