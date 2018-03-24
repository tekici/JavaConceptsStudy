package concepts;

import java.util.*;

interface RememberThePublicBitch{
	void prettyLittleCodes();
}

public class StringWorks implements RememberThePublicBitch{

	public static void main (String... a) {
		
		StringWorks sw = new StringWorks();
		
		//sw.go();
		sw.prettyLittleCodes();
				
		
	}
	
	public void prettyLittleCodes() {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
		List<String> slist = new ArrayList<>();
		slist.add("ali");slist.add("veli");slist.add("turgay");
		
		//to be removed ..
		slist.remove("turgay");//Now value
		slist.remove(1);//Now index
		list.remove(4);//And now.... index.
		
		System.out.println("String List : \n" + slist + " \n Integer list: \n" + list);
		
		System.out.println("\n\n");
		
		StringBuilder sb = new StringBuilder ("asd");
		
		sb.replace(0, sb.length(), "trg");
		sb.insert(3, "damn");// The index starting from zero, but it can be las tindex+1. No more.
		
		System.out.println(sb);
		
	}
	
	void go() {
	String s = new String(" asd dfd ");
	String str = "123456789";
	StringBuilder sb = new StringBuilder();
	String asd = " asd dfd";
	String str123= "123456789";
	String news= s;
		
	// == operator on a string created as new String(...), will check the memory
	System.out.println("s == asd : "+ (s == asd)); //false
	System.out.println("s == asd dfd : " + (s == " asd dfd"));//false
	System.out.println("s == news : " + (s == news));//true 
	
	System.out.println("str == 123456789 : " + (str == "123456789"));//true
	System.out.println("str == str123 : " + (str == str123));//true
	
	sb.append(str);//sb is now "123456789"
	System.out.println(sb.delete(0, 3));/*sb is now "456789" */ sb.delete(0,30);sb.append("123456789");
	System.out.println(sb.delete(2, 4));/*sb is now "12456789" */ sb.delete(0,30);sb.append("123456789");	
	System.out.println(sb.insert(0,"trg"));/*sb is now "trg123456789*/ 
	System.out.println(sb.insert(0,true));/*sb is now "truetrg123456789*/
	//sb += "asd"; //Does not work.	
	System.out.println(str.substring(0,3)); //123
	System.out.println(str.substring(3));//456789
	
	char ch = str.charAt(1);//charAt() returns Char '2' . 
	
	System.out.println(s.concat(str));//" asd dfd 123456789"	
	System.out.println(s.trim());//white spaces removed asd dfd (excluding the space in middle.)
	System.out.println(s);//the value is not changed because it did not assigned " asd dfd "
	
	
	}
}
