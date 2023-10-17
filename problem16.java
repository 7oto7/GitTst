
import acm.program.ConsoleProgram;

public class problem16 extends ConsoleProgram {
	public void run() {
		int firstNum = readInt("First number is: ");
		int secondNum = readInt("Second number is: ");
		int thirdNum = readInt("Third number is : ");
		double average = 1 / (1.0 / firstNum + 1.0 / secondNum + 1.0 / thirdNum);
		println("Average is: " + average);		
	}
}
