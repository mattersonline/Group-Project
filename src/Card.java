import java.awt.Color;
import javax.swing.ImageIcon;

public abstract class Card { 
	private boolean shown;
	private ImageIcon icon;
	private Color backgroundColor;
	
	public Card(ImageIcon icon)
	{
		shown = false;
		this.icon = icon;
		this.backgroundColor = Color.WHITE;
	}
	
	public void setBackgroundColor(Color newColor)
	{
		this.backgroundColor = newColor;
	}
	
	public Color getBackgroundColor()
	{
		return this.backgroundColor;
	}
	
	public Card(String iconPath)
	{
		this(new ImageIcon(iconPath));
	}
	
	public abstract String toString();
	
	public boolean isShown()
	{
		return this.shown;
	}
	
	public void setShown(boolean shown)
	{
		this.shown = shown;
	}
	
	public ImageIcon getIcon()
	{
		return this.icon;
	}
}
