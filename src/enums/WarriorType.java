package enums;

public enum WarriorType {//Damage, Delay(ms), Healthpoint
	ARCHER(2,1000,15), 
	SKIRMISHER(3,2000,15), 
	SCOUT(8,3000,25), 
	MAGICIAN(25,3500,40)
	,LONGSWORDSMAN(9,2030,60)
	,CHAMPION(13,2030,70)
	,KNIGHT(10,1830,100)
	,CATAPHRACT(9,1830,110)
	,CAVALIER(12,1830,120);
	//The main specifications that all warriors have to have. 
	int damage;
	private long delay;
	private int healthPoints;
	//For each enum type, constructor takes parameters here
	//that will be able to passed on initializations above in the beginning.
	WarriorType(int damage, long delay, int healthPoints){
		this.damage = damage;
		this.delay = delay;
		this.healthPoints = healthPoints;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public long getDelay() {
		return delay;
	}
	
	public int getHP() {
		return healthPoints;
	}
	
}
