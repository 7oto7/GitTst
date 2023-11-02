//დაწერეთ პროგრამა რომელიც დაადგენს შეყვანილი რიცხვი მარტივია თუ არა
import acm.program.ConsoleProgram;

public class problem31 extends ConsoleProgram{
	public void run(){
		int n = readInt("Enter number: ");
		if(n % 2 == 0){
			println(n + " is not prime");
		} else {
			for(int i = 3; i < n - 1; i += 2){
				if(n % i == 0){
				println(n + " is not prime");
				} else {
					println(n + " is prime");
				}
			}
		}
	}
}
