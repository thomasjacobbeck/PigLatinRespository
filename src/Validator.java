import java.util.Scanner;
/**
 * This class includes tools that function with the Pig Latin Translator 
 * Each method determines if a string meets a set of conditions
 * @author Tom Beck
 *
 */
public class Validator {
	static Scanner keyboard= new Scanner(System.in);
	/**
	 * Determines if a character is an 'A', 'E', 'I', 'O', or 'U'
	 * @param c character
	 * @return if the character is a vowel or not
	 */
	public static boolean isVowel(char c){
		boolean isVowel;
		switch(c){
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			isVowel=true;
			break;
		default:
			isVowel=false;
		}
		return isVowel;
	}
	/**
	 * Presents the user with a prompt and gives them the choice between 2 options
	 * If the user doesn't select one of the two options, then it prompts them again.
	 * @param prompt displays to the user
	 * @param choice1 first choice
	 * @param choice2 second choice
	 * @return user choice
	 */
	public static String getStringChoice(String prompt, String choice1, String choice2) {
		String s;
		System.out.print(prompt);
		s = keyboard.next(); // read user entry
		keyboard.nextLine(); // discard any other data entered on the line
		while (!(s.equalsIgnoreCase(choice1) || s.equalsIgnoreCase(choice2))) {
			System.out.print("\nInvalid choice. Please enter "+choice1+" or "+choice2+":");
			s = keyboard.next(); // read user entry
			keyboard.nextLine(); // discard any other data entered on the line
		}
		return s;
	}

	/**
	 * Prompts the user to put in a line of text
	 * @param prompt displays to user
	 * @return user input
	 */
	public static String getLine(String prompt) {
		System.out.print(prompt);
		String s = keyboard.nextLine(); // read the whole line
		return s;
	}
	/**
	 * Closes the Scanner that was taking input from the keyboard
	 */
	public static void closeScanner(){
		keyboard.close();
	}
}
