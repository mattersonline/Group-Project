import java.util.Random;
public class ReveneScenario extends ScenarioCard {
	
	@Override
	public void runScript() {
		int choice;
		Random random = new Random();
		String message1 = "You can attempt to make your way across but it looks dangerous";
		Object[] options1 = {"Turn Around", "Attempt to Cross"};
		Object default1 = options1[0];
		String alert1 = "As you are hiking you have come across a shallow place in the revene";
		String alert2 = "You make it across safely";
		String alert3 = "You make it down one slope safely but sadly your food slips on the way back up.\n" +
				"You suffer significant damage!";
		super.alertDialog(alert1);
		choice = super.displayDialog(message1, null, null, options1, default1);
		if(choice == 1){
			if(random.nextInt(100) > 75){
				super.alertDialog(alert2);
			}
			else {
				super.alertDialog(alert3);
				WildernessSurvival.player.updateHealth(-50);
			}
		}
	}

	@Override
	public String toString() {
		
		return null;
	}

}
