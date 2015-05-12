public class BearScenario extends EncounterScenario {

	public BearScenario(){
		super.enemy = new Bear();
	}
	
	public BearScenario(double str){
		super.enemy = new Bear(str);
	}
	
	
	@Override
	public void runScript(){
		String[] choices1 = {"Run"};
		int choice;
		WildernessSurvival.gui.log("Sample script");
		WildernessSurvival.gui.log("you are being attacked by a " + enemy.toString());
		choice = WildernessSurvival.gui.prompt("You are being attacked by a " + enemy.toString(), enemy.toString() + " Attack",
				null, choices1, "Attack");
		// CREDIT: Online chapter 38 section 38.6.4
		/*JOptionPane.showOptionDialog(null, 
				"You are being attacked by a " + enemy.getClass().getTypeName() + "! What would you like to do? ", 
				"You are being attacked", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE, 
				new ImageIcon("src/images/player.png"), 
				new Object[]{"run away", "fight"}, 
			"fight");*/
		if(random.nextInt(75) + (WildernessSurvival.player.getEnergy()*.2) < 40){
			WildernessSurvival.gui.alert("You have have failed to run away!");
			enemy.attack(WildernessSurvival.player);
			if(random.nextInt(10) > 5){
				WildernessSurvival.gui.alert("The " + enemy.toString() + " has yielded some edible meat");
				WildernessSurvival.player.addFood(1);
			}
			super.hasAttacked = true;
		}
		else {
			WildernessSurvival.gui.alert("You have successfully ran away!");
		}
		WildernessSurvival.player.updateWeakenedCounter(-1);
		WildernessSurvival.gui.update();
		
		WildernessSurvival.gui.updateHealthBar();
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
