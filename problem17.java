
import acm.program.ConsoleProgram;

public class problem17 extends ConsoleProgram {
	public void run() {
		double number = readDouble("number is: ");
		int integer = (int) number;
		double fraction = number - integer;
		println("integer is: " + integer);
		println("fraction is: " + fraction);
		
	}
}
