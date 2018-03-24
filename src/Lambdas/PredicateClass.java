package Lambdas;

import java.util.function.Predicate;

public class PredicateClass {
/*
 *  In this method, will be shown the basic usage and rules of a Lambda Expression 
 *  by using the Predicate Class.
 *  
 *  Why to use a Lambda Expression :
 *  If there are many different blocks of codes that are same in code at all, 
 *  but had to be varied just for a part, than you can use the lambdas to make 
 *  a generic block that the different part of the code is given from outside as a lambda expression.
 *  
 *  Predicate interface's test(T) method :
 *  input: Type T 
 *  output:boolean
 *
 */	
	void predigo(Predicate<PredicateClass> pre) {		
	}
	void go() {
		final int x = 0 ;
		final int y;
		final PredicateClass p1 = new PredicateClass();
		final PredicateClass p2 = p1;
		Predicate <String> strPredicate;
		
		strPredicate = e -> true;
		strPredicate = e -> {return true;}; //if there is parenthesis, than there have to be return.
		strPredicate = (String str)->{ // Can be defined or not . if not defined, will take the type auto from strPredicate definition
				System.out.println("Using string in predicate : " + str);
				System.out.println("Using final parameter in predicate: "+x);
				System.out.println("Cannot use a final parameter that is not initialized as \"y\" .");
				return false;
		};
		//predigo(x -> p1 == p2); //Not possible to use non-constants here.
		
		
		strPredicate.test("i did some fancy stuff");	
		}

	
	public static void main (String ... args) {
		
		new PredicateClass().go();
		
	}
	
}
