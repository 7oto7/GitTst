import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class dedasSgeveci extends GraphicsProgram{
	private GOval ball;
	public void run(){
		makeBall();
		
	}
	private void makeBall() {
		ball = new GOval(20, 20);
		ball.setFilled(true);
		add(ball, 100, 100);
	}
}
