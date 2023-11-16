//დაწერეთ მეთოდი რომელსაც გადაეცემა სტიგნი და რომელიც აბრუნებს ამ სტრინგში
//ყველაზე ხშირ სიმბოლოს.

import acm.program.ConsoleProgram;

public class problem46 extends ConsoleProgram{
	public void run(){
		int countOne = 0;
		int countTwo = 0;
		String text = readLine("Enter text: ");
		for(int i = 0; i < text.length(); i++){
			char symbol = text.charAt(i);
			for(int j = 0; j < text.length(); j++){
				char checkSymbol = text.charAt(j);
				if(symbol == checkSymbol){
					countOne++;
				}
			}
		}
	}
}
