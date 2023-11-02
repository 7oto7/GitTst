//თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები და დათვალოთ საშუალოდ
//რამდენჯერ უნდა ავაგდოთ მონეტა რათა 3-ჯერ ზედიზედ ამოვიდეს ბორჯღალო.
import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class problem36 extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int NUM_EXPERIMENTS = 1000;
	public void run() {
		double sumFlips = 0;
		for(int i = 0; i < NUM_EXPERIMENTS; i++){
			int currFlips = holdExperiment();
			sumFlips += currFlips;
		}
		double avgFlips = sumFlips / NUM_EXPERIMENTS;
		println(avgFlips);
	}
	private int holdExperiment() {
		int numFlips = 0;
		int heads = 0;
		while(true){
			numFlips++;
			boolean isHeads = rgen.nextBoolean();
			if(isHeads){
				heads++;
				if(heads == 3){
					break;
				}
			} else {
				heads = 0;
			}
		}
		return numFlips;
	}
}
