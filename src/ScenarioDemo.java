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
		int newHealth = WildernessSurvival.player.getHealth();
		int newHunger = WildernessSurvival.player.getEnergy();
		WildernessSurvival.gui.log("Your health is now : " + newHealth);
		WildernessSurvival.gui.log("Your hunger is now : " + newHunger);
		
		if(newHealth <= 0)
		{
			WildernessSurvival.gui.log("Your health is empty so resetting health");
			WildernessSurvival.player.addHealth(100);
			WildernessSurvival.gui.log("Your health is now : " + WildernessSurvival.player.getHealth());
		}

		if(newHunger <= 0)
		{
			WildernessSurvival.gui.log("Your hunger is empty so resetting health");
			WildernessSurvival.player.addEnergy(100);
			WildernessSurvival.gui.log("Your health is now : " + WildernessSurvival.player.getEnergy());
		}
		
		WildernessSurvival.gui.updateHealthBar();
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
