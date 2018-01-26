import java.util.Scanner;

/*
 * 
 * Zachariah Zatina
 * 
 * This program takes a user inputted number of sides
 * and rolls them twice and tells in special situations
 * what kind of roll was had.
 * 
 */
public class LabFive {

	public static void main(String[] args) {
		// Variable list
		Scanner scnr = new Scanner(System.in);
		int numSides;
		char cont = 'y';
		int roll1;
		int roll2;
		int i = 0;
		int numRolls;
		boolean innerTrue;
		boolean a;
		boolean outerTrue = true;
		boolean b;
		
		// A loop to see if the user wants to continue rolling dice with a
		//  different amount of sides.
		while (outerTrue == true) {
			//these need to be assigned here to allow while loops w/in code to run correctly
			a = true;
			b = true;
			innerTrue = true;
			// This is here to reset the counting of the rolls
			i = 0;
			// App introduction
			System.out.println("Welcome to the Dice Rolling app!");
			System.out.println("");
			System.out.print("How many sides do the two dies have?: ");
			
			// Validates for integers
			while (!scnr.hasNextInt()) {
				System.out.println("");
				System.out.println("Please enter a valid integer: ");
				scnr.nextLine();
			}
			numSides = scnr.nextInt();
			
			// Loop to run actual dice rolling.
			while (innerTrue == true) {
				
				// Output and input to see how many times the user wants to roll the dice
				System.out.print("How many times would you like to roll the dice?: ");

				while (!scnr.hasNextInt()) {
					System.out.println("");
					System.out.println("Please enter a valid integer: ");
					scnr.nextLine();
				}
				numRolls = scnr.nextInt();
				
				// Loop to match how many times the user wants to roll dice
				for (int j = 1; j <= numRolls; j++) {
					
					// Part that calls the method that assigns a value to the "roll"
					roll1 = getDiceRoll(numSides);
					roll2 = getDiceRoll(numSides);
					
					//counting and reset of while loop value
					i = i + 1;
					a = true;
					
					// Output of results
					System.out.println("Roll " + i + ":");
					System.out.println(roll1);
					System.out.println(roll2);
					
					// This is the part that calls the method to determine the phrase if
					//  dice has 6 sides
					if (numSides == 6) {
						System.out.print(getPhrase(roll1, roll2));
						System.out.println("");
					}
				}
				
				// Loop to  determine if the user wants to roll the same sided dice again
				scnr.nextLine();
				System.out.print("Would you like to continue with this amount of sides on the dice? (y/n): ");
				while (a == true) {
					cont = scnr.next().charAt(0);

					if (cont == 'y' || cont == 'Y') {
						a = false;
						innerTrue = true;
						System.out.println("");
					} else if (cont == 'n' || cont == 'N') {
						a = false;
						innerTrue = false;
						System.out.println("");
					} else {
						System.out.print("That is not a valid answer. Continue? (y/n): ");
					}
				}
			}
			
			// Loop to see if user wants to change dice or exit program
			System.out.print("Would you like to continue and change how many sides on the dice there are? (y/n): ");
			while (b == true) {
				cont = scnr.next().charAt(0);

				if (cont == 'y' || cont == 'Y') {
					b = false;
					System.out.println("");
					continue;
				} else if (cont == 'n' || cont == 'N') {
					b = false;
					outerTrue = false;
					System.out.println("");
				} else {
					System.out.print("That is not a valid answer. Continue? (y/n): ");
				}
			}

		}
		// Closing statements
		System.out.println("Thank you for using the Dice Rolling App! Goodbye!");
		scnr.close();
	}
	// Method that is the "dice-rolling" method
	public static int getDiceRoll(int diceSides) {
		int diceVal = (int) (Math.random() * diceSides);
		return diceVal + 1;
	}
	// Method that assigns a phrase based on result of rolling two 6-sided die
	public static String getPhrase(int num1, int num2) {
		String phrase;
		if (num1 == 1 && num2 == 1) {
			phrase = "Snake Eyes!";
		} else if (num1 == 6 && num2 == 6) {
			phrase = "Box Cars!";
		} else if ((num1 + num2 == 7) || (num1 + num2 == 11)) {
			phrase = "Craps!";
		} else {
			phrase = "";
		}
		return phrase;
	}

}
