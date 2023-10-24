//მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის
//უდიდესი საერთო გამყოფი
import acm.program.ConsoleProgram;

public class problem26 extends ConsoleProgram{
	public void run(){
		int firstNum = readInt("First number: ");
		int secondNum = readInt("Second number: ");
		int count = Math.min(firstNum, secondNum);
		int maximum = 0;
		for(int i = 1; i <= count; i++){
			if(firstNum % i == 0 && secondNum % i == 0){
				if(i > maximum){
					maximum = i;
				}
			}
		}
		println(maximum);
	}
}

/*while( a != 0 && b != 0){
		if(a > b){
			 a %= b;
		} else if(b > a){
			b %= a;
		}
		if(a == 0){
		return b;}
		return a;
	}
*/
 