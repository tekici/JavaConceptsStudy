package algorithms;

public class FibonacciAlgorithm {

	public static int sum = 1 ;
	public static int lastSum = 0;
	
	public void fibonacci () { //1 1 2 3 5 8 13
		System.out.println(sum);
		int tempSum = sum; 
		sum = sum + lastSum ;
		lastSum = tempSum;
	}
	
	public int fibonacci(int iter) {
		
		if (iter <= 1)
			return iter;
		
		return fibonacci(iter-1) + fibonacci(iter - 2);
		
	}
	
	public void doFibonacci(int times)
	{
		
		System.out.println("Fibonacci with Iteration: ");
		for(int x = 0; x<times ; ++x) {
			fibonacci();
		}
		
		System.out.println("Fibonacci with Recursive: ");
		for (int i = 1; i <= times; i++) {
			System.out.println(fibonacci(i));
		}
	}
	

	
	public static void main(String... args) {
		
		new FibonacciAlgorithm().doFibonacci(8);
		

	}

}
