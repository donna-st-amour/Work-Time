import java.util.Scanner;

public class WorkHours {
static int maxHours;
static int maxMins;
static int startTime;
static int lunchStart;
static int lunchEnd;
static int lunchTime;
static int endTime;
static int remainTime;
static int dayTime;


	public static void main(String[] args) {
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
		for(int i = 1; i <= numDaysWorked; i++) {
			System.out.println("Please enter starting hour for day " + i + " (00 to 23)");
			int startHr = keyboard.nextInt(); 
			System.out.println("Please enter the starting minute for day " + i );
			int startMin = keyboard.nextInt();
			startTime = (startHr * 60) + startMin;
			
			//Determine if lunch was taken and how much time it was
			keyboard.nextLine();
			System.out.println("Did you take a lunch? y or n");
			String lunch = keyboard.nextLine();
			if (lunch.contentEquals("y") || lunch.contentEquals("Y")){
				System.out.println("Please enter the starting hour of your lunch: ");
				int lunchStartHr = keyboard.nextInt();
				System.out.println("Please enter the starting minutes of your lunch: ");
				int lunchStartMin = keyboard.nextInt();
				lunchStart = (lunchStartHr * 60) + lunchStartMin;
				
				System.out.println("Please enter the ending hour of your lunch: ");
				int lunchEndHr = keyboard.nextInt();
				System.out.println("Please enter the ending minutes of your lunch: ");
				int lunchEndMin = keyboard.nextInt();
				lunchEnd = (lunchEndHr * 60) + lunchEndMin;
				
				lunchTime = lunchEnd - lunchStart;
			}//end if
			
			//If no lunch was taken, lunch time used is zero
			else {
				lunchTime = 0;
			}//end else
			
			//Determine end of work day time and calculate time worked for entire day.
			System.out.println("Please enter the quitting hour for the day: ");
			int quitHour = keyboard.nextInt();
			System.out.println("Please enter the quitting minutes for the day: ");
			int quitMin = keyboard.nextInt();
			endTime = (quitHour * 60) + quitMin;
			dayTime = endTime - startTime - lunchTime;
			//System.out.println("Your worked " + dayTime/60 + " hours " + dayTime % 60 + " minutes on day " + i);
			
			//Calculate how much time can be worked in remainder of week.
			remainTime -= dayTime;
		}//end for
		
		//Print results
		System.out.println("Time remaining for the week is: " + remainTime/60 + " Hours and " + remainTime % 60 + " Minutes.");
		keyboard.close();
	}//end main method
		
	
}//end class
