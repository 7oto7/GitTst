//მომხმარებელს შეყავს n და m დაბეჭდეთ n^m
import acm.program.ConsoleProgram;

public class problem27 extends ConsoleProgram{
	public void run(){
		int n = readInt("Enter n: ");
		int m = readInt("Enter m: ");
		int nm = 1;
		for(int i = 0; i < m; i++){
			nm = nm * n;
		}
		println(nm);
	}
}
