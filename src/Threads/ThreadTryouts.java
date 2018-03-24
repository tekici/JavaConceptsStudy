package Threads;
import java.io.*;
public class ThreadTryouts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable(){
			public void run (){
				
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run (){
				
				for (int i = 0; i < 1000; i++) {
					System.out.println(i);
				}
								
			}
		});
		
		Thread t3 = new Thread(new Runnable(){
			public void run (){
				
				for (int i = 0; i < 1000; i++) {
					System.out.println(i);
				}
								
			}
		});
		
		long startTime = System.currentTimeMillis();
		
		t1.start();
		t2.start();
		t3.start();
		try{
			t1.join();
			t2.join();
			t3.join();
		}catch (InterruptedException e){
			e.printStackTrace();
			}
		
	
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time Passed : " + (startTime - endTime));
		
	}

}
