
//დაწერეთ პროგრამა რომელიც იპოვის და დაბეჭდავს 1000000 მდე ყველა მერტივ რიცხვს
import acm.program.ConsoleProgram;

public class problem32 extends ConsoleProgram {
	private static final int NUMBER = 100000;

	public void run() {
		println("1");
		println("2");
		for (int i = 0; i < NUMBER; i++) {
			if(i % 2 == 1){
				if (isPrime(i)) {
					println(i);
				}
			}
		}
	}

	private boolean isPrime(int i) {
		for (int j = 2; j < Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}
}
