import java.util.ArrayList;

// Human is a Mammal that also has health packs and food items
public class Human extends Mammal {

	private int healthPackCount;
	private int foodCount;
	
	public Human()
	{	
		// humans have strength multiplier of 50%
		// (bears might have 70% - 80% or something like that)
		super(.5); 
		this.healthPackCount = 1;
		this.foodCount = 0;
	}
	
	public void addHealthpack(int i){
		healthPackCount += i;
		WildernessSurvival.gui.updateButtons();
	}
	
	public void addFood(int i){
		foodCount += i;
		WildernessSurvival.gui.updateButtons();
	}
	
	public void useFoodItem()
	{
		if(this.foodCount > 0) // has at least 1
		{
			super.updateEnergy(60);
			this.foodCount--;
			WildernessSurvival.gui.updateButtons();
			WildernessSurvival.gui.update();
		}
	}
	
	public int getHealthPackCount()
	{
		return this.healthPackCount;
	}

	public int getFoodCount()
	{
		return this.foodCount;
	}
	
	public void useHealthPack()
	{
		if(this.healthPackCount > 0) // has at least 1
		{
			super.updateHealth(50);
			this.healthPackCount--;
			WildernessSurvival.gui.updateButtons();
			WildernessSurvival.gui.update();
		}
	}
	public String toString(){
		return "Human";
	}
}
