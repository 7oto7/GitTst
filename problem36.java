//თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები და დათვალოთ საშუალოდ
//რამდენჯერ უნდა ავაგდოთ მონეტა რათა 3-ჯერ ზედიზედ ამოვიდეს ბორჯღალო.
/* import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class problem36 extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int NUM_EXPERIMENTS = 1000;
	public void run() {
		double sumFlips = 0;
		for(int i = 0; i < NUM_EXPERIMENTS; i++){
			int currFlips = holdExperiment();
			sumFlips += currFlips;
		}
		double avgFlips = sumFlips / NUM_EXPERIMENTS;
		println(avgFlips);
	}
	private int holdExperiment() {
		int numFlips = 0;
		int heads = 0;
		while(true){
			numFlips++;
			boolean isHeads = rgen.nextBoolean();
			if(isHeads){
				heads++;
				if(heads == 3){
					break;
				}
			} else {
				heads = 0;
			}
		}
		return numFlips;
	}
}   */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class problem36 extends GraphicsProgram {	

	private static final int RECT_WIDTH = 150;
	private static final int RECT_HEIGHT = 50; 
	private static final int GAP_BETWEEN_RECTANGLES = 30;
	
	public void run() {
		drawEntireGraphic();
	}

	private void drawEntireGraphic() {
		int x = getWidth() / 2 - RECT_WIDTH / 2 - GAP_BETWEEN_RECTANGLES - RECT_WIDTH;
		int y = getHeight() / 2;
		int lineFirstX = x + RECT_WIDTH / 2;
		int lineFirstY = y;
		int lineLastX = getWidth() / 2;
		int lineLastY = y - RECT_HEIGHT;
		int count = 0;
		String text = "GraphicsProgram";
		
		rectangle(getWidth() / 2 - RECT_WIDTH / 2, getHeight() / 2 - 2 * RECT_HEIGHT, "Program");
		for(int i = 0; i < 3; i++){
			rectangle(x, y, text);
			GLine line = new GLine(lineFirstX, lineFirstY, lineLastX, lineLastY);
			add(line);
			count++;
			if(count == 1){
				text = "ConsoleProgram";
			} else {
				text = "DialogProgram";
			}
			x = x + RECT_WIDTH + GAP_BETWEEN_RECTANGLES;
			
			lineFirstX = lineFirstX + RECT_WIDTH + GAP_BETWEEN_RECTANGLES;
			
		}
	}

	private void rectangle(int i, int j, String string) {
		GRect rect = new GRect(RECT_WIDTH, RECT_HEIGHT);
		add(rect, i, j);
		GLabel glabel = new GLabel(string);
		double x = i + (RECT_WIDTH - glabel.getWidth()) / 2;
		double y = j + (RECT_HEIGHT  + glabel.getHeight()) / 2;
		add(glabel, x, y);
		
	}
}    







public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		drawPyramid();
	}

	private void drawPyramid() {
		int k = 0;
		int number = BRICKS_IN_BASE;
		for(int i = 0; i < BRICKS_IN_BASE; i++){
			for(int j = 0; j < number; j++){
				int x = getWidth() / 2 - (BRICKS_IN_BASE / 2) * BRICK_WIDTH + j * BRICK_WIDTH + k * (BRICK_WIDTH / 2);
				int y = getHeight() - BRICK_HEIGHT - i * BRICK_HEIGHT;
				GRect rect = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
				add(rect, x, y);
			}
			number--;
			k++;
		}
	}
}
























