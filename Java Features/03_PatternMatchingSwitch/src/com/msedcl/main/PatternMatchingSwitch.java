package com.msedcl.main;

public class PatternMatchingSwitch {

	public static void main(String[] args) {
		//basicSwitch();
		//java8Switch();
		//java8EnumSwitch();
		//System.out.println(java12ArrowSwitch("Monday"));+
		//System.out.println(java12ArrowMultipleCaseSwitch("Sunday"));
		//System.out.println(java13YieldSwitchCase("Monday"));
		
		Boolean status=false;
		System.out.println(switch17patternMatching(status));
		System.out.println();
		
		Employee employee= new Employee();
		System.out.println(switch17patternMatching(employee));
		System.out.println();
		
		
		String name="Shamal";
		System.out.println(switch17patternMatching(name));
		System.out.println();
		
		Integer num=78;
		System.out.println(switch17patternMatching(num));
		System.out.println();
		
	}
	
	
	public static String switch17patternMatching(Object object)
	{
		return switch (object) {
		case Integer i->"Its An Integer " + i;
		case Boolean b->"Its an boolean "+b;
		case String s->"Its a String fiels=d "+s;
		case Employee employee->"Its an Employee "+employee;
		default->"Unknown datatype";
		};
	}
	
	public static String java13YieldSwitchCase(String day)
	{
		return switch (day) {
		case "Monday":
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
		case "Friday":
			yield("Weekday");
			
		case "Saturday":
		case "Sunday":
			yield("Weekend");
			
		default:
			yield("Invalid Day");
		
		};
		
	}
	
	public static String java12ArrowMultipleCaseSwitch(String day)
	{
		return switch (day) {
		case "Monday","Tuesday", "Wednesday","Friday","Thursday"->"Weekday";
		case "Sunday","Saturday"->"Weekend";
		
		default->"Unknown";
		};
		
	}
	
	public static String java12ArrowSwitch(String day)
	{
		return switch (day) {
		case "Monday"->"Weekday"; 
		case "Tuesday"->"Weekday";
		case "Wednesday"->"Weekday";
		case "Thursday"->"Weekday";
		case "Friday"->"Weekday";
		case "Saturday"->"Weekend";
		case "Sunday"->"Weekend";
		
		default->"Unknown";
		};
		
	}
	
	
	public static void java8EnumSwitch()
	{
		enum DAYS
		{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY}
		
		DAYS day=DAYS.MONDAY;
		
		switch (day) {
		case MONDAY: 
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			System.out.println("Weekday");
			break;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekend");
			break;
		default:System.out.println("Invalid Day");
			
		}
	}
	
	
	
	
	public static void java8Switch()
	{
		String day="Friday";
		switch (day) {
		case "Monday":
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
		case "Friday":
			System.out.println("Weekday");
			break;
		case "Saturday":
		case "Sunday":
			System.out.println("Weekend");
			break;
		default:
			System.out.println("Invalid Day");
		}
	}
	
	
	

	public static void basicSwitch() {
		// switch case=Java version 7 or less than 7

		int value = 12;
		switch (value) {
		case 1:
			System.out.println("Case 1:: Value is " + value);
			break;
		case 2:
			System.out.println("Case 2:: Value is " + value);
			break;
		case 3:
			System.out.println("Case 3:: Value is " + value);
			break;
		default:
			System.out.println("Default");
			System.out.println("Invalid Choice");
			break;
		}
	}
}
