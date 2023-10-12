import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class problem12 extends GraphicsProgram {
	public void run(){
		int a = 5;
		a = a + 1;
		
		if(2 == 2){
			double b = 3;
			b = 4;
			b = a + 3;
			
			GLabel label = new GLabel ("a :" + a, 20, 20);
			add(label);
		}
		
	//	b = b + 1;
		
	}
}
