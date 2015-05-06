public class BearTrapScenario extends ScenarioCard {

	public BearTrapScenario(){
	}
	@Override
	public void runScript() {
		WildernessSurvival.gui.log("SNAP! A bear trap closes around your leg!");
		WildernessSurvival.player.updateHealth(-10);
		WildernessSurvival.gui.log("The bear trap does 10 and your defense is crippled for 5 turns");
		WildernessSurvival.gui.log("Your health is now : " + WildernessSurvival.player.getHealth());
		WildernessSurvival.player.weaken(5);
		WildernessSurvival.gui.update();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
