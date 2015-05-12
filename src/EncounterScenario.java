import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Random;


public abstract class EncounterScenario extends ScenarioCard {
	protected Mammal enemy;
	protected boolean hasAttacked = false;
	Random random = new Random();
	public void runScript(){
		String[] choices1 = {"Attack", "Run"};
		int choice;
		WildernessSurvival.gui.log("Sample script");
		WildernessSurvival.gui.log("you are being attacked by a " + enemy.toString());
		choice = WildernessSurvival.gui.prompt("You are being attacked by a " + enemy.toString(), enemy.toString() + " Attack",
				null, choices1, "Attack");
		// CREDIT: Online chapter 38 section 38.6.4
		/*JOptionPane.showOptionDialog(null, 
				"You are being attacked by a " + enemy.getClass().getTypeName() + "! What would you like to do? ", 
				"You are being attacked", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE, 
				new ImageIcon("src/images/player.png"), 
				new Object[]{"run away", "fight"}, 
				"fight");*/
		if(choice == 0){
			enemy.attack(WildernessSurvival.player);
			if(random.nextInt(10) > 5){
				WildernessSurvival.gui.alert("The " + enemy.toString() + " has yielded some edible meat");
				WildernessSurvival.player.addFood(1);
			}
			hasAttacked = true;
		}
		else {
			if(random.nextInt(75) + (WildernessSurvival.player.getEnergy()*.2) < 75){
				WildernessSurvival.gui.alert("You have have failed to run away!\nThe " + enemy.toString() + " attacks!");
				enemy.attack(WildernessSurvival.player);
				if(random.nextInt(10) > 5){
					WildernessSurvival.gui.alert("The " + enemy.toString() + " has yielded some edible meat");
					WildernessSurvival.player.addFood(1);
				}
				hasAttacked = true;
			}
			else {
				WildernessSurvival.gui.alert("You have successfully ran away!");
			}
		}
		WildernessSurvival.player.updateWeakenedCounter(-1);
		WildernessSurvival.gui.update();
		
		WildernessSurvival.gui.updateHealthBar();
	}
	public boolean getHasAttacked(){
		return hasAttacked;
	}
	public abstract int getHealthMod();
	public abstract Item[] addItem();
}
