import java.awt.Color;
import javax.swing.ImageIcon;

public abstract class ScenarioCard extends GamePlayCard
{
	public ScenarioCard()
	{
		super(new ImageIcon("src/images/stump.png"));
		super.setBackgroundColor(new Color(0xDECB97));
	}
	
	public abstract void runScript();
}
