package concepts;

public class FlowControl {

	public static void main (String ... args) {
		
		FlowControl flw = new FlowControl();
		flw.go();
		
	}
	
	void go () {

		/* break and continue
		 * Break goes out of the loop, continue goes for the next iteration 
		 * 
		 * Labeled break and continue
		 * Has to be just in the beginning of the desired loop
		 * Same rules will applied to the specified loop with label:
		 */
		
		/* for statement rules
		 * Three statements all are non-obligatory.
		 * 
		 * The first statement:
		 * for(int x=0,y=1;;) -> Valid
		 * 	int x = 0;
		 * (x;;)->Valid
		 * (int x=0, int y=1;;) -> InValid.
		 * The second statement
		 * Have to be a boolean expression	
		 * The third statement
		 * A one line code that parameter definition cannot be made.
		 * 
		 */
		int xx = 0;
		for (int y=0 , z=xx; z<5 ; ++z ) { y = z; }		
		/*
		 * Enhanced for
		 * Has two statements
		 * First statement have to declare the variable, cannot use the already declared one
		 * Second statement have to be the array with same type of first statement.
		 * */
		int [] y = {0,1,2};
		for (int x:y) {	}
		
		/* while - do while statements rules
		 * 
		 * Have to be a boolean expression
		 * Parameters that will be used in statement have to be defined before the loop
		 * 
		 */

		
		/* switch statement rules
		 * The switch(expression) rules: 
		 * Parameters that will be used here should be pre-defined.
		 * Can be numeric, string, boolean, char, enum resulting anything:
		 * Parameter, function, expression
		 * 
		 * The cases' rules:
		 * Should be meeting with the conditions of expression's type.
		 * Have to be unique
		 * 
		 * If there is no break, after a matching case, all cases' will be run until break.
		 */
		switch(returnString())
		{
		case "e": 
			break;
		case "string":
			System.out.println("matched");
		case "yokartik":
			System.out.println("yokartik");
			default:
				System.out.println("default");
		}
		
	}
	String returnString (){
		return "string";
	}
}
