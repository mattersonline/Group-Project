public abstract class WeaponItem extends Item {
	public WeaponItem(int id) {
		super(id,"src/images/dynamite.png");
		// TODO Auto-generated constructor stub
	}

	public abstract int getAttackPower();
}
