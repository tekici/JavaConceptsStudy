package concepts;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Dates {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM. dd. \" YYYY \"");	
	LocalDateTime localDateTime = LocalDateTime.now();
	LocalDate localDate = LocalDate.of(1986,2,10);
	LocalTime localTime = LocalTime.MIDNIGHT;
	
	public static void main (String...ilovebogota) {
			
		Dates dts = new Dates();
		dts.go();
		
	}
	public void go () {
		
		LocalDateTime lcdt = LocalDateTime.now();
		java.time.Period per ;
		LocalDate nowDate = LocalDate.now();
		dtf.format(localDate);
		System.out.println("localDateTime is: " + localDateTime.format(dtf));
		System.out.println("localDate is: " + localDate.format(dtf));
		System.out.println("localTime is: " + localTime);
		per = Period.between(localDate, nowDate)  ;		
		
		System.out.println("You have been living for : " 
		+ per.getYears() + " Years, " + per.getMonths() + " Months, " + per.getDays() + " Days.");

		
		
	}
	
	
}
