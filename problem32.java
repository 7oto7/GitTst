
//დაწერეთ პროგრამა რომელიც იპოვის და დაბეჭდავს 1000000 მდე ყველა მერტივ რიცხვს
import acm.program.ConsoleProgram;

public class problem32 extends ConsoleProgram {
	private static final int NUMBER = 1000000;

	public void run() {
		for (int i = 0; i < NUMBER; i++) {
			if(i % 2 == 1){
				if (isPrime(i)) {
					println(i);
				}
			}
		}
	}

	private boolean isPrime(int i) {
		if (i == 1) {
			return false;
		}
		for (int j = 2; j < Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}
}
