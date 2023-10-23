//მომხმარებელს შეყავს n და m დაბეჭდეთ n^m
import acm.program.ConsoleProgram;

public class problem27 extends ConsoleProgram{
	public void run(){
		int n = readInt("Enter n: ");
		int m = readInt("Enter m: ");
		println(n ^ m);
	}
}
