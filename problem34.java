import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class problem34 extends GraphicsProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		boolean a = rgen.nextBoolean();
		int b = rgen.nextInt(9);
		println(b);
		println(a);
	}
}
