//დაწერეთ stringToInteger მეთოდი, რომელსაც გადაეცემა სტრინგი და აბრუნებს მთელ რიცხვს.
//ჩათვალეთ, რომ გადაცემული სტრინგი მხოლოდ ციფრებისგან შედგება და არ იწყება 0-ით.
//მაგალითად “234” გადაცემის შემთხვევაში მეთოდმა უნდა დააბრუნოს 234. ასევე ჩათვალეთ,
//რომ დაბრუნებული მნიშვნელობა დადებითია და ეტევა int-ში.

import acm.program.ConsoleProgram;

public class problem49 extends ConsoleProgram{
	public void run(){
		String numStr = "1234";
		int num = stringToInt(numStr);
		println(num);
	}

	private int stringToInt(String numStr) {
		int num = 0;
		for(int i = 0; i < numStr.length(); i++){
			char currCh = numStr.charAt(i);
			int currDigit = currCh - '0';
			num = num * 10 + currDigit;
		}
		return num;
	}
}
