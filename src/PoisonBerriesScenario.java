
public class PoisonBerriesScenario extends ScenarioCard {
	@Override
	public void runScript() {
		int choice;
		String message1 = "You find some bright purple berries! What do you do?";
		String title1 = "Berrie Bush";
		String [] options1 = {"Leave them", "Eat some"};
		String default1 = "Leave them";
		
		String alert1 = "The berries taste horrible. They were poisoned. You have been weakened for 2 combats\n" +
				"You have also lost 20 health points but they recover your hunger slightly";
		
		choice = WildernessSurvival.gui.prompt(message1, title1, null, options1, default1);
		
		if(choice == 1){
			WildernessSurvival.gui.alert(alert1);
			WildernessSurvival.player.weaken(2);
			WildernessSurvival.player.updateHealth(-20);
			WildernessSurvival.player.updateEnergy(20);
		}
		WildernessSurvival.gui.update();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
