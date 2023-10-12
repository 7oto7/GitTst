import java.awt.Color;

import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class problem11 extends GraphicsProgram {	
	private static final double HOUSE_WIDTH = 200;
	private static final double HOUSE_HEIGHT = 200;
	private static final double DOOR_WIDTH = 200;
	private static final double DOOR_HEIGHT = 200;
	private static final double ROOF_HEIGHT = 100;
	public void run() {
		
		DrawHouse();
		
	}
	
	private void DrawHouse() {
		drawWall();
		drawRoof();
	//	drawDoor();
	//	drawWindows();
		
	}
	
	private void drawRoof() {
		double x1 = getWidth() / 2 - HOUSE_WIDTH / 2;
		double y1 = getHeight() - HOUSE_HEIGHT;
		double x2 = x1 + HOUSE_WIDTH / 2;
		double y2 = y1 - ROOF_HEIGHT;;
		GLine leftRoof = new GLine(x1, y1, x2, y2);
		add(leftRoof);
		
	}

	private void drawWall() {
		GRect wall = new GRect(HOUSE_WIDTH, HOUSE_HEIGHT);
		int x = (int) (getWidth() / 2 - HOUSE_WIDTH / 2); //dakastva mrgvaldeba yoveltvis dabla, 3.1=3, 3.9=3;
		double y = getHeight() - HOUSE_HEIGHT;
		add(wall, x, y);		
	}
}
