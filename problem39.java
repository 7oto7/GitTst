
//დაწერეთ პროგრამა სადაც იქნება კანვასზე ბურთის მოძრაობა მარცხენა კედლის შუა
//წერტილიდან მარჯვენა კედლამდე.
import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class problem39 extends GraphicsProgram {
	private static final int SPEED = 5;
	private static final int PAUSE_MS = 20;
	private static final int RADIUS = 20;

	public void run() {
		GOval circle = makeCircle();
		int vx = SPEED;
		while (true) {
			if()
		}
	}

	private GOval makeCircle() {
		GOval oval = new GOval(RADIUS * 2, RADIUS * 2);
		int x = 0;
		int y = getHeight() / 2 - RADIUS;
		oval.setFilled(true);
		oval.setFillColor(Color.RED);
		add(oval, x, y);
		return oval;
	}
}
