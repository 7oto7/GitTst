//რულეტკა, მომხმარებელს შეყავს 0 დან 36 მდე რიცხვი, შემდეგ ხდება რულეტკის
//დატრიალების სიმულაცია, კონსოლში უნდა დაიბეჭდოს ამოსული რიცხვი და მოიგო თუ არა
//დადებულმა რიცხვმა


import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class problem37 extends ConsoleProgram{
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 36;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		int betNumber = readBet();
		int rouletteNumber = spinRoulette();
		if(rouletteNumber == betNumber){
			println("You won");
		} else {
			println("You lose");
		}
	}
	private int spinRoulette() {
		int winningNum = rgen.nextInt(MIN_VALUE, MAX_VALUE);
		println("Roulette result is: " + winningNum);
		return winningNum;
	}
	private int readBet() {
		while(true){
			int winningNum = readInt("Enter number from " + MIN_VALUE + " to " + MAX_VALUE + ": ");
			if(winningNum >= MIN_VALUE && winningNum <= MAX_VALUE){
				return winningNum;
			}
		}
	}
}   
