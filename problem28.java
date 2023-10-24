//მომხმარებელს შეყავს დადებითი რიცხვები, მანამ სანამ არ შეიყვანს -1 ს, დაბეჭდეთ
//რაოდენობა რამდენი ლუწი რიცხვი შეყვანა მომხმარებელმა.

import acm.program.ConsoleProgram;

public class problem28 extends ConsoleProgram{
	private static final int SENTINEL = -1;
	public void run(){
		int n = 0;
		while(true){
			int positiveNumbers = readInt("Enter number: ");
			 if(positiveNumbers == 0){
				n--;
				n++;
			} else if(positiveNumbers % 2 == 0){
				n++;
			} else if(positiveNumbers == SENTINEL)break;
		} 
		println(n);
	}
}
