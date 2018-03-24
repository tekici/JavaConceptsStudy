package enums;
//TODO: There has to be a Logger Class that writing logs with a locked thread to avoid same time printed & mixed logs.
//TODO: Resolve the two teams are not starting battle simultaneously. 
//TODO: (Upgrade) Place a miss chance for each warrior, and make a random generator to miss a hit.
//TODO: (Maybe) Make the warrior stick on one random enemy. 
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;


class Logger {
	Logger(){
		
	}
	
	public static synchronized void writeLog(String log) {
		System.out.print(log);
	}
	
}

class RemainingWarriorsPrinter implements Runnable{//A thread to print warrior's list in battle every 3 seconds/
	
	Hashtable<Integer, Warrior> warriorsMap; 
	static private boolean isWarOver = false;
	
	RemainingWarriorsPrinter(Hashtable<Integer, Warrior> o_warriorsMap){
		
		warriorsMap = o_warriorsMap;
		
	}
	//isWarOver : is the parameter to make the thread end it's loop and terminate
	//when one of the HitRandom thread decides by using the function warIsOver below. 
	public static void warIsOver() {
		
		isWarOver = true;
		
	}
	//Every 3 seconds, the thread will print the information of the given warriors map until the war is over.
	@Override
	public void run() {
		String log = "";
		while(false == isWarOver) {
			log = "";
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Set<Integer> aliveWarriorsSet = warriorsMap.keySet();		
			Integer[] aliveWarriors = aliveWarriorsSet.toArray(new Integer[aliveWarriorsSet.size()]);	
			
			log += "===================================\n";
			log += "The alive warriors list is \n";
			
			for (int i = 0; i < aliveWarriors.length; i++) {
				
				log += HitRandom.printWarriorTag(warriorsMap.get(aliveWarriors[i]));
				log += "\n";
				
			}
			
			log += "===================================\n";
			Logger.writeLog(log);
		}
	}

}

class HitRandom implements Runnable {
	Hashtable<Integer, Warrior> warriorsMap;
	Warrior warrior;//The thread owner warrior that will hit.
	
