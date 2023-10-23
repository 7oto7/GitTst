//მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის
//უმცირესი საერთო ჯერადი.
import acm.program.ConsoleProgram;

public class problem25 extends ConsoleProgram{
	public void run(){
		int firstNum = readInt("First number is: ");
		int secondNum = readInt("Second number is: ");
		int i = 0;
		while(true){
			i++;
			if(i % firstNum == 0 && i % secondNum == 0){
				break;
			}
		}
		println(i);
	}
}
