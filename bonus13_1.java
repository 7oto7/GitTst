import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class bonus13_1 extends GraphicsProgram {
	public void run() {
		while(true){
			removeAll();
			GLine line = new GLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			add(line);
			pause(20);
		}
	}
}
