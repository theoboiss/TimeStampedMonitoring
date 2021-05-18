package model.mainapp;

public class Tests {
	public static void main(String[] args){
		Hour arrivalTime = new Hour(6, 15);
		Hour leavingTime = new Hour(17, 15);
		DayPlanning day = new DayPlanning(arrivalTime, leavingTime);
		DayPlanning day2 = new DayPlanning();
		System.out.println(day);
		System.out.println(day2);
	}
}
