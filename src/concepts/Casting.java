package concepts;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Casting {

	byte b;			   //8 bits -128..127
	short s;		  //16 bits -32768..32767
	char c;		      //16 bits 
	int i ;		      //32 bits
	float f;			  //32 bits
	long l ;			  //64 bits
	double d;	     // 64 bits
	boolean bl;

	void go() {
		
		i = 1000;
		b = (byte) i; //narrowing needs casting. No errors will occur depending on the out of range value while casting. 
		s = b; 			// widening does not need casting.
		i = b;
		l = i;
		//l = f + f; //fails
		d = l;
		c = '\u0125';//there has to be 4 digits exactly after u
		
		System.out.println("byte = " + b + "\nshort = " +s+ "\nchar = " +c+ "\nint = " +i+ "\nlong = " +l+ "\ndouble = " +d);
		
		short sh = (short)12324123;
		short sh2 = 12324123%32768;
		short sh3 = 3276 * 10 + 7; // result is obvious and 32767, so it fits the short. if it was bigger, it would give comp. err
		
		sh3 *= 32769;//Compound operators has IMPLICIT CAST
		char c1 ='a';
		char c2 = 'b';
		
		System.out.println("sh = " + sh + " sh2 = " + sh2 + " sh3 = " + sh3);
		//sh = 3355 sh2 = 3355 sh3 = 8
		
		//sh = sh2 + sh3 // Byte, Short, Char arithmetics always results an int.
		double dd = sh2 + sh3; // there is no problem on casting to a wider type.
		long lg = sh2 + sh3;
		int in = sh2 + sh3;
		//Casting in Arrays and Arraylists :
		/**
		 * In Arrays, if it is a primitive array, it cannot be cast to nothing
		 * If it is Class array, It can just be casted to Object array.
		 * 
		 */
		short [] shortArray = new short[3];
		//int [] intarr= (int[])shortArray; not possible.
		Short [] shArray = new Short[3];
		Object[] obArray = (Object[])shArray;
		
		Byte [] byteArray=new Byte[3];
		//Integer [] intArray=(Integer[])shArray; //Compilation Error
		
		ArrayList<String> strarr= new ArrayList<>();
		//ArrayList<Object> obarr= (ArrayList<Object>)strarr; Compilation Error
		
		
				
	}
	public static void main (String[] $dontWorry) {

		usClass.tryCastingBetweeenSons();
		new Casting().go();

	}

}



class usClass{
	static void tryCastingBetweeenSons() {
		usClass usc = new usClass();
		usClass usAs1 = new as1Class();
		usClass usAs2 = new as2Class();
		as2Class as2 = new as2Class();
		try {
			as1Class a1 = (as1Class)usAs1;
			System.out.println("casting succesfull from as1Class derived usClass to a new as1Class.");
			//as1Class a2 = (as1Class)usc;//This will Fail
			//as1Class a3 = (as1Class)usAs2;//This will Fail
						
		}catch (ClassCastException cce) {
			cce.printStackTrace();
		}
		
		
	}
}
class as1Class extends usClass{}
class as2Class extends usClass{}


