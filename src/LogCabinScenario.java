import java.awt.Frame;


public class LogCabinScenario extends ScenarioCard{
	int choice;
	WildDogScenario s1 = new WildDogScenario();
	
	String title1 = "A small clearing";
	String message1 = "You are standing in a small clearing. Ahead of you is a cabin. It looks abandoned";
	Object [] options1 = {"Leave", "Approach Cabin"};
	Object  default1 = (Object) "Approach Cabin"; 
	
	String title2 = "In front of the cabin";
	String message2 = "As you approach you study the cabin further. It is old and decrepit.\n"
			+ " It looks like no one had been there for many years \n"
			+ "You are standing in front of the cabin. What do you do?";
	Object [] options2 = {"Leave", "Check Windows", "Try Door", "Go Around Back"};
	Object default2 = (Object) "Try Door";
	
	String title3 = "In front of the cabin";
	String message3 = "You are standing in front of the cabin. What do you do?";
	Object [] options3 = {"Leave", "Check Windows", "Go Around Back", "Attempt to Break Down Door"};
	Object default3 = (Object) "Leave";
	
	String alert1 = "The windows are grimy and you cannot see in";
	String alert2 = "It is locked";
	String alert3 = "You find a wild dog waiting for you in the back yard\n" + "It attacks!";
	String alert4 = "The backdoor is open and you find a storage of food\n and a baseball bat inside!";
	String alert5 = "CRACK! The door breaks down but you have sprained your ankle\n"
			+ "You have been weakened for two turns\n"
			+ "You also find a storage of foo and a baseball bat inside!";
	
	@Override
	public void runScript() {
		switch(super.displayDialog(message1, title1, null, options1, default1)){
		case 0:
			super.refocus();
			break;
		case 1:
			choice = super.displayDialog(message2, title2, null, options2, default2);
			while(choice == 1){
				super.alertDialog(alert1);
				choice = super.displayDialog(message2, title2, null, options2, default2);
			}
			switch(choice){
			case 0:
				super.refocus();
				break;
			case 2:
				super.alertDialog(alert2);
				choice = super.displayDialog(message3, title3, null, options3, default3);
				while(choice == 1){
					super.alertDialog(alert1);
					choice = super.displayDialog(message2, title2, null, options2, default2);
				}
				switch(choice){
				case 0:
					super.refocus();
					break;
				case 2:
					super.alertDialog(alert3);
					s1.runScript();
					super.alertDialog(alert4);
					super.refocus();
					break;
				case 3:
					super.alertDialog(alert5);
					super.refocus();
					break;
				}
				break;
			case 3:
				super.alertDialog(alert3);
				s1.runScript();
				super.alertDialog(alert4);
				super.refocus();
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
