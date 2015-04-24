import javax.swing.ImageIcon;

public abstract class Item extends Card{
	private int ID;
	
	public Item(int id, ImageIcon icon)
	{
		super(icon);
		this.ID = id;
	}

	public Item(int id, String iconPath)
	{
		super(iconPath);
		this.ID = id;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public void setID(int id)
	{
		this.ID = id;
	}
	
	public abstract void use();

}
