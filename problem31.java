//დაწერეთ პროგრამა რომელიც დაადგენს შეყვანილი რიცხვი მარტივია თუ არა
import acm.program.ConsoleProgram;

public class problem31 extends ConsoleProgram{
	public void run(){
		int n = readInt("Enter number: ");
		if(numberIsPrime(n)){
			println(n + " is prime");
		} else{
			println(n + " is not prime");
		}
	}

	private boolean numberIsPrime(int n) {
		
		if(n == 1){
			return true;
		}else if(n == 2){
			return true;
		}else if(n % 2 == 0){
			return false;
		} else if(n % 2 != 0){
			for(int i = 3; i < n -1; i += 2){
				if(n % i == 0){
					return false;
				}
			}
		} 
			return true;
	}
}
