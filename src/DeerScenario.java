
public class DeerScenario extends EncounterScenario {
	Deer deer = new Deer();
	public void runScript(){
		WildernessSurvival.gui.log("You killed a deer!");
		WildernessSurvival.gui.log("You carve a piece of venison from the body");
		WildernessSurvival.gui.log("You gain 50 energy!");
		WildernessSurvival.player.updateEnergy(50);
		WildernessSurvival.gui.log("Your hunger is now : " + WildernessSurvival.player.getEnergy());
	}
	public int getHealthMod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item[] addItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
