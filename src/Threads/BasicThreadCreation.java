package Threads;
class RunFunctionality {
	
	private static int counter ;
	synchronized public static void run (){
		
		for (int i = 0 ; i<100000 ; ++i)
		{
			
			counter++;
			//System.out.println(i);
		}
		System.out.println(counter);
		
	}
	
}

class ThreadExtender extends Thread{
	
	public void run(){
		
		RunFunctionality.run();

	}
	
}

class Runner implements Runnable {

	public void run() {
		
		RunFunctionality.run();
		
	}
	
}

public class BasicThreadCreation {

	
	public static void main(String[] args) {
		
		//By using a class that extended the Thread class and has the run() method overriden inside.
		Thread t1 = new ThreadExtender ();
		Thread t2 = new ThreadExtender ();
		/*t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		//By using a class that implements the Runnable, that can be given in constructor of Thread class.
		//The run() functionality is implemented inside Runner() runnable.
		Thread runnerT = new Thread(new Runner());
		Thread runnerT2 = new Thread(new Runner());
		//runnerT.start();
		//runnerT2.start();
		
		//Using Anonymous class method by placing it inside the new Thread 
		Thread anonymousThread = new Thread(new Runnable(){
			public void run (){
				RunFunctionality.run();
			}
		});
		
		//anonymousThread.run();

		
	}

}
