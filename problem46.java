//დაწერეთ მეთოდი რომელსაც გადაეცემა სტიგნი და რომელიც აბრუნებს ამ სტრინგში
//ყველაზე ხშირ სიმბოლოს.

import acm.program.ConsoleProgram;

public class problem46 extends ConsoleProgram{
	public void run(){

		String text = readLine("Enter text: ");
		println("Frequent symbol is: " + frequentSymbol(text));
	}

	private char frequentSymbol(String text) {
		int maxChar = 0;
		char frequentChar = 3;
		return frequentChar;
	}
}
