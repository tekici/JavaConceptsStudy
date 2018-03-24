package concepts;

public class InitializationBlocksConstructors {
	public static void main (String... args) {

		new Extender();
	}
}

class Extender extends Abs {

	static {
		System.out.println("2 - Static block of Extender");
	}
	
	{
		System.out.println("5- Initializing block of Extender");		
	}
	
	Extender(){
		this("gogo");
		System.out.print("7- Constructor of Extender");		
	}
	Extender(String str){
		System.out.println("6- Constructor of Extender");
	}
	
}
abstract class Abs{
	static {
		System.out.println("1- Static block of Abs");
	}
	{
		System.out.println("3- Initializing block of Abs");		
	}
	Abs(){
		System.out.println("4- Constructor of Abs");
	}
	
}