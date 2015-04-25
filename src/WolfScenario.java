public class WolfScenario extends EncounterScenario {
	public WolfScenario(){
		super.enemy = new Wolf();
	}
	
	public WolfScenario(double str){
		super.enemy = new Wolf(str);
	}
	@Override
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
