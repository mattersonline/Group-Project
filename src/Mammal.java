// The Mammal class holds attributes such as health and energy and
// can attack other mammals. 
// Author: David Taylor
public abstract class Mammal {
	private int health;
	private int energy;
	private int strengthMultiplier;
	
	public Mammal(int strengthMultiplier)
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
		int defenseBonus = this.getStrength() - (this.health + this.energy);
		
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
			this.energy -= attackStrength;
			attackStrength -= tempStrength;
			
			// reset energy to zero if it went under 0
			if(this.energy < 0) this.energy = 0;
		}
		
		// if the attack strength was great enough to get past both 
		// the defense bonus and energy... impact the Mammals health
		if(attackStrength > 0)
		{
			tempStrength = this.health;
			this.health -= attackStrength;
			attackStrength -= tempStrength;
			
			// reset health to zero if it went under 0
			if(this.health < 0) this.health = 0;
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

}