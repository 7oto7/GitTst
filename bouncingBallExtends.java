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
			checkWalls();
		}
	}

	private void checkWalls() {
		if (ball.getX() + 2 * 40 >= getWidth() || ball.getX() < 0) { //right  and left walls,
			vx = -vx;                                                         //change vx spped
		}
		if (ball.getY() < 0 || ball.getY() + 2 * 40 >= getHeight()) { //upper wall, changes vy speed
			vy = -vy;
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

	public void mousePressed(MouseEvent e) {
		ball.setLocation(e.getX() - ball.getWidth() / 2, e.getY() - ball.getHeight() / 2);
		randomSpeed();

	}

	private GOval makeBall() {
		ball = new GOval(40, 40);
		ball.setFilled(true);
		add(ball, getWidth() / 2 - ball.getWidth() / 2, getHeight() / 2 - ball.getHeight() / 2);
		return ball;
	}
}
