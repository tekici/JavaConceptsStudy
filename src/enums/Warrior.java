package enums;

public class Warrior {

	WarriorType warriorType;
	private int team = 0 ;
	private int healthPoints = 0;
	volatile private boolean isLiving = true;
	
	Warrior(WarriorType wt, int team){
		warriorType=wt;
		this.team = team;
		healthPoints = warriorType.getHP();
	}	
	/*
	 * modifyHealthPoints is synchronized to avoid two threads
	 * reach at the same time and override the change that the other 
	 * thread may be done
	 */
	synchronized public void modifyHealthPoints(int change) {
		
			healthPoints = healthPoints + change;
			if (healthPoints < 1)
				isLiving = false;
	}
	
	public int getHP(){
		return healthPoints;
	}
	
	public boolean getLivingStatus()
	{
		return isLiving;
	}
	
	public int getTeam() {
		return team;
	}	
	

	
}
