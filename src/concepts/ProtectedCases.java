package concepts;

import enums.TryProtected;

public class ProtectedCases extends TryProtected{//Normal usage example

	public static void main(String[] kripy) {
		// TODO Auto-generated method stub		
		new ShadowProtected().go();
	}
	public void go () {
		System.out.println(proint); //reaching to the protected member directly 
	}

}
/*
 *  Since there is same name parameter in this class we can reach to the protected 
 *  only with super.proint
 *  
 *  proint : TryProtected member 
 *  proint : ShadowProtected member
 */
class ShadowProtected extends TryProtected{
	int proint;
	
	void go() {
		if (this.proint != super.proint)// comparing the local variable with the super class' variable
		{
			System.out.println("the protected member and local member are accessed successfully");
		}
	}
	
}