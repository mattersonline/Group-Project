import javax.swing.ImageIcon;

// The Mammal class holds attributes such as health and energy and
// can attack other mammals. 
// Author: David Taylor
public abstract class Mammal {
	private int health;
	private int energy;
	private int weakenedCounter = 0;
	private double strengthMultiplier;
	private int defenseBonus = 0;
	private boolean isWeakened;
	private ImageIcon icon;
	
	public Mammal(double strengthMultiplier)
	{
		this.health = 100;
		this.energy = 100;
		this.strengthMultiplier = strengthMultiplier;
	}
	
	public Mammal()
	{
		this(1);
	}
	
	private int getStrength()
	{
		return (int)((health + energy) * this.strengthMultiplier);
	}
	
	public boolean attack(Mammal target)
	{
		boolean wasAttackSuccess = true;
		
		int attackStrength = this.getStrength();

		// perform the attack
		int counterAttackStrength = target.defend(attackStrength);
		
		// defend against the counter attack
		if(this.defend(counterAttackStrength) <= 0) wasAttackSuccess = false;
		
		return wasAttackSuccess;
	}
	
	public int defend(int attackStrength)
	{
		
		// the defense bonus allows you to take a certain amount of damage
		// without losing any health or energy. The attack strength is
		// lessened by that much
		if(!isWeakened){
			defenseBonus = this.getStrength() - ((int)(this.health * .10) + this.energy);
		}
		else{
			defenseBonus = this.getStrength() - ((int)(this.health * .05) + this.energy);
			WildernessSurvival.gui.log("You are weakened!");
			weakenedCounter--;
			if(weakenedCounter == 0){
				isWeakened = false;
			}
		}
		int tempStrength;
		// lessen the attack by the amount of this Mammal's defense bonus
		// as well as impacting the current Mammals defense
		tempStrength = defenseBonus;
		defenseBonus -= attackStrength;
		attackStrength -= tempStrength;
		
		// if the attack strength was greater than the defense bonus,
		// impact energy (before impacting health)
		if(attackStrength > 0)
		{
			tempStrength = this.energy;
			this.energy -= attackStrength / 2;
			attackStrength -= tempStrength;
			
		}
		
		// if the attack strength was great enough to get past both 
		// the defense bonus and energy... impact the Mammals health
		if(attackStrength > 0)
		{
			tempStrength = this.health;
			this.health -= attackStrength;
			attackStrength -= tempStrength;
			
		}
		
		// if the user is still alive, return a counter attack value
		if(this.health > 0)
		{
			return this.getStrength();
		}
		else
		{
			return 0;
		}
	}

	public int getHealth()
	{
		return this.health;
	}
	
	public int getEnergy()
	{
		return this.energy;
	}
	
	public void updateHealth(int amount)
	{
		if(this.health + amount <= 100 && this.health + amount >= 0){
			this.health += amount;
		}
		else if (this.health + amount > 100){
			this.health = 100;
		}
		else if(this.health + amount < 0){
			this.health = 0;
		}
		
	}
	
	public void updateEnergy(int amount)
	{
		if(this.energy + amount <= 100 && this.energy + amount >= 0){
			this.energy += amount;
		}
		else if (this.energy + amount > 100){
			this.energy = 100;
		}
		else if(this.energy + amount < 0){
			this.energy = 0;
		}
	}

	public void weaken(int turns){
		isWeakened = true;
		weakenedCounter += turns;
		WildernessSurvival.gui.log("You are weakened for " + weakenedCounter + " turns!");
	}
	
	public int getWeakenedCounter(){
		return weakenedCounter;
	}
	
	public void updateWeakenedCounter(int i){
		weakenedCounter += i;
	}
	
	public abstract String toString();
}

/*
	ITEMS TO ADD:
	1. BE ABLE TO DIRECTLY IMPACT HEALTH/ENERGY
	2. ACCESS INVENTORY
	3. ADD TO INVENTORY
	4. REMOVE FROM INVENTORY
	5. hunger stat (change energy to hunger)
	
	1. auto impacts deduct for hunger
	2. impact inventory items by using them
	3. apply penalties
	
	Playable
	Informable
	Fightable
	
*/
