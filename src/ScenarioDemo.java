import java.util.Scanner;
public class ScenarioDemo extends situationScenario{
	private int healthMod;
	
	public ScenarioDemo(){
	}
	
	public void runScript(){
		Coyote enemy = new Coyote();
		WildernessSurvival.gui.log("Sample script");
		WildernessSurvival.gui.log("you are being attacked by a " + enemy.getClass().getTypeName());
		enemy.attack(WildernessSurvival.player);
		WildernessSurvival.gui.log("Your health is now : " + WildernessSurvival.player.getHealth());
		WildernessSurvival.gui.log("Adding 20 Health");
		WildernessSurvival.player.addHealth(50);
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
