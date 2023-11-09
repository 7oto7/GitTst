import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class bonus13_1 extends GraphicsProgram {
	public void run() {
		GLine line = new GLine(0, getHeight() / 2, getWidth() / 2, getHeight() / 2);
		add(line);
		pause(20);
	}
}
