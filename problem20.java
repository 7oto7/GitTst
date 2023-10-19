import acm.program.ConsoleProgram;

public class problem20 extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter number: ");
		int total = 0;
		for(int i = 0; i < n; i++){
			int numbers = readInt();
			total += numbers;
		}
		println(total);
	}
}
  