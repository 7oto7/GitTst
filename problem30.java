//მომხმარებელს შეყავს მთელი რიცხვი, დაბეჭდეთ რიცხვი რომელიც მიიღება ციფრების
//შებრუნებით, 1256 -> 6521
import acm.program.ConsoleProgram;

public class problem30 extends ConsoleProgram{
	public void run(){
		int n = readInt("Enter number: ");
		int reversedNumber = reverseNumber(n);
		println(reversedNumber);
	}

	private int reverseNumber(int n) {
		int reversedNumber = 0;
		int a = 0;
		while(/*n % 10 != 0*/true){
			if(n != 0){
				a = n % 10;
				n = n / 10;
				reversedNumber = reversedNumber * 10 + a;        
			}
		}
		return reversedNumber;
	}
}
