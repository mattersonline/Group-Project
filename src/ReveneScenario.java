import java.util.Random;
public class ReveneScenario extends ScenarioCard {
	
	@Override
	public void runScript() {
		int choice;
		Random random = new Random();
		String message1 = "You can attempt to make your way across but it looks dangerous";
		String[] options1 = {"Turn Around", "Attempt to Cross"};
		String default1 = options1[0];
		String alert1 = "As you are hiking you have come across a shallow place in the revene";
		String alert2 = "You make it across safely";
		String alert3 = "You make it down one slope safely but sadly your food slips on the way back up.\n" +
				"You suffer significant damage!";
		WildernessSurvival.gui.alert(alert1);
		choice = WildernessSurvival.gui.prompt(message1, "", null, options1, default1);
		if(choice == 1){
			if(random.nextInt(100) > 75){
				WildernessSurvival.gui.alert(alert2);
			}
			else {
				WildernessSurvival.gui.alert(alert3);
				WildernessSurvival.player.updateHealth(-50);
			}
		}
		WildernessSurvival.gui.update();
	}

	@Override
	public String toString() {
		
		return null;
	}

}
