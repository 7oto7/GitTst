import acm.graphics.*;
import acm.program.*;
import java.awt.*;
//////////////////////////////////////////////////////////////////
//////////////////doublebshi chawerilii///////////////////////////
//////////////////////////////////////////////////////////////////
public class problem32 extends GraphicsProgram {	

	private static final int RECT_WIDTH = 150;
	private static final int RECT_HEIGHT = 50; 
	private static final int GAP_BETWEEN_RECTANGLES = 30;
	
	public void run() {
		double x = getWidth() / 2 - RECT_WIDTH / 2 - GAP_BETWEEN_RECTANGLES - RECT_WIDTH;
		double y = getHeight() / 2;
		double lineFirstX = x + RECT_WIDTH / 2;
		double lineFirstY = y;
		double lineLastX = getWidth() / 2;
		double lineLastY = y - RECT_HEIGHT;
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

	private void rectangle(double i, double j, String string) {
		GRect rect = new GRect(RECT_WIDTH, RECT_HEIGHT);
		add(rect, i, j);
		GLabel glabel = new GLabel(string);
		double x = i + (RECT_WIDTH - glabel.getWidth()) / 2;
		double y = j + (RECT_HEIGHT  + glabel.getHeight()) / 2;
		add(glabel, x, y);
		
	}
}

