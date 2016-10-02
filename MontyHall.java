import java.util.Scanner;

public class MontyHall
{
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args)
	{
		int carDoor = (int) (Math.random() * 3 + 1); //random door btween 1 and 3 inclusive
		
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
			newDoor = 3;
		}
		
		System.out.println(newDoor);
		if (newDoor == carDoor)
		{
			System.out.println("You just won a brand new car!!");
		}
		else
		{
			System.out.println("You just won a goat!!!");
		}
	}
	
	public static int getUserDoor()
	{
		
		System.out.println("Enter a number from 1 through 3");
		String door = scan.nextLine();
		
		return Integer.parseInt(door);
	}
	
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