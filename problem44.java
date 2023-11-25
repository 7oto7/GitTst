import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

//მაუსის კლიკზე იმავე ადგილზე ჩნდება ბურთი და იწყებს ვარდნას ძირს, თუ მაუსს სხვა
/*ადგილზე ვაკლიკებ ბურთი გადადის ახალ ადგილზე და იქედან იწყებს ვარდნას*/
public class problem44 extends GraphicsProgram{
	private GOval circle;
	private static final int RADIUS = 50;
	private int x;
	private int y;
	private static final int V_Y = 5;
	public void run(){
		circle = new GOval(RADIUS, RADIUS);
		circle.setFilled(true);
		addMouseListeners();

		moveBall();
		
	}
	private void moveBall() {
		while(true){
			circle.move(0, V_Y);
			pause(20);
		}
	}
	public void mouseClicked(MouseEvent e){
		x = e.getX() - RADIUS / 2;
		y = e.getY() - RADIUS / 2;		
		add(circle, x, y);

	}
	
}
