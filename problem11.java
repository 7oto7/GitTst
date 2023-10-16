import java.awt.Color;

import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class problem11 extends GraphicsProgram {	
	private static final double HOUSE_WIDTH = 200;
	private static final double HOUSE_HEIGHT = 200;
	private static final double DOOR_WIDTH = 60;
	private static final double DOOR_HEIGHT = 100;
	private static final double ROOF_HEIGHT = 100;
	private static final double WINDOW_WIDTH = 40;
	private static final double WINDOW_HEIGHT = 60;
	public void run() {
		
		DrawHouse();
		
	}
	
	private void DrawHouse() {
		drawWall();
		drawRoof();
		drawDoor();
		drawWindows();
		
	}
	
	private void drawWindows() {
		for (int i = 0; i < 2; i++) {
			double y = getHeight() - HOUSE_HEIGHT + WINDOW_HEIGHT / 2;
			double x;
			if(i == 0) {
				x = getWidth() / 2 - HOUSE_WIDTH / 2 + WINDOW_WIDTH / 2;
			} else {
				x = getWidth() / 2 + HOUSE_WIDTH / 2 - WINDOW_WIDTH * 3 / 2;
			}
			
			GRect window = new GRect(WINDOW_WIDTH, WINDOW_HEIGHT);
			add(window, x, y);
		}
		
		
	}

	private void drawDoor() {
		GRect door = new GRect(DOOR_WIDTH, DOOR_HEIGHT);
		int x = (int) (getWidth() / 2 - DOOR_WIDTH / 2);
		double y = getHeight() - DOOR_HEIGHT;
		door.setFilled(true);
		door.setFillColor(Color.black);
		door.setColor(Color.red);
		add(door, x, y);
		
	}

	private void drawRoof() {
		double x1 = getWidth() / 2 - HOUSE_WIDTH / 2;
		double y1 = getHeight() - HOUSE_HEIGHT;
		double x2 = x1 + HOUSE_WIDTH / 2;
		double y2 = y1 - ROOF_HEIGHT;;
		GLine leftRoof = new GLine(x1, y1, x2, y2);
		add(leftRoof);
		
		x1 = x2;
		y1 = y2;
		x2 = x1 + HOUSE_WIDTH / 2;
		y2 = y1 + ROOF_HEIGHT;
		
		GLine rightRoof = new GLine(x1, y1, x2, y2);
		add(rightRoof);
		
	}

	private void drawWall() {
		GRect wall = new GRect(HOUSE_WIDTH, HOUSE_HEIGHT);
		int x = (int) (getWidth() / 2 - HOUSE_WIDTH / 2); //dakastva mrgvaldeba yoveltvis dabla, 3.1=3, 3.9=3;
		double y = getHeight() - HOUSE_HEIGHT;
		wall.setFilled(true);
		wall.setFillColor(Color.red);
		add(wall, x, y);		
	}
}
