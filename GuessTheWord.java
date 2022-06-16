/* We're going to display a word or display the blanks representing
   the letters in a word that the player has to guess.
   Ask the player to enter some input and then check that input. */

package game;

import java.util.Scanner;

public class GuessTheWord {

	private boolean play = true;
	// if it is true we will end up with infinite loop
	// we can set it true if we use index in getInput method
	// if there is no index used in getInput method then we set it to false

	// creating instance from words.java
	private Words randomWord = new Words();

	// To read the input we use Scanner class
	private Scanner scanner = new Scanner(System.in);

	// To set limited number of rounds
	private int rounds = 15;
	private char lastRound;

	public void start() {
		/*
		 * We always want to do at least one iteration of the loop, so a loop that
		 * always runs its first iteration is the do while loop.
		 */

		do {
			showWord();
			getInput();
			checkInput();
		} while (play);

	}

	void showWord() {
		System.out.println("You have " + rounds + " tries left!");
		System.out.println(randomWord);
	}

	void getInput() {
		// Get the letters as a string and pass it towards as a method argument.
		System.out.print("Enter a letter to guess the word: ");
		String userGuess = scanner.nextLine();
//		randomWord.guess(userGuess.charAt(0));
		lastRound = userGuess.charAt(0);

//		char letter;
//		randomWord.guess(letter);
	}

	void checkInput() {
		boolean isGuessedRight = randomWord.guess(lastRound);
		if (isGuessedRight) {
			if (randomWord.isGuessRight()) {
				System.out.println("Congrats!!, You Won!");
				System.out.println("The Word is: " + randomWord);
				play = false;
			}
		}
		else {
			rounds--;
			if (rounds == 0) {
				System.out.println("Game Over!!");
				play = false;
			}
		}
	}

	public void end() {
		scanner.close();
	}
}
