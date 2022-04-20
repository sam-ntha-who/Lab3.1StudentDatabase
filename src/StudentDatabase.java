
//import java.util.Arrays;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
//import java.lang.reflect.Array;
import java.util.Scanner;

public class StudentDatabase {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		int userSelection = 0;
		String moreFriends;
		String[] studentName = { "Aang", "Katara", "Sokka", "Zuko", "Uncle Iroh", "Toph", "Appa" };
		String[] pronoun = { "He", "She", "He", "He", "He", "She", "He" };
		int[] studentNumber = { 1, 2, 3, 4, 5, 6, 7 };
		String[] bender = { "the Avatar. He is an air bender first, but learns all of the bending skills",
				"a water bender", "has no bending ability, but he's really handy and occasionally has good ideas",
				"a fire bender", "a fire bender", "an earth bender",
				"Aang's sky bison animal guide, who has air bending powers" };
		String[] from = { "Southern Air Temple", "Southern Water Tribe", "Southern Water Tribe", "Fire Nation",
				"Fire Nation", "Earth Kingdom", "Eastern Air Temple" };
		System.out.println("Welcome to the Southern Air Temple! Here are some of our friends:");
		do {
			friendList(studentNumber, studentName);
			System.out.println("Which individual would you like to know more about? Input student number:");
			try {
				userSelection = scnr.nextInt();
				if (userSelection > studentNumber.length) {
					throw new IllegalArgumentException(
							"Your data is incorrect, please try again!");
				}

			} catch (InputMismatchException e) {
				System.out.println("Your data is incorrect. Please try again.");

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("You entered the wrong kind of data! Please try again!");

			}
			goodGuyInfo(studentNumber, studentName, userSelection);
			System.out.println("Would you like to know more? Enter hometown or skills:");
			String moreInfo = scnr.next();

			if (moreInfo.equalsIgnoreCase("skills")) {
				benderStatus(bender, userSelection, pronoun);
				System.out.println("Would you like to know more? Enter yes or no:");
				String yesOrNo = scnr.next();
				if (yesOrNo.equalsIgnoreCase("yes")) {
					nationality(from, userSelection, pronoun);
				} else if (yesOrNo.equalsIgnoreCase("no")) {
					System.out.println("Thanks!");
				}
			}

			else if (moreInfo.equalsIgnoreCase("hometown")) {
				nationality(from, userSelection, pronoun);
				System.out.println("Would you like to know more? Enter yes or no:");
				String yesOrNo = scnr.next();
				if (yesOrNo.equalsIgnoreCase("yes")) {
					benderStatus(bender, userSelection, pronoun);
				} else if (yesOrNo.equalsIgnoreCase("no")) {
					System.out.println("Thanks!");
				}
			} else {
				System.out.println("Ok thanks!");		}

			System.out.println("Would you like to know about any of our other friends? (yes or no)");
			moreFriends = scnr.next();

		} while (moreFriends.equalsIgnoreCase("yes"));
		if (moreFriends.equalsIgnoreCase("no")) {
			System.out.println("Thanks, have a great day!");
		}
		scnr.close();

	}

	public static void friendList(int[] studentNumber, String[] studentName) {
		for (int i = 0; i < studentName.length; i++) {
			System.out.println(studentNumber[i] + ". " + studentName[i]);
		}
	}

	public static void goodGuyInfo(int[] studentNumber, String[] studentName, int userSelection) {
		System.out.println("You selected our friend " + studentName[userSelection - 1] + ".");
	}

	public static void benderStatus(String[] bender, int userSelection, String[] pronoun) {
		int num = userSelection - 1;
		System.out.println(pronoun[num] + " is " + bender[num] + ".\n");
	}

	public static void nationality(String[] from, int userSelection, String[] pronoun) {
		int num = userSelection - 1;
		System.out.println(pronoun[num] + " is from the " + from[num] + ".\n");
	}
}
