public class BearScenario extends EncounterScenario {

	public BearScenario(){
		super.enemy = new Bear();
	}
	
	public BearScenario(double str){
		super.enemy = new Bear(str);
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
