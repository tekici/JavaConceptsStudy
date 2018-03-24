package Threads;
import java.util.concurrent.CountDownLatch;

class WaitingCar implements Runnable{
	CountDownLatch waitRedLight;
	
	WaitingCar(CountDownLatch cdl){
		waitRedLight = cdl;
	}
	@Override
	public void run() {
		
		System.out.println("Waiting for the light to turn green..");
		
		try {
			waitRedLight.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The light turned to green, now go.");
		
	}
	
}

class SemaphoreClick implements Runnable {
	CountDownLatch cdl;
	SemaphoreClick(CountDownLatch cdl){	//Same instance of the countdownlatch is used for all threads.	
		this.cdl = cdl;
	}
	
	public synchronized void run () {
		
		System.out.println("Time remaining for the green light:  " + cdl.getCount() + "...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cdl.countDown();		
		
	}
}


public class SemaphoreWithCountDownLatch {

	
	public static void main (String[] args) {		

		CountDownLatch cdl = new CountDownLatch(5);
		SemaphoreClick greenLight = new SemaphoreClick(cdl);
		WaitingCar waitingCar = new WaitingCar(cdl);
		
		
		Thread waitingForGreen = new Thread(waitingCar);
		waitingForGreen.start();
		
		for (int i = 0; i < 5; i++) {//giving same countdown object to each new instance of Threads, to be able to countdown.

			Thread t1 = new Thread(greenLight);		
			t1.start();
			
		}
		
	}
	
}
