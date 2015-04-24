import java.awt.Color;
import javax.swing.ImageIcon;


public class FinishCard extends GamePlayCard
{
	public FinishCard()
	{
		super(new ImageIcon("src/images/manwithtrophy.png"));
		super.setBackgroundColor(new Color(0x12B500));
	}
	public String toString()
	{
		return "X";
	}
}
