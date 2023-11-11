import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class tst extends GraphicsProgram {
	private GObject gobj; /* The object being dragged */
	private GPoint last; /* The last mouse position */
	private RandomGenerator rgen = RandomGenerator.getInstance();

	private GRect rect;
	private GRect rect2;

	public void run() {
		rect = new GRect(100, 100);
		rect.setFilled(true);
		add(rect, 100, 100);

		rect2 = new GRect(100, 100);
		rect2.setFilled(true);
		add(rect2, 200, 200);

		addMouseListeners();
		addKeyListeners();
	}

	public void mouseClicked(MouseEvent e) {
		// GPoint has X and Y coordinate
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	}

	public void mouseDragged(MouseEvent e) {
		if (gobj != null) {
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}

	@override
	public void keyTyped(KeyEvent e) {
		// label.setLabel("key typed: " + )

	}
}
