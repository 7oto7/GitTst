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
	
	private static final int EAR_WIDTH = 40;
	private static final int EAR_HEIGHT = 100;
	
	
	
	public void run() {
		drawFace();
		drawLeftEye();
		drawRightEye();
		drawMouth();
		drawLeftEar();
	}

	private void drawLeftEar() {
		GRect ear = new GRect(EAR_WIDTH, EAR_HEIGHT);
		ear.setFilled(true);
		ear.setFillColor(Color.white);
		double x = getWidth() / 2 + WIDTH / 2;
		double y = getHeight() / 2 - HEIGHT / 2 - EAR_HEIGHT / 2;
		add(ear, x, y);
		
	}

	private void drawMouth() {
		GRect mouth = new GRect(MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setFillColor(Color.white);
		add(mouth, getWidth() / 2 - MOUTH_WIDTH / 2, getHeight() / 2  + MOUTH_HEIGHT);
		
	}

	private void drawRightEye() {
		GOval rightEye = new GOval(EYE_WIDTH, EYE_HEIGHT);
		double x = (getWidth() - EYE_WIDTH) / 2 - EYE_WIDTH;
		double y = getHeight() / 2 - HEIGHT / 2 + EYE_HEIGHT * 2;
		rightEye.setFilled(true);;
		rightEye.setFillColor(Color.white);
		add(rightEye, x, y);
		
	}

	private void drawLeftEye() {
		GOval leftEye = new GOval(EYE_WIDTH, EYE_HEIGHT);
		double x = (getWidth() + EYE_WIDTH) / 2 ;
		double y = getHeight() / 2 - HEIGHT / 2 + EYE_HEIGHT * 2;
		leftEye.setFilled(true);;
		leftEye.setFillColor(Color.white);
		add(leftEye, x, y);
	}

	private void drawFace() {
		GRect face = new GRect(WIDTH, HEIGHT);
		double x = getWidth() / 2 - WIDTH / 2;
		double y = getHeight() / 2 - HEIGHT / 2;
		face.setFilled(true);
		face.setFillColor(Color.blue);
		add(face, x, y);	
	}
}