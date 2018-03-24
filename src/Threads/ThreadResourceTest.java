package Threads;
class RunMeWithSynMethod implements Runnable{
	String name;
	
	RunMeWithSynMethod(String tname){
		
		name = tname;
		
	}
	public synchronized void test(){
				
			System.out.println(name + " is started");
			try {
				Thread.sleep(3000);
				//wait();
			} catch (InterruptedException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " is ended");
		}
	public void run() {
		Thread.currentThread().setName(name);
		test();
		
	}
}
class RunMeWithSynObject implements Runnable{
	String name;
	Object obj ;
	
	RunMeWithSynObject(String tname, Object obj){
		
		name = tname;
		this.obj = obj;
		
	}
	public void test(){
		
		synchronized(obj){
			System.out.println(name + " is started");
			try {
				Thread.sleep(3000);
				//wait();
			} catch (InterruptedException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " is ended");
		}
	}
	public void run() {
		Thread.currentThread().setName(name);
		test();
		
	}
	
}
class RunMeWithSynObject2 implements Runnable{
	String name;
	Object obj ;
	
	RunMeWithSynObject2(String tname, Object obj){
		
		name = tname;
		this.obj = obj;
		
	}
	public void test(){
		
		synchronized(obj){
			System.out.println(name + " is started");
			try {
				Thread.sleep(3000);
				//wait();
			} catch (InterruptedException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " is ended");
		}
	}
	public void run() {
		Thread.currentThread().setName(name);
		test();
		
	}
	
	
}

public class ThreadResourceTest {

	public static void main(String[] args) {
		//Trying with different instances of same object
		//Runnable: Different Instances, Synchronizing Object: N/A
		//Synchronized: Passive
//		RunMeWithSynMethod rr = new RunMeWithSynMethod("Trg");
//		RunMeWithSynMethod rr2 = new RunMeWithSynMethod("Ali");
//		Thread t1 = new Thread(rr);
//		Thread t2 = new Thread(rr2);		
		
		//Trying with same instances of same object
		//Runnable: Same Object&Instance, Synchronized: Active
//		RunMe rm = new RunMe("SameRunnableObject");
//		Thread t1 = new Thread(rm);
//		Thread t2 = new Thread(rm);
		
		//Runnable: Same Object Different Instances, Synchronizing Object: Same,
		//Synchronized: Active
//		Object ob = new Object();
//		RunMeWithSynObject rm = new RunMeWithSynObject("Trg", ob);
//		RunMeWithSynObject rm2 = new RunMeWithSynObject("Ali", ob);
//		Thread t1 = new Thread(rm);
//		Thread t2 = new Thread(rm2);
		
		//Trying with different runnable object instances with same synchronizing object
		//Runnable: Different Object&Instance, Synchronizing Object: Same,
		//Synchronized: Active
		Object obj = new Object();
		RunMeWithSynObject r1 = new RunMeWithSynObject("Trg", obj);
		RunMeWithSynObject2 r2 = new RunMeWithSynObject2("Ali", obj);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		//WILL TRY WITH WAIT STATEMENTS
		t1.start();
		t2.start();
		
		
	}

}
