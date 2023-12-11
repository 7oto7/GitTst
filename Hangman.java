//* File: Hangman.java
// * ------------------
// * This program will eventually play the Hangman game from
// * Assignment #4.
// */

//import acm.graphics.*;
import acm.program.*;
import acm.util.*;

//import java.awt.*;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;

public class Hangman extends ConsoleProgram {

	private HangmanCanvas canvas;
	public int chancesLeft = 8;
	RandomGenerator rgen = RandomGenerator.getInstance();
	String word;

	// this function adds canvas beside the console program
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}

	public void run() {
		println("Welcome to Hangman!"); // beginning of the program
		String word = pickAWord();
		int n = word.length(); // gets words length
		String guess = onlyDashes(n); // makes only dashes with the length of
										// word
		printFirstLook(guess, chancesLeft); // show how word looks in dashes
		playGame(word, guess); // starts playing

	}

	// print only dashes, which tells user how long is the word
	// prints initial chances
	private void printFirstLook(String guess, int chancesLeft2) {
		println("The word now looks like this: " + guess); //
		println("You have " + chancesLeft + " guesses left.");
	}

	// this function generates random word
	private String pickAWord() {
		HangmanLexicon words = new HangmanLexicon(); // gets words from lexicon
		int a = words.getWordCount() - 1; // gets lists size minus one
		int b = rgen.nextInt(0, a); // generates random number to pick random word from lexicon
		String word = words.getWord(b); // gets random word
		return word;
	}

	private void playGame(String word, String guess) {
		String sameWord = word; // keeps the initial word, without dashes
		canvas.reset(); // adds scaffold

		while (chancesLeft != 0) { // game continues until chances are 0
			canvas.displayWord(guess); // prints default word with dashes below
										// the scaffold

			String yourGuess = readLine("Your guess: ");
			if (yourGuess.isEmpty()) {
				println("Please enter a valid guess.");
				continue; // Skip the rest of the loop and prompt the user again
			} else if (yourGuess.length() > 1) {
				println("Please enter only one character");
			} else {
				char c = yourGuess.charAt(0); // converts string into char
				char ch = Character.toUpperCase(c); // converts c into uppercase ch
				if (guess.indexOf(ch) == -1) { // this prevents user to input same char again when he already guessed it
					if (yourGuess.length() == 1 && Character.isLetter(c)) {// user can only use chars
						if (yourGuessIsRight(ch, word)) {// if user guessed right 
							guess = remakeGuess(ch, word, guess); // changes dashes with the guessed chars
							canvas.displayWord(guess); // shows guessed chars below the scaffold
							println("That guess is correct");
							if (guess.equals(word)) { // if user guessed the word, game breaks and he wins
								winningLine(sameWord); //prints winning line
								break;
							}
							printQuote(guess, chancesLeft);

						} else {
							incorrecGuess(yourGuess, guess, chancesLeft, c, sameWord);// if user guessed wrong
						}
					} else {
						println("You entered wrong character! Try again");// if user entres forbiden char
					}
				} else {
					println("You have already guessed this char");// if user entered guessed char
				}
			}

		}

	}

	// this function adds some parts of the body ,
	// reduces chances, prints specific lines
	private void incorrecGuess(String yourGuess, String guess, int chancesLeft2, char c, String sameWord) {
		canvas.noteIncorrectGuess(c); // adds body parts
		println("There are no " + yourGuess + "'s in the word.");
		chancesLeft--;
		if (chancesLeft == 1) {
			println("You have only one guess left");
		} else if (chancesLeft != 0) {
			printQuote(guess, chancesLeft);
		} else if (chancesLeft == 0) {
			losingLine(sameWord);
		}
	}

	// prints specific quote after guessing the char
	private void printQuote(String guess, int chancesLeft2) {
		println("The word now looks like this: " + guess);
		println("You have " + chancesLeft + " guesses left.");

	}

	// prints lines if player wins
	private void winningLine(String sameWord) {
		println("You guessed the word: " + sameWord);
		println("You win.");
	}

	// prints lines if player loses
	private void losingLine(String sameWord) {
		println("You're completely hung.");
		println("The word was: " + sameWord);
		println("You lose");
	}

	// this function replaces dashes with the correct char and returns it
	// if there are more than one correct char, this function replaces it too
	private String remakeGuess(char ch, String word, String guess) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ch && i != word.length() - 1) { // if char is not at the end of the word
				guess = guess.substring(0, i) + ch + guess.substring(i + 1);
			} else if (word.charAt(i) == ch && i == word.length() - 1) { // if char is at the end of the word
				guess = guess.substring(0, i) + ch;
			}
		}

		return guess;
	}

	// checks if there is entered char in the word
	// if it is function returns true, if not - false
	private boolean yourGuessIsRight(char ch, String word) {
		for (int i = 0; i < word.length(); i++) {
			if (ch == word.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	// makes string with only dashes ,which has length of the word
	private String onlyDashes(int n) {
		String dashes = "";
		for (int i = 0; i < n; i++) {
			dashes += "-";
		}
		return dashes;
	}

}

