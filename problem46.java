//დაწერეთ მეთოდი რომელსაც გადაეცემა სტიგნი და რომელიც აბრუნებს ამ სტრინგში
//ყველაზე ხშირ სიმბოლოს.

import acm.program.ConsoleProgram;

public class problem46 extends ConsoleProgram{
	public void run(){

		String text = readLine("Enter text: ");
		println("Frequent symbol is: " + frequentSymbol(text));
	//	char frequentChar = 256;
	//	println(frequentChar);/////gamoitans cxrilis 256-e simbolos////////////
	}

	private char frequentSymbol(String text) {
		int maxChar = 0;
		char frequentChar = 0;
		
		for(int i = 0; i < text.length(); i++){
			int count = countSymbol(text, text.charAt(i));
			if(count > maxChar){
				maxChar = count;
				frequentChar = text.charAt(i);
			}
		}
		return frequentChar;
	}

	private int countSymbol(String text, char symbol) {
		int symbolCount = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == symbol) {
				symbolCount++;
			}
		}
		return symbolCount;
	}
}
