
public class PoisonBerriesScenario extends ScenarioCard {
	@Override
	public void runScript() {
		int choice;
		String message1 = "You find some bright purple berries! What do you do?";
<<<<<<< Upstream, based on master
		String title1 = "Berry Bush";
		Object [] options1 = {"Leave them", "Eat some"};
		Object default1 = (Object) "Leave them";
=======
		String title1 = "Berrie Bush";
		String [] options1 = {"Leave them", "Eat some"};
		String default1 = "Leave them";
>>>>>>> f183dfc update so that it uses alerts and prompts in the gui instead of external dialog boxes
		
		String alert1 = "The berries taste horrible. They were poisoned. You have been weakened for 5 turns";
		
		choice = WildernessSurvival.gui.prompt(message1, title1, null, options1, default1);
		
		if(choice == 1){
			WildernessSurvival.gui.alert(alert1);
			WildernessSurvival.player.weaken(5);
		}
		WildernessSurvival.gui.update();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
