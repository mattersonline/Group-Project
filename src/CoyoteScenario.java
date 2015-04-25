import java.util.Scanner;
public class CoyoteScenario extends SituationScenario{
	private int healthMod;
	public CoyoteScenario(){
		super.enemy = new Coyote();
	}
	
	public CoyoteScenario(double str){
		super.enemy = new Coyote(str);
	}
	
	
	public int getHealthMod(){
		return healthMod;
	}
	
	public String toString()
	{
		return "S";
	}
	public Item[] addItem(){
		return null;
	}
}
