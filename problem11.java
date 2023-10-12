import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class problem11 extends GraphicsProgram {	
	private static final double HOUSE_WIDTH = 200;
	private static final double HOUSE_HEIGHT = 200;
	private static final double DOOR_WIDTH = 200;
	private static final double DOOR_HEIGHT = 200;
	public void run() {
		
		DrawHouse();
	}
	private void DrawHouse() {
		drawWall();
		drawRoof();
		drawDoor();
		drawWindows();
		
	}
	
	private void drawWall() {
		GRect wall = new GRect(HOUSE_WIDTH, HOUSE_HEIGHT);
		int x = (int) (getWidth() / 2 - HOUSE_WIDTH / 2); //dakastva mrgvaldeba yoveltvis dabla, 3.1=3, 3.9=3;
		int y = getHeight() - getHeight();
		add(wall, x, y);		
	}
}
