
public class HealthyBerriesScenario extends ScenarioCard {

	@Override
	public void runScript() {
		int choice;
		String message1 = "You find some dull yellow berries! What do you do?";
		String title1 = "Berrie Bush";
		String [] options1 = {"Leave them", "Eat some"};
		String default1 = "Leave them";
		
		String alert1 = "The berries are sweet and you regain some of your hunger and health";
		
		choice = WildernessSurvival.gui.prompt(message1, title1, null, options1, default1);
		
		if(choice == 1){
			WildernessSurvival.gui.alert(alert1);
			WildernessSurvival.player.updateHealth(30);
			WildernessSurvival.player.updateEnergy(30);
		}
		WildernessSurvival.gui.update();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
