//გააკეთეთ Paint-ის ფანქრის ანალოგიური ხელსაწყო. კერძოდ, მაუსის ყოველ მოძრაობაზე
//ეკრანზე დაამატეთ გაფერადებული წრეწირები იმავე წერტილში სადაც მაუსი მდებარეობს.
import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class problem41 extends GraphicsProgram{
	RandomGenerator rgen = RandomGenerator.getInstance();
	public void run(){
		addMouseListeners();
	}
	public void mouseMoved(MouseEvent e){
		makeBall(e.getX(), e.getY());
	}
	private void makeBall(int x, int y) {
		GOval oval = new GOval(20, 20);
		oval.setFilled(true);
		oval.setFillColor(rgen.nextColor());
		add(oval, x - oval.getWidth() / 2, y - oval.getHeight() / 2);
	}
}
