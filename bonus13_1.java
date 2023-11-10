import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class bonus13_1 extends GraphicsProgram{
	public void run(){
		version1();
//		version2();
	//	version3();
	}

	private void version1() {
		while(true){
			removeAll();
			GLine line = new GLine (0, getHeight() / 2, getWidth(), getHeight() / 2);
			add(line);
			pause(20);
		}
		
	}
}
