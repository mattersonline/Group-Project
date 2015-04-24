import javax.swing.ImageIcon;

public abstract class InventoryItemCard extends Card
{

	public InventoryItemCard(ImageIcon icon) {
		super(icon);
	}

	public InventoryItemCard(String iconPath) {
		super(iconPath);
	}
	
}
