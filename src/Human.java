import java.util.ArrayList;

// Human is a Mammal that also has an inventory of items
public class Human extends Mammal {

	private ArrayList<Item> inventory;
	
	public Human()
	{	
		// humans have strength multiplier of 5
		// (bears might have 7 - 10 or something like that)
		super(5); 
		this.inventory = new ArrayList<Item>();
	}
	
	public Item[] getInventory()
	{
		return this.inventory.toArray(new Item[]{});
	}

}
