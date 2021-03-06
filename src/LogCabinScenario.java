import java.awt.Frame;


public class LogCabinScenario extends ScenarioCard{
	int choice;
	WildDogScenario s1 = new WildDogScenario();
	
	String title1 = "A small clearing";
	String message1 = "You are standing in a small clearing. Ahead of you is a cabin. It looks abandoned";
	String [] options1 = {"Leave", "Approach Cabin"};
	String  default1 = "Approach Cabin"; 
	
	String title2 = "In front of the cabin";
	String message2 = "As you approach you study the cabin further. It is old and decrepit.\n"
			+ " It looks like no one had been there for many years \n"
			+ "You are standing in front of the cabin. What do you do?";
	String [] options2 = {"Leave", "Check Windows", "Try Door", "Go Around Back"};
	String default2 = "Try Door";
	
	String title3 = "In front of the cabin";
	String message3 = "You are standing in front of the cabin. What do you do?";
	String [] options3 = {"Leave", "Check Windows", "Go Around Back", "Attempt to Break Down Door"};
	String default3 = "Leave";
	
	String alert1 = "The windows are grimy and you cannot see in";
	String alert2 = "It is locked";
	String alert3 = "You find a wild dog waiting for you in the back yard\n" + "It attacks!";
	String alert4 = "The backdoor is open and you find a storage of food\n and a health kit inside!";
	String alert5 = "CRACK! The door breaks down but you have sprained your ankle\n"
			+ "You have been weakened for two turns\n"
			+ "You also find a storage of food and a health kit inside!";
	
	@Override
	public void runScript() {
		switch(WildernessSurvival.gui.prompt(message1, title1, null, options1, default1)){
		case 0:
			WildernessSurvival.gui.refocus();
			break;
		case 1:
			choice = WildernessSurvival.gui.prompt(message2, title2, null, options2, default2);
			while(choice == 1){
				WildernessSurvival.gui.alert(alert1);
				choice = WildernessSurvival.gui.prompt(message2, title2, null, options2, default2);
			}
			switch(choice){
			case 0:
				WildernessSurvival.gui.refocus();
				break;
			case 2:
				WildernessSurvival.gui.alert(alert2);
				choice = WildernessSurvival.gui.prompt(message3, title3, null, options3, default3);
				while(choice == 1){
					WildernessSurvival.gui.alert(alert1);
					choice = WildernessSurvival.gui.prompt(message3, title3, null, options3, default3);
				}
				switch(choice){
				case 0:
					WildernessSurvival.gui.refocus();
					break;
				case 2:
					WildernessSurvival.gui.alert(alert3);
					s1.runScript();
					if(s1.getHasAttacked()){
						WildernessSurvival.gui.alert(alert4);
						WildernessSurvival.player.addFood(2);
						WildernessSurvival.player.addHealthpack(1);
						WildernessSurvival.gui.updateButtons();
					}
					WildernessSurvival.gui.refocus();
					break;
				case 3:
					WildernessSurvival.gui.alert(alert5);
					WildernessSurvival.player.weaken(2);
					WildernessSurvival.player.addFood(3);
					WildernessSurvival.player.addHealthpack(1);
					WildernessSurvival.gui.updateButtons();
					WildernessSurvival.gui.refocus();
					break;
				}
				break;
			case 3:
				WildernessSurvival.gui.alert(alert3);
				s1.runScript();
				if(s1.getHasAttacked()){
					WildernessSurvival.gui.alert(alert4);
					WildernessSurvival.player.addFood(3);
					WildernessSurvival.player.addHealthpack(1);
					WildernessSurvival.gui.updateButtons();
				}
				WildernessSurvival.gui.refocus();
				break;
				
			}
			break;
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
