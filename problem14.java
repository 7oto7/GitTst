import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

public class problem14 extends GraphicsProgram {
//	constants
	private static final int WIDTH = 200;
	private static final int HEIGHT = 300;

	private static final int EYE_WIDTH = 60;
	private static final int EYE_HEIGHT = 40;
	
	private static final int MOUTH_WIDTH = 100;
	private static final int MOUTH_HEIGHT = 40;
	
	public void run() {
		drawFace();
	//	drawLeftEye();
		//drawRightEye();
		//drawMouth();
	}

	private void drawFace() {
		GRect face = new GRect(WIDTH, HEIGHT);
		double x = getWidth() / 2 - WIDTH / 2;
		double y = getHeight() / 2 - HEIGHT / 2;
		
	}
}