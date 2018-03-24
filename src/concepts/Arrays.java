package concepts;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrays {

	
	public static void main (String ... args) {
		Arrays arr = new Arrays();
		//new Arrays().definitions();		
		//new Arrays().convertandsort();
		//new Arrays().calendarList();
		arr.arrayDefaultValues();

	}
	void arrayDefaultValues() {
		
		String [] strArray = new String [3];
		
		System.out.println(strArray[0]);
		
		String str = " ";
		
		strArray[0] += "" + 5;
		
		for (String s : strArray) {
			System.out.println(s);
		}
		System.out.println(str.trim().equals(""));
		System.out.println(str.trim().isEmpty());
		
	}
	/*
	 * Converting and Sorting between types
	 * Arrays and ArrayLists.
	 */
	void convertandsort() {
		Integer [] years = new Integer[] {1981,1983,1986,1992,1995,1991,1985};
		
		System.out.println("the Integer[] years: ");
		for (int i : years) {			
			System.out.println(i);
		}
		
		List<Integer> yearsList = new ArrayList<>();
		yearsList = java.util.Arrays.asList(years);
		
		System.out.println("converted ArrayList: ");
		for(int i : yearsList) {
			System.out.println(i);
		}
		
		Collections.sort(yearsList);
		System.out.println("sorted ArrayList: ");
		for(int i : yearsList) {
			System.out.println(i);
		}
		
		yearsList.toArray(years);
		System.out.println("Integer[] years converted from ArrayList: ");
		for (int i : years) {			
			System.out.println(i);
		}
		
		
		Instant now = Instant.now();
		System.out.println("Instant.now : " + now);
		
		
		//Which another types are sortable?
		
		
	}
	/*
	 *  Working with Calendar and ArrayList
	 *  Creating and sorting 
	 *  Using Period
	 * 
	 */
	void calendarList() {
		
		ArrayList<LocalDateTime> loc = new ArrayList<>() ; 
		LocalDateTime l0 = LocalDateTime.of(1986,2,10,14,45,0,0);
		LocalDateTime l1 = LocalDateTime.now();
		Period period = Period.ofDays(61);
		LocalDateTime l2 = l1.plus(period);
		loc.add(l0);
		loc.add(0,l1);
		loc.add(1,l2);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" dd . MM . \" YYYY \" - \" hh.mm.ss\" ");
		
		System.out.println("Before sorting dates : ");
		for(LocalDateTime time : loc) {			
			System.out.println(dtf.format(time));			
		}
		
		Collections.sort(loc);
		System.out.println("After sorting dates: ");
		
		for(LocalDateTime time : loc) {			
			System.out.println(dtf.format(time));			
		}
		
	}
	/*
	 * Defining and casting the Arrays
	 * Defining and casting the ArrayList
	 * between each other
	 * 
	 */
	 void definitions() {	
		Object objArray[] = new Object[6];

		for (Object object : objArray) {
			if (object == null)
				System.out.println("nullObject");
		}
		 
		int [] p [][] = new int [1][2][3]; //can be defined as like this
		int intArray[] = new int[6]; // each integer inside the array are set with the default value, and can be used
													  // unlike references of any other objects that defined inside a method.
		intArray = new int[6];  //can be declared anonymously as like this
		for (int s : intArray) {
			System.out.println(s);
		}

		//Array assiginments
		short shortArray[] = new short[6];
		//intArray = (int[])shortArray;//NOT Possible to convert the primitives as Arrays.
		//intArray = shortArray; //NOT Possible to convert the primitives as Arrays.

		//Object Array assignments
	    honda h1,h2,h3,h4,h5 ;
	    h1 = new honda("h1");
	    h2 = new honda("h2");
	    h3= new honda("h3");
	    h4= new honda("h4");
	    h5= new honda("h5");
	    
	    car [][] car2Array = new car[3][];
		car [] carArray = new honda[] {h1,h2,h3,h4,h5};
		honda [] hondaArray  = new honda[5];
		//hondaArray = new honda[] {h1,h2,h3,h4,h5};
		
		hondaArray = (honda[])carArray;
		
		for(car c: hondaArray) {
			System.out.println(c.name);
		}
		
		car2Array[0] = carArray;
		car2Array[1] = new car[] {h1,h3,h2};
		car2Array[2] = new car[3];
		car2Array[2][0] = h1; //Any attempt to reach the elements of car2Array[2][1] will cause nullpointerexception 
		
		
		for(car[] ca : car2Array) {			
			System.out.println("...printing the next loop");
			for (car c : ca)
			{
				if(c!=null)
				System.out.println(c.name);
			}
		}
		//ArrayList 
		//Can be defined as : 

		ArrayList<Object> list1 = new ArrayList<>();		
		List list3 = new ArrayList();
		List list4 = new ArrayList<>();
		List list5 = new ArrayList<String>();
		
		List<car> carArrayList= new ArrayList<car>();
		//OR
		carArrayList= new ArrayList<>();
		//Common Methods
		carArrayList.add(h1);
		carArrayList.add(1,h2);
		carArrayList.add(1,h3);	
		
		System.out.println("printing the carArrayList"+carArrayList);
		carArrayList.removeIf(e->(e.name!="h2")&(e.name!="h1"));

		System.out.println("printing the carArrayList after delete"+carArrayList);
		carArrayList.size();
		carArrayList.get(0);
		carArrayList.indexOf(h1);
		carArrayList.remove(h1);
		carArrayList.remove(1);		
		System.out.println("carArrayList.contains(h1) = " + carArrayList.contains(h1));
		
		
	}
	}

//The classes used in functions.
class car{
	String name;
}
class honda extends car{
	honda(String n){
		name = n;		
	}
	
}