import java.util.Scanner;
public class ScenarioDemo implements Scenario{
	private int healthMod;
	
	public ScenarioDemo(){
	}
	
	public void runScript(){
		int choice;
		Scanner cin = new Scanner(System.in);
		System.out.println("This is a demo of a scenario");
		System.out.println("Do you wish to die?(Enter 1 to die, 2 to live, 3 to lose half): ");
		choice = cin.nextInt();
		switch(choice){
		case 1:
			healthMod = -20;
			break;
		case 2:
			healthMod = 0;
			break;
		case 3:
			healthMod = -10;
			break;
		default:
			healthMod = -120;
			break;
		}
	}
	
	public int getHealthMod(){
		return healthMod;
	}
}
