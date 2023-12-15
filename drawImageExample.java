import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class drawImageExample extends GraphicsProgram {
	private static final int NUMBER_OF_PIXELS = 1100000;
	private static final int OVAL_SIZE = 1;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		    //mona liza
		//GImage image = new GImage("C:\\Users\\User\\Pictures\\download.jpg"); 
		    //monika beluchi
		//GImage image = new GImage("C:\\Users\\User\\Pictures\\HD-wallpaper-monica-bellucci-actress-face-woman-beauty.jpg");
		    //popovi dd
		//GImage image = new GImage("C:\\Users\\User\\Pictures\\FB_IMG_1702653878964.jpg");
		    //madison bear
		//GImage image = new GImage("C:/Users/User/Pictures/a5bc8d853003468dd2b8828153973f45.jpg");
		    //just someone
		//GImage image = new GImage("C:/Users/User/Pictures/adfbdae9847655fbcddc6538efd7da35.png");
		GImage image = new GImage("C:/Users/User/Pictures/three-naked-girls.jpg");
		impress(image);
	
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
