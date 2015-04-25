
public class DeerScenario extends EncounterScenario {
	Deer deer = new Deer();
	public void runScript(){
		WildernessSurvival.gui.log("You killed a deer!");
		WildernessSurvival.gui.log("You carve a piece of venison from the body");
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
