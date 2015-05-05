
public class PoisonBerriesScenario extends ScenarioCard {
	@Override
	public void runScript() {
		int choice;
		String message1 = "You find some bright purple berries! What do you do?";
		String title1 = "Berry Bush";
		Object [] options1 = {"Leave them", "Eat some"};
		Object default1 = (Object) "Leave them";
		
		String alert1 = "The berries taste horrible. They were poisoned. You have been weakened for 5 turns";
		
		choice = super.displayDialog(message1, title1, null, options1, default1);
		
		if(choice == 1){
			super.alertDialog(alert1);
			WildernessSurvival.player.weaken(5);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
