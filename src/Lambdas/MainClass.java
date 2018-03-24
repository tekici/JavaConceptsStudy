package Lambdas;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public final static String compareStrings(String a, String b) {
		
		for (int i = 0; i < a.length(); i++) {
			
			if (i+1 > b.length())
				return b;			
			if (a.charAt(i) > b.charAt(i))
				return b;				
			if (a.charAt(i) < b.charAt(i))
				return a;
			
		}		
		return a;
	}
	public static void main(String[] args) {

		//Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
	    //c.accept("Java2s.com");
	    
	    //Runnable r = () -> System.out.println("asd");
	    
	   // r.run();
	    
	    
		TwoStrings addStrings = (a,b)->  "Unified Strings: "+a+b;
		TwoStrings compareStrings = (a,b)-> {
			if (compareStrings(a,b)==a) return a + " " + b;
			return b + " " + a;
		};
		
		System.out.println(compareStrings.doAction("Turgayi", "Turgay"));
		//Dog Compare Example
				
		DogCompare getUnderAgelist = (dogarray, age)->{
			ArrayList<Dog> returnList = new ArrayList<Dog>();
			for(Dog d : dogarray) {
				if (d.age <= age )
					returnList.add(d);
			}			
			 return returnList;
		};
		DogCompare getUpperAgelist = (dogarray, age)->{
			ArrayList<Dog> returnList = new ArrayList<Dog>();
			
			for (Dog d : dogarray)
			{
				if (d.age >= age)
					returnList.add(d);
			}			
			return returnList;			
		};
		Dog d1 = new Dog("Beethoven", 50, 10);
		Dog d2 = new Dog("Chopin", 20, 5);
		Dog d3 = new Dog("Mozart", 10, 2);
		ArrayList<Dog> dogslist = new ArrayList<>();
		
		dogslist.add(d1); dogslist.add(d2); dogslist.add(d3);
		
		//Predicate <T> expression : 
		/*
		 * Predicate <Type> name
		 * Defined as : AnyName -> expression 
		 * Used as     : name.test(TypeReference)
		 * 
		 */
		//Function can be defined on definition
		Comparison<Dog> toTest =(c)-> {
				if (c.getAge() > 5)
				return true;
				else 
				return false;
		};		
		System.out.println("Is age > 5 ? : " +   toTest.compareIt(d1));
		//Function can be given as a parameter
		//the method is : toCompare(Dog dog, Comparison<Dog> comp) 
		for (Dog d: dogslist) {
			toCompare(d,c->c.getAge()>5);
		}
		
		
		/*
		List<Dog> resultDogsList = getUnderAgelist.getDogResultArray(dogslist, 7);
		for (Dog d : resultDogsList)
		{
			System.out.println("getUnderAgelist Result : " + d.name);
		}
		
		resultDogsList = getUpperAgelist.getDogResultArray(dogslist, 9);
		
		for (Dog d : resultDogsList)
		{
			System.out.println("getUpperAgelist Result : " + d.name);
		}
 		*/
	}
	public static void toCompare(Dog dog, Comparison<Dog> comp) {
		
		if (comp.compareIt(dog))
			System.out.println(dog.getName()+ " meets the requirement.");
		else
			System.out.println(dog.getName()+ " does not meet the requirement.");
		
	}

}
