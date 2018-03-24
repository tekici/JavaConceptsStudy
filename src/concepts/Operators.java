package concepts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import enums.WarriorType;

class StringIntegerAdd {
	
	public static void main () {
		long x = 42L;
		long y = 44L;
		
		//Respect to the same precedence operators are executed from left to right ;
		//String + integer = String ---  integer + integer = integer.
		System.out.println(" " + x + y);	  //4244
		System.out.println(foo() + x + y);//foo4244
		System.out.println(x+y+foo());   // 86foo 
		System.out.println(x + y + " ");  //86
		
		
	}
	static String foo() {
		return "foo";
	}
	
}

public class Operators {

	private int value;
	public static void main (String... targaryens) {

		Operators op = new Operators();
		
		//op.execute();
		op.equalityTests();
		//op.unaryOperators();
		//StringIntegerAdd.main();
	}
	
	void printit() {
		System.out.println("printit");
	}
	/**
	 * The difference between directly assigning and assigning with constructor.				 
	 * That '==' operator checks the value if values are assigned directly
	 * If it is assigned via constructor, it checks the object equality.
	 */
	void equalityTests() {
		//Objects equality looks for the memory area.
		System.out.println("Objects Equality");
				Operators ob1 = new Operators();
				Operators ob2 = new Operators();		
				ob1.value = 3;
				ob2.value = ob1.value;
				System.out.println("\nob1.value = 3;\nob2.value = ob1.value;");
				System.out.println("ob1.equals(ob2) results  : " + ob1.equals(ob2)); //False since the objects are in different memory areas.		
//For the Wrappers////////////////////////////////
				System.out.println("\n********************************\n");
				System.out.println("Wrappers Equality");
				Integer x = new Integer(5);
				Integer y = new Integer(5);
				
				System.out.println("Integer x = new Integer(5);");
				System.out.println("Integer y = new Integer(5);");				
				if (x == y)//(FALSE) It is memory test 
					System.out.println("x == y is true");
				else
					System.out.println("x == y  is false");
				
				if (x.equals(y))//TRUE since it is value test
					System.out.println("x.equals(y) is true");
				else
					System.out.println("x.equals(y) is false");
				
				Integer x1 =5;
				Integer y1 =5;
				System.out.println("\nInteger x1 =5");
				System.out.println("Integer y1 =5");
				if (x1 == y1)//(TRUE)  It is now Value test
					System.out.println("x1 == y1 is true");
				else
					System.out.println("x1 == y1  is false");
				
				if (x.equals(y))//TRUE since it is value test
					System.out.println("x1.equals(y1) is true");
				else
					System.out.println("x1.equals(y1) is false");
				
//For the String/////////////////////
				System.out.println("\n********************************\n");
				System.out.println("String Equality");
				String ss1= new String ("Hello");
				String ss2= "Hello";
				System.out.println("ss1 = new String(\"Hello\")");
				System.out.println("ss2 = \"Hello\"");
				if (ss1 == ss2)//FALSE since it is memory test
					System.out.println("ss1 == ss2 is true");
				else
					System.out.println("ss1 == ss2 is false");
				
				if(ss1.equals(ss2))
					System.out.println("ss1.equals(ss2) is true");
				else
					System.out.println("ss1.equals(ss2) is false");
				
				
				ss1 = "Hello Java";
				ss2 = "Hello Java";
				System.out.println("\nss2 =\"Hello Java\"");
				System.out.println("ss2 =\"Hello Java\"");				
				if (ss1 == ss2)//True, it is now value test
					System.out.println("ss1==ss2 is true");
				else 
					System.out.println("ss1==ss2 is false");
				
				if(ss1.equals(ss2))
					System.out.println("ss1.equals(ss2) is true");
				else
					System.out.println("ss1.equals(ss2) is false");
				
//For the ENUMS////////////////////////////////////////
				System.out.println("\n********************************\n");
				System.out.println("Enum Equality");
				WarriorType w1 = WarriorType.ARCHER;
				WarriorType w2 = WarriorType.ARCHER;
			
				System.out.println("WarriorType w1 = WarriorType.ARCHER");
				System.out.println("WarriorType w2 = WarriorType.ARCHER");				
				if (w1 == w2)
					System.out.println("w1 == w2 is true");
				else
					System.out.println("w1 == w2 is  false");
				
				if(w1.equals(w2))
					System.out.println("w1.equals(w2) is true");
				else
					System.out.println("w1.equals(w2) is false");					
				
//For the ArrayList////////////////////////////////////////
				System.out.println("\n********************************\n");
				System.out.println("Arraylist Equality");
				ArrayList<Integer> list1 = new ArrayList<>();
				ArrayList<Integer> list2 = new ArrayList<>();
				
				list2.add(1);
				list2.add(51);
				list2.add(66);
				
				System.out.println(
						"ArrayList<Integer> list1 = new ArrayList<>();\n" + 
						"ArrayList<Integer> list2 = new ArrayList<>();\n" + 
						"\n" + 
						"list1.add(1); list2.add(1);\n" + 
						"list1.add(51);list2.add(51);\n" + 
						"list1.add(66);list2.add(66);\n");
				
				for(int i = 0; i<list2.size(); ++i)
				{
					list1.add(list2.get(i));
				}
				System.out.println(list1);
				System.out.println("\n" + list2);
				
				if (list1 == list2)
					System.out.println("list1 == list2 is true");
				else
					System.out.println("list1 == list2 is false");
				
				if (list1.equals(list2))
					System.out.println("list1.equals(list2) is true");
				else
					System.out.println("list1.equals(list2) is false");

				String strr = "";
				Object ob = new Object();
				
				//For the StringBuilder////////////////////////////////////////
				System.out.println("\n********************************\n");
				System.out.println("StringBuilder Equality");
				
				StringBuilder sb1 = new StringBuilder("string");
				StringBuilder sb2 = new StringBuilder("string");

				System.out.println("StringBuilder sb1 = new StringBuilder(\"string\");\r\n" + 
						"StringBuilder sb2 = new StringBuilder(\"string\");\r\n");
				if (sb1 == sb2)
					System.out.println("sb1 == sb2 is true");
				else
					System.out.println("sb1 == sb2 is false");
				
				if (sb1.equals(sb2))
					System.out.println("sb1.equals(sb2) is true");
				else
					System.out.println("sb1.equals(sb2) is false");
				
				
	}
	void execute() {

		int t = 0;
		boolean b1 = true;
		boolean b2 = false;

		/////////Labeled Statements (break , continue)
		//continue label will make the code go on from the next step of the pointed loop.
		//break label will  make the code to end the pointed loop.
		outer:
		for(int p =0; ; p++)
		{//this will print 7 times "Outer Loop / Inner Loop" and will get out of the loop with breaking label.
			System.out.println("Outer Loop");
			if (p>=7)
				break outer;
			for (int q = 0; q<5 ; ++q)
			{
				System.out.println("Inner Loop");
				continue outer;
			}
			System.out.println("Outer Loop End");
		}
		System.out.println("Broken the outer loop.");
		/*
		outer: 
			for (int i = 0; i<5 ; ++i) {//will continue from last iteration
				for (int j = 0 ; j<5 ; ++j) {//will be beginning from start as like a new iteration
					System.out.println("j is : " +j);//Will be zero always
					System.out.println("Hello");
					continue outer;
				}
				System.out.println("outer");
			}
		System.out.println("Goodbye");
		*/
		////////Labeled Statements end.
		
		if ((b1 == b2)&& ( ++t == 0)) //Overriding rule : if the left side of the operator && is false and || is true, than don't look to right
			System.out.println("asdf");
		System.out.println("t is :" +t); //++t operation normally is more privileged but here it will not be compiled, t = 0			
		
		System.out.println(((true & false) ==(false | true)));
		//String equality looks at the value like a primitive.
		String s = "Asd" , a = "asd";
		System.out.println("Result is " + s.equals(a)); //false  -String compilation is case sensitive
		
		//cat does not implement the female, but mara does. in this case, 
		//the mara instance of cat reference, is also an instance of female.
		cat c = new mara();
		cat b = new cat();//is not .				
		
		((mara)c).doit();
		//strange, that c is an instance of female, but cannot use it's function . c.doit() will not work
		
		System.out.println("the Cat reference of Mara is an instance of female: " + (c instanceof female) );
	}
	/**
	 * Here explained the effect of pre-addition and post-addition operations.
	 */
	void unaryOperators() {
		int x = 1;
		
		System.out.println(x++ * 5 + x++*5 + ++x); //1*5 + 2*5 + 4 = 19 
		/** 
		 * Story of the below code:
		 * 1- x++ , changed the actual value of x as : 2 , but used the value before change: 1.
		 * 2- x++ , changed the actual value of x as : 3 , but used the value before change : 2.
		 * 3- ++x , changed the actual value of x as : 4, and used this value after change   : 4.
		 * 
		 */
		
	}
	
}
//For testing instanceof 
interface felix {}
interface female{
	default void doit() {}
}
class cat implements felix {}
class mara extends cat implements female {}



