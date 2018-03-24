package Threads;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CyclicTestThread implements Runnable{
	
	private CyclicBarrier cyb;
	private int threadNo ; 
	
	public CyclicTestThread(CyclicBarrier c, int threadno) {
		
		this.cyb = c;
		this.threadNo = threadno;
		
	}

	public void run() {
		
		try {
			cyb.await();
			System.out.println("thread num : " + this.threadNo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class CyclicBarrierFIFO {//IT IS NOT FIFO or LIFO, random as like the other thread queue ups.

	public static void  main (String[] args){
		CyclicBarrier c = new CyclicBarrier(1000);
		
		for (int i=0; i<999; i++)
		{
			Thread t1 = new Thread (new CyclicTestThread(c, i));
			t1.start();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t2 = new Thread(new CyclicTestThread(c,1111));
		t2.start();
		
		
	}
}