	HitRandom(Hashtable<Integer, Warrior> o_warriorsMap,  Warrior o_warrior){
		warriorsMap = o_warriorsMap;
		warrior = o_warrior;
	}
	public static String printWarriorTag(Warrior w) {
		
		return "#"+w.warriorType.name()+ "[" + w.getHP() + "] team [" + w.getTeam() + "]";
		
	}
	private String hit(Warrior toHit, Warrior getHit) {
		
		String log = "";
		if (false == toHit.getLivingStatus())
		{//While doing hit progress, if the warrior get hit somehow and die, here it is avoided to be able to hit while dead.
			log += "The warrior " + printWarriorTag(toHit);
			log += " is dead just before hitting to \n" + printWarriorTag(getHit);
			return log;
		}
		getHit.modifyHealthPoints(-toHit.warriorType.getDamage());

		log += printWarriorTag(toHit);
		log += " HIT ["+ toHit.warriorType.getDamage()  + "] >>>> ";
		log += printWarriorTag(getHit);
		log += "\n";
		return log;
		
	}
	/*
	 * The rules before hit:
	 * The opponent warrior will be randomized from the remaining keySet by putting into an Array. 
	 * Team of the opponent has to be different check passed.
	 * 
	 */
	@Override
	public void run() { 		
		String log = "";
		
		while (warrior.getLivingStatus() && warriorsMap.size() > 0) {//FIGHT until DEATH or WIN.
			log = "";
			log += "========" + printWarriorTag(warrior) + " is Attacking " + "========\n";
			//Getting the set of KEYS from the opponent team map.  
			Set<Integer> aliveWarriorsSet = warriorsMap.keySet();
			//To be able to make randomize, the index range of this array will be used.
			Integer[] aliveWarriors = aliveWarriorsSet.toArray(new Integer[aliveWarriorsSet.size()]);
			
			//Randomizing within the index of array, and getting the key value at that index from keys  
			Random r = new Random();
			int opponentKey = r.nextInt(aliveWarriors.length);
			log += "Generated index is : " + opponentKey + "\n";
			//Getting key from the current warriors list		
			opponentKey = aliveWarriors[opponentKey];
			log += "The random key value of the opponent: " + opponentKey + "\n";
			//Obtaining the warrior with the KEY, from opponent warrior map.
			Warrior opponentWarrior = warriorsMap.get(opponentKey);
			//In case that the opponent is dead by another hit, this check below is done.
			if (opponentWarrior == null)
			{
				log +="Opponent is dead before get hit. \n";				
				continue;
			}
			
			if (opponentWarrior.getTeam() != warrior.getTeam())
			{//Do the hit.
				log += hit(warrior, opponentWarrior);				
				
				if (false == opponentWarrior.getLivingStatus())
				{//if the opponent warrior is dead, than remove it from the list
					log += "Warrior is DEAD.. " + opponentWarrior.warriorType + " from team "+ opponentWarrior.getTeam() + "\n";
					warriorsMap.remove(opponentKey);
				}
				
			}else {//In case that a member of a team placed with a wrong team number, it assumed to be miss-hit.
				log += printWarriorTag(warrior) + " is Missed..\n";
			}			
			Logger.writeLog(log);
			//Executing the hit delay  
			try {
				Thread.sleep(warrior.warriorType.getDelay());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/*
		 * If the loop is ended, that has two means, first; that this warrior on battle is dead,
		*Or there is no more opponent existing in the opponent team
		*In case that the warrior is still alive, that means there is no opponent left.
		*Declaring the victory below, upon this information
		*And letting the thread end that producing log for remaining warriors
		*By calling warIsOver() function
		*/ 
		if (warrior.getLivingStatus())
		{
			Logger.writeLog("The Victorious .. Team " + warrior.getTeam() + "\n");
			RemainingWarriorsPrinter.warIsOver();
		}
		
				 
	}
	
}
class TeamFight{
	
	public volatile Hashtable<Integer, Warrior> warriorsMapT1 = new Hashtable<Integer, Warrior>();
	public volatile Hashtable<Integer, Warrior> warriorsMapT2 = new Hashtable<Integer, Warrior>();
	
	private void fight(Hashtable<Integer, Warrior> warriorsMap1, Hashtable<Integer, Warrior> warriorsMap2) {
			
			RemainingWarriorsPrinter rwp = new RemainingWarriorsPrinter(warriorsMap1);
			Thread th = new Thread(rwp);
			th.start();		
			
			for (Map.Entry<Integer, Warrior> m : warriorsMap1.entrySet()) 
			{
				//Will be creating a thread for each warrior from team 1, that will hit a randomized warrior in team2				
				HitRandom hr = new HitRandom(warriorsMap2, m.getValue());
				Thread t1 = new Thread(hr);
				t1.start();					
			}//end of for
			
		}
	public void createTeamsAndFight() {//This is a method to demonstrate a battle with manually created teams
		
		Warrior myWarrior1 = new Warrior(WarriorType.SKIRMISHER,1);
		warriorsMapT1.put(0, myWarrior1);
		Warrior myWarrior2 = new Warrior(WarriorType.SKIRMISHER,1);
		warriorsMapT1.put(1, myWarrior2);
		Warrior myWarrior3 = new Warrior(WarriorType.SKIRMISHER,1);
		warriorsMapT1.put(2, myWarrior3);
		
		
		Warrior myWarrior4 = new Warrior(WarriorType.ARCHER,2);
		warriorsMapT2.put(3, myWarrior4);
		Warrior myWarrior5 = new Warrior(WarriorType.ARCHER,2);
		warriorsMapT2.put(4, myWarrior5);
		Warrior myWarrior6 = new Warrior(WarriorType.ARCHER,2);
		warriorsMapT2.put(5, myWarrior6);
		
		fight(warriorsMapT1,warriorsMapT2);
		fight(warriorsMapT2,warriorsMapT1);
	}
	
}
public class ExecuteBattle {
	public static Logger logger = new Logger();
	
	public static void main (String[] args) {		
		
		TeamFight tf = new TeamFight();
		tf.createTeamsAndFight();
		
	}	
	
}
