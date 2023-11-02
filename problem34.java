//კანვასზე დახატეთ 1000 შემთხვევითი რადიუსის მქონე შემთხვევითი ფერით გაფერადებული
//წრე, შემთხვევით კოორდინატებზე.

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class problem34 extends GraphicsProgram{
	private static final int MIN_RADIUS = 10;
	private static final int MAX_RADIUS = 20;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		
	}
	private void addRandomCircle(){
		int radius = rgen.nextInt(MIN_RADIUS, MAX_RADIUS);
		double x = rgen.nextDouble(0, getWidth() - 2 * radius);
		double y = rgen.nextDouble(0, getHeight() - 2 * radius);
		Color color = rgen.nextColor();
		
		GOval circle = new GOval(2 * radius, 2 * radius);
		circle.setFilled(true);
		circle.setColor(color);
		
		add(circle, x, y);
	}
}
