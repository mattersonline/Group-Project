import java.util.ArrayList;

// Human is a Mammal that also has healthpacks and food items
public class Human extends Mammal {

	private int healthPackCount;
	private int foodCount;
	
	public Human()
	{	
		// humans have strength multiplier of 50%
		// (bears might have 70% - 80% or something like that)
		super(.5); 
		this.healthPackCount = 0;
		this.foodCount = 0;
	}
	
	public void useFoodItem()
	{
		if(this.foodCount > 0) // has at least 1
		{
			super.updateEnergy(25);
			this.foodCount--;
		}
	}
	
	public int getHealthPackCount()
	{
		return this.healthPackCount;
	}

<<<<<<< HEAD
	public int getFoodCount()
	{
		return this.foodCount;
	}
	
	public void useHealthPack()
	{
		if(this.healthPackCount > 0) // has at least 1
		{
			super.updateHealth(25);
			this.healthPackCount--;
		}
=======
	public String toString(){
		return "Human";
>>>>>>> refs/remotes/origin/master
	}
}
