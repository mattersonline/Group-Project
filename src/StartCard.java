import java.awt.Color;
import javax.swing.ImageIcon;

public class StartCard extends GamePlayCard
{
	public StartCard()
	{
		super(new ImageIcon("src/images/startflag.png"));
		super.setBackgroundColor(new Color(0x1158C2));
		super.setShown(true);
	}
	public String toString()
	{
		return "V";
	}
}
