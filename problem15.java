
import acm.program.ConsoleProgram;

public class problem15 extends ConsoleProgram {
	public void run() {
		int firstNum = readInt("First number is: ");
		int secondNum = readInt("Second number is: ");
		int average = (int) ((double) (firstNum + secondNum) / 2);
		println("Arithmetic average is: " + average);		
	}
}