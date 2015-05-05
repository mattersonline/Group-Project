
public class WildDogScenario extends EncounterScenario {
	private int healthMod;
	public WildDogScenario(){
		super.enemy = new WildDog();
	}
	public WildDogScenario(double str){
		super.enemy = new Coyote(str);
	}
	
	
	public int getHealthMod(){
		return healthMod;
	}
	
	public String toString()
	{
		return "S";
	}
	public Item[] addItem(){
		return null;
	}
}
