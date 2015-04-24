import javax.swing.ImageIcon;

public abstract class GamePlayCard extends Card
{
	public GamePlayCard(ImageIcon icon)
	{
		super(icon);
	}
	
	public GamePlayCard(String iconPath)
	{
		super(iconPath);
	}
}
