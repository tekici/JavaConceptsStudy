package concepts;
import Lambdas.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


//Usage of Interface Concrete methods

interface turgays{
	
	default void defaultPrint() {
		System.out.println("defaultPrint method triggered.");
	}
	
	static void staticPrint() {
		System.out.println("staticPrint method is triggered.");
	}
	
	
}

class VarTest implements turgays{
	private int goInt;
	public void printIt() {
				
		turgays.staticPrint();//Only way to use the static interface method.
		
		turgays.super.defaultPrint(); 
		defaultPrint();
		//staticPrint(); cannot be used .
		
		
		System.out.println(goInt);
		System.out.println(str);
		//System.out.println(localPostDef); //No es posible para usarlo  aqui.
		String localPostDef = "localPostDef";
		
	}
	String str = "asd";// instance variable can be defined inside the class in any point.
	
}
class tryy implements deneme{//Interface concrete methods usage
 public void tryit() {

	 System.out.println("tryy - tryit() method");

	 deneme.super.tryit();//this can be placed just inside the class that implements the interface deneme
 }
}
interface OverrideMe{
	default SuperType override() throws IOException{return null;}	
	}
public class BuildingBlocks implements OverrideMe{//Inheritance, inherited - non inherited methods
	Object instanceObj;
	//Overloading Possibilities List
	public void doNothing() {	}
	private void doNothing(int i) {	}
	static void doNothing(int i, int q) {}
	public String doNothing(String s){return "";}
	final void doNothing(long i){}
	//Overriding Possibilities List
	//public SuperType override(){return null;}
	public strictfp SubType override() {return null;}
	
	
	
	public static void main(String[] turgay) {
				
		//instantiating Objects_______________________________ 
		Object localObj = new Object();

		if (localObj != null)//initialized local object is not null. 
			System.out.println("the uninitialized localObj  is NOT null");
		
		BuildingBlocks bb = new BuildingBlocks();
		if (bb.instanceObj == null)//uninitialized instance object is null. 
			System.out.println("the uninitialized instanceObj  is null");
		//end of instantiating Objects___________________________
		
		//Overridding Tests_____________________________________
		VarTest vt = new VarTest();
		vt.printIt();
		
		MyBike mb = new MyBike();//The Object mb
		
		MyBike mr = new RutaBike();
		
		mr.deneme();//this will trigger the method that overriden by RutaBike
	
		System.out.println("MyBike type : " + mb.getType());
		System.out.println("RutaByke type: " + mr.getType());
		System.out.println("MyBike gear : " + mb.getGear());
		System.out.println("RutaByke gear: " + mr.getGear());
		
		
		Object oBike = mb; // The Object Reference oBike 
		multiGear mg = mb;//The Object Reference mg
		

		//oBike does not have no methods inherited from 
		//MyBike or multiGear or bcycle. Just Object methods.
		
		//mg does not have any methods instead 
		//multiGear interface
		//And Object methods
		
		//mb has all methods that it inherited from 
		//multiGear and bcycle interfaces, also 
		//Object 
		//end of Overridding tests__________________________________________ 
		
		//Concrete Interface methods (default / static)____________________
		tryy tr = new tryy();		
		tr.tryit();//in case default tryit()
		
		//deneme.tryit(); //in case static tryit()
		
	}

}

class SuperType{}
class SubType extends SuperType{}

class RutaBike extends MyBike {
	
	public void deneme() {//Access level can be less restricted, but cannot be more .
		System.out.println("RutaBike deneme.");		
	}
		
}
class MyBike implements bcycle, multiGear{
	private String type;
	private int gear;
	
	MyBike(){
		gear = 2;//constructor dominated the initialization block
		deneme();
		//this(3); //has to be in the first line of the constructor method code.
	}

	MyBike(int x){
		
		gear = x;
		
	}
	
	{ //this block runs when the class is initiated. So the initiating values may be given here.
		type = "initType";
		gear = 1;
	}
	
	public String getType() {		
		return type;
	}
	public int getGear() {
		return gear;
	}
	public void setType(String t) {		
		type = t;		
	}
	public void changeGear(int c) {
		gear = c;
	}
	protected void deneme () {
		System.out.println("MyBike deneme.");		
	}
	
}

interface multiGear{
	
	void changeGear(int c);
	
}
interface bcycle {
	
	void setType(String t);
	
}

abstract class absc{
	
	abstract void todo();
	public abstract void normal();
	protected abstract void todo1();
	
}
class whee {
	private int t ; //can be used if it is created inside same class.
	
	public void tryit() {
		whee wh = new whee();
		System.out.println(wh.t);//private is reachable here since it is inside the same class.
	}
	
}