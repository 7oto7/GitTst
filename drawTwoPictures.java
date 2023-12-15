import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.Color;

public class drawTwoPictures extends GraphicsProgram {
    private static final int NUMBER_OF_PIXELS = 1000000;
    private static final int OVAL_SIZE = 1;
    private RandomGenerator rgen = RandomGenerator.getInstance();

    public void run() {
        GImage image1 = new GImage("C:\\Users\\User\\Desktop\\HD-wallpaper-monica-bellucci-actress-face-woman-beauty.jpg");
        GImage image2 = new GImage("C:\\Users\\User\\Desktop\\FB_IMG_1702653878964.jpg");

        impress(image1, 0, 0);
        impress(image2, image1.getWidth(), 0);
    }

    private void impress(GImage image, double xOffset, double yOffset) {
        int[][] array = image.getPixelArray();

        for (int i = 0; i < NUMBER_OF_PIXELS; i++) {
            int r = rgen.nextInt(array.length);
            int c = rgen.nextInt(array[0].length);

            Color color = new Color(array[r][c]);
            add(getOval(c + xOffset, r + yOffset, color));
        }
    }

    private GObject getOval(double c, double r, Color color) {
        GOval o = new GOval(c - OVAL_SIZE / 2, r - OVAL_SIZE / 2, OVAL_SIZE, OVAL_SIZE);
        o.setFilled(true);
        o.setColor(color);
        return o;
    }
}