package concepts;

import java.io.FileNotFoundException;
import java.io.IOException;
/* Checked and Runtime Exceptions List
 * 
///RuntimeExceptions
java.lang.NumberFormatException 
java.lang.IllegalArgumentException
java.lang.ArithmeticException
java.lang.NullPointerException 
java.lang.Exception.IndexOutOfBoundsException
java.lang.ClassCastException

///Checked Exceptions
java.io.FileNotFoundException
java.io.IOException

*
*/
public class Exceptions {

	public static void main(String[] fargs) {
		//in case that the extending class does not have exception on the overriding method that the super-method has
		
		Bird bird = new Clown();
		try{bird.fly();}catch (Exception ex) {}
		
		String str = null;
		
		Exceptions exc = new Exceptions();
		
		try {//E-1 Classic straight try-catch-final blocks example.
			System.out.println("Classic straight try-catch-final blocks example: ");
			exc.reverse (str);
		}catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		finally{
			System.out.println("E-1  is ended.");			
		}
	
		try {//E-2 The Exception that thrown from Finally Overrides Example
			System.out.println("Exception that thrown from Finally Overrides Example: ");
			exc.throwTwoExceptions();
		}catch(ArithmeticException re) {//is thrown at catch block
			System.out.println("ArithmeticException is thrown");
			re.printStackTrace();
		}catch(IOException e) {//is thrown at final block, THIS will be printed.
			System.out.println("IOException is thrown");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Exception is thrown");
			e.printStackTrace();
		}finally {
			System.out.println("E-2  is ended.");			
		}
		
		try {//E-3 Try catch block that written for a method that will not throw a CHECKED exception compilation fails Example.			
			exc.throwNOExceptions();
		}catch(IllegalArgumentException ex) {//checked exceptions (like IOException) WONT WORK
			
		}finally {
			System.out.println("E-3 is ended.");
		}
		
		//The exception thrown in catch block example
		exc.throwExceptionInTryCatchBlock();
		
		
	}
	String reverse(String str) {
		
		String reverseStr = "";
		
		for (int i = str.length()-1; i>=0; --i)
		{
			reverseStr += str.charAt(i);
		}
		return reverseStr;
		
	}

	public void throwTwoExceptions() throws Exception{
		
		 try { 
			 throw new ArithmeticException(); 
			 } 
		 finally 
		 	{ //this exception here overrides the exception in catch block.
				throw new IOException(); 
			}
		
	}
	
	public void throwNOExceptions() {
		
	}
	
	public void throwExceptionInTryCatchBlock() {
		
		try {// Any exceptions that thrown inside any part of try-catch-finally is behaved same as normal code, the program will halt.
			throwRuntimeException();// will throw an unhandled runtime exception.
		}catch (ArithmeticException ex) {
			throw new ClassCastException();//unhandled runtime exception is being thrown
		}finally {
			System.out.println("Finally Block will be compiled");
		}
		
		System.out.println("This block will not compile due to unhandled runtime exception thrown in block");
				
		
	}
	int getint() {
		try {
		return 1;
		}catch (Exception ex) {//Does not need to have possibility of the exception to be thrown
			
		}
		return 1;
	}
	public void throwIOException() throws IOException{
		throw new IOException();
	}
	public void throwRuntimeException() {
		throw new RuntimeException();
	}
}

class Clown extends Bird{
	public void fly() {}
}
class Bird{	
	public void fly() throws Exception{}	
}


