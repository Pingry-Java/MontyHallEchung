import java.util.Scanner;

/**
 * this class simulates the monty hall problem. the user chooses a number from 1 to 3, 
 * representing the three doors. then, a door with a goat is revealed to the user. after 
 * that, the user has the option to switch doors or stay with the same one. after the user's
 * decision, it is revealed whether he won a car or a goat.
 * @author Ethan Chung
 * @version 1.0
 */
public class MontyHall
{
	public static Scanner scan = new Scanner(System.in);
	
	/**
	* Main method demonstrates the other wo methods by calling each of them.
	* @param args Standard array of commandline String arguments. Not used in this program.
	*/
	public static void main(String[] args)
	{
		int carDoor = (int) (Math.random() * 3 + 1); //random door between 1 and 3 inclusive
		
		int userDoor = getUserDoor();
		int revealed = revealDoor(carDoor, userDoor);
		System.out.println("there is a goat behind door number " + revealed);
		
		boolean swap = getUserSwap();
		
		int newDoor;
		if (swap == true)
		{
			newDoor = changeDoor(revealed, userDoor);
		}
		else
		{
			newDoor = userDoor;
		}
		
		//System.out.println(newDoor);
		//System.out.println(carDoor);
		//I used the two above ^^ lines to test if the program was actually working
		
		if (newDoor == carDoor)
		{
			System.out.println("You just won a brand new car!!");
		}
		else
		{
			System.out.println("You just won a goat!!!");
		}
	}
	
	/**
	* asks the user to enter a number (AKA choose a door)
	* @return door  an int representing the door that the user chose
	*/	
	public static int getUserDoor()
	{
		
		System.out.println("Enter a number from 1 through 3");
		String door = scan.nextLine();
		
		return Integer.parseInt(door);
	}
	
	/**
	* reveals one door to the user that has one of the goats
	* this door must be a goat door and must not be the user's door
	* @param invalid1  the car door
	* @param invalid2  the user door
	* @return revealDoor  the number of the door that will be shown to the user
	*/
	public static int revealDoor(int invalid1, int invalid2)
	{
		for (int revealDoor = 1; revealDoor < 4; revealDoor++)
		{
			if (revealDoor != invalid1 && revealDoor != invalid2)
				return revealDoor;
		}
		//i should never actually reach this line but java
		//needs to know that something is always returned	
		return -1;
	}	
	
	/**
	* asks the user if he wants to switch doors
	* @return true/false  if user wants to swap doors/not swap doors (respectively)
	*/
	public static boolean getUserSwap()
	{
		System.out.println("Would you like to switch doors? Enter 'y' for yes or 'f' for no");
		String swap = scan.nextLine();
		if (swap.equals("y"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	* if user wants to change doors, he switches to the door that was not the one already 
	* revealed and not the user's previous door
	* @param invalid1  the revealed door
	* @param invalid2  the user's previous door
	* @return newDoor  the user's new door
	*/
	public static int changeDoor(int invalid1, int invalid2)
	{
		for (int newDoor = 1; newDoor < 4; newDoor++)
		{
			if (newDoor != invalid1 && newDoor != invalid2)
				return newDoor;
		}
		//i should never actually reach this line but java
		//needs to know that something is always returned	
		return -1;
	}
}