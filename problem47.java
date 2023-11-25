//დაწერეთ პრედიკატ მეთოდი რომელსაც გადაეცემა სტრინგი და რომელიც დაადგენს არის თუ
//არა მოცემული ტექსტი პალინდრომი

import acm.program.ConsoleProgram;

public class problem47 extends ConsoleProgram{
	public void run(){
		String text = "abba";
		boolean isPalindrom = isPalindrom(text);
		println(text + " is palindrome : " + isPalindrom);
		}

	private boolean isPalindrom(String text) {
		for(int i = 0; i < text.length() / 2; i++){
			if(text.charAt(i) != text.charAt(text.length() - 1 - i)){
				return false;
			}
		}
		return true;
	}
}
