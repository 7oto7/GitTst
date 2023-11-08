import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

//დაწერეთ პროგრამა რომელიც კანვასზე დახატავს შემთხვევითი ფერის მქონე წრეწირს,
//რაიდიუსიც შემთხვევით აირჩეით შეზღუდული რეინჯიდან.
public class problem33 extends GraphicsProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int MIN_RADIUS = 0;
//	private static final int MAX_RADIUS = getHeight() / 2;
	
	public void run(){
		addRandomCircle();
	}
	private void addRandomCircle() {
		int radius = rgen.nextInt(MIN_RADIUS, getHeight() / 2);
		Color color = rgen.nextColor();
		double x = rgen.nextDouble(0, getWidth() - 2 * radius);
		double y = rgen.nextDouble(0, getHeight() - 2 * radius);
		GOval circle = new GOval(radius, radius);
		circle.setFilled(true);
		circle.setFillColor(color);
		add(circle, x, y);
	}

}
