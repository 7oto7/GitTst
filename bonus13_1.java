import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class bonus13_1 extends GraphicsProgram {
	private GLine line;
	public void run() {
		while(true){
			//removeAll();
			remove(line);
			line = new GLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			add(line);
			pause(20);
		}
	}
}
