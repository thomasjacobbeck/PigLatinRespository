/**
 * This app takes a sentence and translates it to Pig Latin
 * 
 * @author Tom Beck
 */
public class PigLatinTranslator {
	public static void main(String[] args) {
		String choice = "y";
		String sentence;
		while (choice.equalsIgnoreCase("y")) {
			sentence = Validator.getLine("Enter a line to be translated to Pig Latin: ");
			printTranslation(sentence);
			choice = Validator.getStringChoice("\nWant to translate another sentence? (y/n): ", "y", "n");
		}
		Validator.closeScanner();
	}

	/**
	 * This method translates an array of words into Pig Latin and prints it out
	 * word by word
	 * 
	 * @param sentence a line of text inputed by the user
	 */
	// This method translates an array of words into Pig Latin and prints it out
	// word by word
	public static void printTranslation(String sentence) {

		sentence = sentence.toLowerCase();
		String words[] = sentence.split(" ");
		for (String currentWord:words) {
			if (!findVowelAndModifyWord(currentWord)) {
				System.out.println("I cannot translate '" + currentWord + "'. There is no vowel.");
			}
		}
	}

	/**
	 * Finds the first instance of a vowel in a word. 
	 * Uses the location of the first vowel to translate the word into pig latin
	 * 
	 * @param word A single word.
	 * @return comes back false if their is no vowel in the String passed
	 */
	public static boolean findVowelAndModifyWord(String word) {
		String beforeVowel;
		String afterVowel;
		boolean vowelPresent = false;

		// if the word begins with an A, E, I, O or U, just add "way" to
		// the end of the word
		if (Validator.isVowel(word.charAt(0))) {
			System.out.print(word + "way ");
			vowelPresent = true;
		}
		else {
			for (int j = 1; j < word.length(); j++) {
				// Finds the first vowel in the word.
				// Puts everything in front of the vowel at the end of the word
				// and adds "ay"
				if (Validator.isVowel(word.charAt(j)) || (word.charAt(j)=='y')) {
					beforeVowel = word.substring(0, j);
					afterVowel = word.substring(j, word.length());
					System.out.print(afterVowel + beforeVowel + "ay ");
					vowelPresent = true;
					break;
				}
			}
		}
		return vowelPresent;
	}
}
