package model.mainapp;

public class Tests {
	public static void main(String[] args){
		Hour arrivalTime = new Hour(6, 15);
		Hour leavingTime = new Hour(17, 15);
		Day day = new Day(Day.Name.MONDAY, arrivalTime, leavingTime);
		Day day2 = new Day();
		Day day3 = new Day(Day.Name.TUESDAY);
		System.out.println(day);
		System.out.println(day2);
		System.out.println(day3);
	}
}
