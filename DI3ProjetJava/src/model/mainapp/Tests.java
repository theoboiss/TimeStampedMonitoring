package model.mainapp;

public class Tests {
	public static void main(String[] args){
		System.out.println("Hello from Main model\n");
		Hour arrivalTime = new Hour(6, 15);
		Hour leavingTime = new Hour(17, 15);
		Day day = new Day(Day.Name.MONDAY, arrivalTime, leavingTime);
		System.out.println(day);
	}
}
