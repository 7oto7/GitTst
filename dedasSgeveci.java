import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class dedasSgeveci extends GraphicsProgram{
	private Boolean vax;
	private GOval ball;
	public void run(){
		makeBall();
		addMouseListeners();
		while(true){
			moveBall();
		}
		
	}
	private void moveBall() {
		if(ball != null){
		while(vax){
			ball.move(0, 50);
			pause(100);
		}	
		}
		
	}
	private void makeBall() {
		ball = new GOval(40, 40);
		ball.setFilled(true);
		add(ball, 100, 100);
	}
	public void mouseclicked(MouseEvent e){
		GOval obj = (GOval)getElementAt(e.getX(), e.getY());
		if(obj != null){
			obj = ball;
		} else {
			vax = false;
		}
		
	}
}
