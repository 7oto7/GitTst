
import java.awt.Color;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class dvd extends GraphicsProgram {
	private static final int SPEED = 1;
	private static final int PAUSE_MS = 2;
	private static final int RADIUS = 20;

	public void run() {
		GLabel lable = myPanel();
		int vx = SPEED;
		int vy = SPEED;
		while (true) {
			if (lable.getX() <= getWidth() && lable.getY() <= getHeight()) {
				lable.move(vx, vy);
				pause(PAUSE_MS);
			}
			if (lable.getY() > getHeight() || lable.getY() - 100 < 0) {
				vy = -vy;
				lable.move(vx, vy);
			}
			if (lable.getX() + 100 > getWidth() || lable.getX() < 0) {
				vx = -vx;
				lable.move(vx, vy);
				pause(PAUSE_MS);
			}
		}
	}

	private GLabel myPanel() {
		GLabel lbl = new GLabel("D V D", 100, 100);
		lbl.setFont("Helvetica-24");
		add(lbl);
	    return lbl;
	}
}
