//დაწერეთ მეთოდი რომელსაც გადაეცემა სტიგნი და რომელიც აბრუნებს ამ სტრინგში
//ყველაზე ხშირ სიმბოლოს.

import acm.program.ConsoleProgram;

public class problem46 extends ConsoleProgram{
	public void run(){
		int countOne = 0;
		char maxChar = 0;
		String text = readLine("Enter text: ");
		
		for(int i = 0; i < text.length(); i++){
			int check = checkSymbol(text, text.charAt(i));
			if(check > maxChar){
				maxChar = text.charAt(i);
			}
		}
		
	}
	public int checkSymbol(String text, char symbol){
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == symbol) {
				count++;
			}
		}
		return count;
	}
}
