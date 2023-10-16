
import acm.program.ConsoleProgram;

public class problem15 extends ConsoleProgram {
	public void run() {
		double firstNum = readInt("First number is: ");
		double secondNum = readInt("Second number is: ");
		double average = (firstNum + secondNum) / 2;
		println("Arithmetic average is: " + average);		
	}
}