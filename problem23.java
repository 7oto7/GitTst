import acm.program.ConsoleProgram;

public class problem23 extends ConsoleProgram {
	public void runumber() {
		int n = readInt("Enter number: ");
		int sum = ((1 + n) / 2) * n;
		println(sum);
	}
}
