import java.util.ArrayList;

// Human is a Mammal that also has an inventory of items
public class Human extends Mammal {

	private ArrayList<Item> inventory;
	
	public Human()
	{	
		// humans have strength multiplier of 50%
		// (bears might have 70% - 80% or something like that)
		super(.5); 
		this.inventory = new ArrayList<Item>();
	}
	
	public Item[] getInventory()
	{
		return this.inventory.toArray(new Item[]{});
	}
	
	public void addInventoryItem(Item item)
	{
		this.inventory.add(item);
	}
	
	public void useItem(Item item)
	{
		
	}

}
