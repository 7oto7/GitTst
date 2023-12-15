import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class finaleeee extends GraphicsProgram {
	private static final int NUMBER_OF_PIXELS = 700000;
	private static final int OVAL_SIZE = 1;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		GImage image = new GImage("C:/Users/User/Pictures/adfbdae9847655fbcddc6538efd7da35.png");
		GImage image2 = new GImage("C:/Users/User/Pictures/Screenshot 2023-12-15 204546.png");
		//impress(image);
		//impress(image2);
		GLabel lb = new GLabel("Buy premium to unlock this picture");
		add(lb);
	}

	private void impress(GImage image) {
		// TODO Auto-generated method stub
		int[][] array = image.getPixelArray();

		for (int i = 0; i < NUMBER_OF_PIXELS; i++) {
			int r = rgen.nextInt(array.length);
			int c = rgen.nextInt(array[0].length);
			
			Color color = new Color(array[r][c]);
			add(getOval(c, r, color));
		}
	}

	private GObject getOval(int c, int r, Color color) {
		// TODO Auto-generated method stub
		GOval o = new GOval(c - OVAL_SIZE / 2, r - OVAL_SIZE / 2, OVAL_SIZE, OVAL_SIZE);
		o.setFilled(true);
		o.setColor(color);
		return o;
	}
}
