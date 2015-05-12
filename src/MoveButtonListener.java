import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MoveButtonListener implements MouseListener {
	private Direction directionToMove;
	public MoveButtonListener(Direction direction) {
		this.directionToMove = direction;
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	@Override
	public void mousePressed(MouseEvent arg0) {}
	
	@Override
	public void mouseExited(MouseEvent arg0) {}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		WildernessSurvival.gui.movePlayer(this.directionToMove);
		WildernessSurvival.gui.refocus();
	}
}
