package concepts;

public class Wrappers {

	public static void main (String [] makemyday) {
		
		new Wrappers().go();
		
	}
	/*
	 * It is possible to pass string to the Constructors of Wrappers 
	 * instead Character.
	 * 
	 */
	public void go(){
		Boolean b = new Boolean("true");		
		b = new Boolean(true);
		b = true;
		
		Double db = new Double ("20.5D");
		db = new Double(3115l);
		db = 5D;
		
		
		Float flt = new Float("40");
		flt = new Float(40.5);
		flt = 40f;
		
		
		Long lng = new Long ("40091312312");
		lng = new Long(4);
		lng = 1L;
		
		Integer i = new Integer("40");
		i = new Integer(5);
		i= 99999999;
		
		Byte byt = new Byte("1");
		byt = new Byte((byte)2);
		byt = 1;
		
		Short sht= new Short("1");
		sht = new Short((short)3);
		sht = 3;
				
		Character ch = new Character('c');
		ch = new Character('\u0442');
		ch = 'i'; ch = '\u1111';		
		
		passMeWrapper(new Integer(2));//Wrappers can pass seamlessly with the primitives.
		passMeLongWrapper(new Long(7));
		
		
	}
	public int passMeWrapper(int i) {
		return new Integer(2);
	}
	public long passMeLongWrapper(long l ) {
		return 4;
	}
	
}




