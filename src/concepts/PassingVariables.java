package concepts;

public class PassingVariables {

	public static void main (String[] _MaLatYaLI_44_) {
		
		new PassingVariables().run();
		
	}
	
	private void changeCarsModel(Car carPassed) {
		
		carPassed.setModel("s200");
		carPassed = new Car();//Now the carPassed reference is referring to another new object than the passed "cr" object
		carPassed.setModel("s300");
		
		System.out.println("The new car model is: " + carPassed.getModel() );
		
	}
	private void run() {
		
		Car cr = new Car();		
		changeCarsModel(cr);		
		System.out.println("The old car model is: " + cr.getModel());//Here is the first value that changed by changeCarsModel() as "s200" (Line 28)
																										   //The change on "Line 29" is not effecting the value since the Object is changed with new.		
	}
	
	class Car{
		
		private String brand;
		private String model;
		private int maxSpeed;
		
		void setModel(String s) {
			model = s ;
		}
		String getModel() {
			return model;
		}
		
	}

	
	
}
