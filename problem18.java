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
	//	println((((1 + n + 1) / 2) * n) - total);
		println(n);
		//1 dan n mde ricxvebs 1 aklia da unda gamovataninot
		//jami davtvalot da mtlians gamovaklot
		//n davitvalot while dan
	}
}
