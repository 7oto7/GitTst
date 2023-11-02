import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class problem34 extends GraphicsProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		int a = 5;
		int b = rgen.nextInt(9);
		println(b);
	}
}
