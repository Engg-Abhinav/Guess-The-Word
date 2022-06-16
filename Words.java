// To add random words

package game;

import java.util.Random;

public class Words {
	
	private String[] randomWords = {"animals", "happiness", "indefinite", "steady", "birthday", 
			"extreme", "rights", "properties", "ceremony", "independence", "beneath", 
			"information", "students", "employee"};
	
	private String selectedWord;
	
	// Creating an instance to take random words from array
	private Random random = new Random();
	
	/* Creating instance variable so that we can create an array of chars with the same length 
	   as the random word that we have selected. Then we're going to fill in the letters in that array, 
	   if they're guessed correctly. */
	private char[] letters;
	
	// Creating Constructor
	public Words() {
		selectedWord = randomWords[random.nextInt(randomWords.length)];
		letters = new char[selectedWord.length()];
		/* Here length is a method so it got brackets on it because string is an object 
		   and it has methods. */
	}
	
	public String toString() {
		
		StringBuilder text = new StringBuilder();
//		letter[2] = "a";
		for(char letter : letters) {
			
			text.append(letter == '\u0000' ? "-" : letter);
			// '\u0000' represents null value
			
			/* if(letter == '\u0000') {
				text.append("-");
			}
			else {
				text.append(letter);
			} */
			text.append(" ");
		}
		return text.toString();
		
	}
	
	public boolean isGuessRight() {
		for(char letter : letters) {
			if(letter == '\u0000') {
				return false;
			}
		}
		return true;
	}
	
	public /* void */ boolean guess(char letter) {
		boolean guessedRight = false;
		
		/* In this method, we have to loop through our selected word and check if any of 
		   the letters are equal to the one that's being passed to this method. */
		
		for(int i=0; i<selectedWord.length(); i++) {
			if(letter == selectedWord.charAt(i)) {
				letters[i] = letter;
				guessedRight = true;
			}
		}
		return guessedRight;
	}
}
