import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class tst extends ConsoleProgram{
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 36;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		int betNumber = readBet();
		int rouletteNumber = spinRoulette();
		while(true){
			for(int i = 0; i < 5; i++){
				if(betNumber == rouletteNumber){
					println("you won");
					break;
				} else if(betNumber != rouletteNumber){
					println("try again");
					betNumber = readBet(); 
				}
			}
			break;
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