import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class problem11 extends GraphicsProgram {	
	public void run() {
		GRect rect = new GRect(200, 200);
		rect.setFilled(true);
		rect.setColor(Color.BLUE);
		add(rect, 50, 50);
	}
}
