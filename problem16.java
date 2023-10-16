
import acm.program.ConsoleProgram;

public class problem16 extends ConsoleProgram {
	public void run() {
		double firstNum = (int) (readInt("First number is: "));
		double secondNum = (int) (readInt("Second number is: "));
		double thirdNum = (int) (readInt("Third number is : "));
		double average = 1 / (1 / firstNum + 1 / secondNum + 1 / thirdNum);
		println("Average is: " + average);		
	}
}
