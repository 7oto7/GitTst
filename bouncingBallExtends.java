import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class bouncingBallExtends extends GraphicsProgram {
	private GOval ball;
	private int vy;
	private int vx;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		addMouseListeners();
		makeBall();
		randomSpeed();
		moveBall();
	}

	private void moveBall() {
		while (true) {
			ball.move(vx, vy);
			pause(20);
		}
	}

	private void randomSpeed() {
		vx = rgen.nextInt(1, 2);
		vy = rgen.nextInt(1, 2);
		if (rgen.nextBoolean()) {
			vx = -vx;
		}
		if (rgen.nextBoolean()) {
			vy = -vy;
		}

	}

	public void MouseClicked(MouseEvent e) {
		remove(ball);
		add(ball, e.getX() - ball.getWidth() / 2, e.getY() + ball.getHeight());
		randomSpeed();

	}

	private GOval makeBall() {
		GOval ball = new GOval(20, 20);
		ball.setFilled(true);
		add(ball, getWidth() / 2 - ball.getWidth() / 2, getHeight() / 2 - ball.getHeight() / 2);
		return ball;
	}
}
