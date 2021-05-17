package model.mainapp;

import java.time.LocalTime;

public class Hour {

		//attributs
		private byte hours, minutes;
		
		//constructeurs
		
		public Hour() { setHoursMinutes(0, 0); }
		
		public Hour(int heures, int minutes) 
		{
			if (!isValidHour(heures, minutes)) 
			{
				throw new IllegalArgumentException("Invalid hour");
			}
			setHoursMinutes(heures, minutes);
		}
		
		//accesseurs en lecture
		public int getHours() {return this.hours;}
		public int getMinutes() {return this.minutes;}
		
		//accesseurs en ecriture
		public void setHours(int hours) 
		{
			if (!isValidHour(hours, 0)) 
			{
				throw new IllegalArgumentException("Invalid hours");
			}
			this.hours = (byte) hours;
		}
		public void setMinutes(int minutes) 
		{
			if (!isValidHour(0, minutes)) 
			{
				throw new IllegalArgumentException("Invalid minutes");
			}
			this.minutes = (byte) minutes;
		}
		public void setHoursMinutes(int hours, int minutes)
		{
			setHours(hours);
			setMinutes(minutes);
		}
		
		//validité de l'heure
		public boolean isValidHour(int hour, int minutes)
		{
			if (0 <= hour && hour <= 23 && 0 <= minutes && minutes <= 59) {return true;}
			return false;
		}
		
		
		//redefinition methode toString
		public String toString() {return this.hours + ":" + this.minutes;}
		
	
}
