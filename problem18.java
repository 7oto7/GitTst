import acm.program.ConsoleProgram;

public class problem18 extends ConsoleProgram {
	private static final int SENTINEL = 0;
	
	public void run() {
		int num = readInt("number: ");
		int n = 0;
		int total = 0;
		while(num != SENTINEL){
			n++;
			total += num;
			num = readInt("number: ");
		}
		int sum = ((2 + n) / 2) * (n + 1);
		println(sum);
	}
}
