
public class HealthyBerriesScenario extends ScenarioCard {

	@Override
	public void runScript() {
		int choice;
		String message1 = "You find some dull yellow berries! What do you do?";
		String title1 = "Berrie Bush";
		Object [] options1 = {"Leave them", "Eat some"};
		Object default1 = (Object) "Leave them";
		
		String alert1 = "The berries are sweet and you regain some of your hunger and health";
		
		choice = super.displayDialog(message1, title1, null, options1, default1);
		
		if(choice == 1){
			super.alertDialog(alert1);
			WildernessSurvival.player.updateHealth(30);
			WildernessSurvival.player.updateEnergy(30);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
