//დაწერეთ პროგრამა სადაც იქნება კანვასზე ბურთის მოძრაობა მარცხენა კედლის შუა
//წერტილიდან მარჯვენა კედლამდე.
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class problem39 extends GraphicsProgram {
	private static final int SPEED = 5;

	public void run() {
		makeCircle(20, 20);
		
	}

	private void makeCircle(int i, int j) {
		GOval oval = new GOval(i * 2, j * 2);
		int x = 0;
		int y = getHeight() / 2 - j;
		add(oval, x, y);
	}
}
