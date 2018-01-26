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

		while (outerTrue == true) {
			a = true;
			b = true;
			innerTrue = true;
			i = 0;
			System.out.println("Welcome to the Dice Rolling app!");
			System.out.println("");
			System.out.print("How many sides do the two dies have?: ");

			while (!scnr.hasNextInt()) {
				System.out.println("");
				System.out.println("Please enter a valid integer: ");
				scnr.nextLine();
			}
			numSides = scnr.nextInt();

			while (innerTrue == true) {

				System.out.print("How many times would you like to roll the dice?: ");

				while (!scnr.hasNextInt()) {
					System.out.println("");
					System.out.println("Please enter a valid integer: ");
					scnr.nextLine();
				}
				numRolls = scnr.nextInt();

				for (int j = 1; j <= numRolls; j++) {

					roll1 = getDiceRoll(numSides);
					roll2 = getDiceRoll(numSides);

					i = i + 1;
					a = true;

					System.out.println("Roll " + i + ":");
					System.out.println(roll1);
					System.out.println(roll2);

					if (numSides == 6) {
						System.out.print(getPhrase(roll1, roll2));
						System.out.println("");
					}
				}

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

		System.out.println("Thank you for using the Dice Rolling App! Goodbye!");
		scnr.close();
	}

	public static int getDiceRoll(int diceSides) {
		int diceVal = (int) (Math.random() * diceSides);
		return diceVal + 1;
	}

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
