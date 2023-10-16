
import acm.program.ConsoleProgram;

public class problem15 extends ConsoleProgram {
	public void run() {
		double firstNum = (int) (readInt("First number is: "));
		double secondNum = (int) (readInt("Second number is: "));
		int average = (firstNum + secondNum) / 2;
		println("Arithmetic average is: " + average);		
	}
}