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













/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	GLabel lbl;
	GLabel lbl2;
	private int chances = 8;
	private String usedChars = "";
	/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		removeAll();
		

		drawScaffold();

	}

	private void rightFoot() {
		GLine ln1 = new GLine(getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH,
				getWidth() / 2 + HIP_WIDTH + FOOT_LENGTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(ln1);
	}

	private void leftFoot() {
		GLine ln1 = new GLine(getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH,
				getWidth() / 2 - HIP_WIDTH - FOOT_LENGTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(ln1);
	}

	private void rightLeg() {
		GLine ln1 = new GLine(getWidth() / 2,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH,
				getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		add(ln1);
		GLine ln2 = new GLine(getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH,
				getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(ln2);
	}

	private void leftLeg() {
		GLine ln1 = new GLine(getWidth() / 2,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH,
				getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		add(ln1);
		GLine ln2 = new GLine(getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH,
				getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		add(ln2);
	}

	private void rightHand() {
		GLine ln2 = new GLine(getWidth() / 2,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
				getWidth() / 2 + UPPER_ARM_LENGTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		add(ln2);
		GLine ln1 = new GLine(getWidth() / 2 + UPPER_ARM_LENGTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
				getWidth() / 2 + UPPER_ARM_LENGTH, getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH
						+ 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(ln1);
	}

	private void leftHand() {
		GLine ln1 = new GLine(getWidth() / 2,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
				getWidth() / 2 - UPPER_ARM_LENGTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		add(ln1);
		GLine ln2 = new GLine(getWidth() / 2 - UPPER_ARM_LENGTH,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
				getWidth() / 2 - UPPER_ARM_LENGTH, getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH
						+ 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(ln2);

	}

	private void drawBody() {
		GLine ln = new GLine(getWidth() / 2, getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS,
				getWidth() / 2, getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		add(ln);
	}

	private void drawHead() {
		GOval oval = new GOval(2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
		add(oval, getWidth() / 2 - HEAD_RADIUS, getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH);
	}

	private void drawScaffold() {
		GLine scaffold = new GLine(getWidth() / 2 - BEAM_LENGTH, getHeight() / 2 + SCAFFOLD_HEIGHT / 2 - 20,
				getWidth() / 2 - BEAM_LENGTH, getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20);
		add(scaffold);
		GLine beam = new GLine(getWidth() / 2 - BEAM_LENGTH, getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20, getWidth() / 2,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20);
		add(beam);
		GLine rope = new GLine(getWidth() / 2, getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20, getWidth() / 2,
				getHeight() / 2 - SCAFFOLD_HEIGHT / 2 - 20 + ROPE_LENGTH);
		add(rope);
	}

	/**
	 * Updates the word on the screen to correspond to the current state of the
	 * game. The argument string shows what letters have been guessed so far;
	 * unguessed letters are indicated by hyphens.
	 */
	//this function shows correct symbols which is guessed by user
	public void displayWord(String word) {
		/* You fill this in */
		if(lbl != null){
			remove(lbl);
		}
		lbl = new GLabel(word);
		lbl.setFont("Helvetica-30");
		add(lbl, getWidth() / 2 - BEAM_LENGTH, getHeight() / 2 + SCAFFOLD_HEIGHT / 2 - 20  + lbl.getHeight() - 5);
	}

	/**
	 * Updates the display to correspond to an incorrect guess by the user.
	 * Calling this method causes the next body part to appear on the scaffold
	 * and adds the letter to the list of incorrect guesses that appears at the
	 * bottom of the window.
	 */
	//when chances is reduced, this function shows already used wrong chars
	public void noteIncorrectGuess(char letter) {
		chances--;
		if (chances == 7) {
			drawHead();
		}
		if (chances == 6) {
			drawBody();
		}
		if (chances == 5) {
			leftHand();

		}
		if (chances== 4) {
			rightHand();
		}
		if (chances == 3) {
			leftLeg();

		}
		if (chances == 2) {
			rightLeg();

		}
		if (chances == 1) {
			leftFoot();
		}
		if (chances == 0) {
			rightFoot();

		}
		/* You fill this in */
		letter = Character.toUpperCase(letter);//convert any character to uppercase
		if(!usedChars.contains("" + letter)){ //if word do not contains entered char
			char uppersCaseChar = Character.toUpperCase(letter);
			usedChars += uppersCaseChar;
		if(lbl2 != null){
			remove(lbl2);
		}
		lbl2 = new GLabel(usedChars);
		lbl2.setFont("Helvetica-15");
		add(lbl2, getWidth() / 2 - BEAM_LENGTH, getHeight() / 2 + SCAFFOLD_HEIGHT / 2 - 20 + lbl.getHeight() + 10);
		}
		
		
	}

	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
























* File: HangmanLexicon.java
* -------------------------
* This file contains a stub implementation of the HangmanLexicon
* class that you will reimplement for Part III of the assignment.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class HangmanLexicon {
	private ArrayList<String> list = new ArrayList<String>();
	public HangmanLexicon() { //reads hangmanLexicon file and keeps it in array list
		try {
			BufferedReader rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null) {
					break;
				}
				list.add(line);
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return list.size();
	}

	/** Returns the word at the specified index. */
	public String getWord(int index) {
		return list.get(index);
	}

}









