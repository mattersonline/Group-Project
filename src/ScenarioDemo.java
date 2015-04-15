import java.util.Scanner;
public class ScenarioDemo extends situationScenario{
	private int healthMod;
	
	public ScenarioDemo(){
	}
	
	public void runScript(){
		Coyote enemy = new Coyote();
		WildernessSurvival.log("Sample script");
		WildernessSurvival.log("you are being attacked by an enemy");
		enemy.attack(WildernessSurvival.player);
		WildernessSurvival.log("Your health is now : " + WildernessSurvival.player.getHealth());
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
