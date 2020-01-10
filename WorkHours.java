import java.util.Scanner;

public class WorkHours {
	
	public static void main(String[] args) {
		int maxHours;
		int maxMins;
		int[] startTime = new int[5];
		int[] lunchStart = new int[5];
		int[] lunchEnd = new int[5];
		int[] lunchTime = new int[5];
		int[] endTime = new int[5];
		int remainTime;
		int[] dayTime = new int[5];
		int totalTimeWorked = 0;
		String day[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		
		Scanner keyboard = new Scanner(System.in);
		
		//Assumes that the number of allowable hours per week is an integer value
		System.out.println("Please enter the maximum hours for the week:");
		maxHours = keyboard.nextInt();
		maxMins = maxHours * 60;
		remainTime = maxMins;
		
		//Entering days worked allows the creation of a loop for input
		System.out.println("Please enter the number of days worked so far: ");
		int numDaysWorked = keyboard.nextInt();
		
		//Loop to contain input values
		for(int i = 0; i < numDaysWorked; i++) {
			System.out.println("Please enter starting hour for " + day[i] + " (00 to 23)");
			int startHr = keyboard.nextInt(); 
			System.out.println("Please enter the starting minute for day " + i );
			int startMin = keyboard.nextInt();
			startTime[i] = (startHr * 60) + startMin;
			
			//Determine if lunch was taken and how much time it was
			keyboard.nextLine();
			System.out.println("Did you take a lunch? y or n");
			String lunch = keyboard.nextLine();
			if (lunch.contentEquals("y") || lunch.contentEquals("Y")){
				System.out.println("Please enter the starting hour of your lunch: ");
				int lunchStartHr = keyboard.nextInt();
				System.out.println("Please enter the starting minutes of your lunch: ");
				int lunchStartMin = keyboard.nextInt();
				lunchStart[i] = (lunchStartHr * 60) + lunchStartMin;
				
				System.out.println("Please enter the ending hour of your lunch: ");
				int lunchEndHr = keyboard.nextInt();
				System.out.println("Please enter the ending minutes of your lunch: ");
				int lunchEndMin = keyboard.nextInt();
				lunchEnd[i] = (lunchEndHr * 60) + lunchEndMin;
				
				lunchTime[i] = lunchEnd[i] - lunchStart[i];
			}//end if
			
			//If no lunch was taken, lunch time used is zero
			else {
				lunchTime[i] = 0;
			}//end else
			
			//Determine end of work day time and calculate time worked for entire day.
			System.out.println("Please enter the quitting hour for the day: ");
			int quitHour = keyboard.nextInt();
			System.out.println("Please enter the quitting minutes for the day: ");
			int quitMin = keyboard.nextInt();
			endTime[i] = (quitHour * 60) + quitMin;
			dayTime[i] = endTime[i] - startTime[i] - lunchTime[i];
			
			//Calculate how much time can be worked in remainder of week.
			remainTime -= dayTime[i];
		}//end for
		
		//Print results
		for(int j = 0; j < 5; j++) {
			System.out.println("On " + day[j] +", you worked " + dayTime[j]/60 + " hours and " + dayTime[j] % 60 + " minutes.");
			System.out.println();
		}//end for
		System.out.println("Time remaining for the week is: " + remainTime/60 + " Hours and " + remainTime % 60 + " Minutes.");
		keyboard.close();
	}//end main method
		
	
}//end class
