
import acm.program.ConsoleProgram;

public class problem15 extends ConsoleProgram {
	public void run() {
		int firstNum = readInt("First number is: ");
		int secondNum = readInt("Second number is: ");
		double average = (firstNum + secondNum) / 2.0;
		println("Arithmetic average is: " + average);		
	}
}