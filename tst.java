import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class tst extends GraphicsProgram{
	//
	private GRect rect;
	private GRect rect2;
	public void run() {
		rect = new GRect(100, 100);
		rect.setFilled(true);
		add(rect, 100, 100);
		
		rect2 = new GRect(100, 100);
		rect2.setFilled(true);
		add(rect2, 200, 200);
		
		addMouseListeners();
		addKeyListeners();
	}
	public void mouseClicked(MouseEvent e){
		
	}
	
	@override
	public void keTyped(KeyEvent e){
		//label.setLabel("key typed: " + )
		
	}
}
