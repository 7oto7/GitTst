import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class dedasSgeveci extends GraphicsProgram{
	private GOval ball;
	private Boolean vax = false;
	public void run(){
		makeBall();
		addMouseListeners();
//		while(true){
//			moveBall();
//		}
		
	}
	private void moveBall() {
		while(vax){
			ball.move(0, 5);
			pause(200);
		}
	}
	private void makeBall() {
		ball = new GOval(40, 40);
		ball.setFilled(true);
		add(ball, 100, 100);
	}
	public void mouseClicked(MouseEvent e){
		vax = !vax;
		GOval obj = (GOval)getElementAt(e.getX(), e.getY());
		if(obj != null){
			 ball = obj;
			moveBall();
		} 
		
	}
}
