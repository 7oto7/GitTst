
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class breakouttst extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	private RandomGenerator rgen = RandomGenerator.getInstance();

	private GRect rect;
	private GOval ball;
	private double vx = 1;
	private double vy = 3;;
	private GObject collider;
	private int count;
	private int countHealth;
	private boolean ballIsPaused;

	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {

		buildSetup();
		playGame();

	}

	private void playGame() {
		waitForClick();
		addMouseListeners();
		moveBall();
	}

	private void moveBall() {
		while (true) {
			generateRandomSpeed();
			startMoving();
			if(winCount()){
				removeAll();
			printText("YOU WON", Color.GREEN);
			break;
			}
			if(loseCount()){
				removeAll();
			printText("YOU LOST", Color.RED);
			break;
			}
			
		}
	}

	private boolean loseCount() {
		if (countHealth == NTURNS) {
			return true;
		}
		return false;
	}

	private boolean winCount() {
		if (count == NBRICKS_PER_ROW * NBRICK_ROWS) {
			return true;
		}
		return false;
	}

	private void printText(String string, Color color) {
		GLabel text = new GLabel(string);
		setBackground(color);
		text.setFont("Helvetica-50");
		double x = getWidth() / 2 - text.getWidth() / 2;
		double y = getHeight() / 2 + (50 - text.getHeight()) / 2 + text.getHeight() / 2;
		add(text, x, y);
	}

	private void startMoving() {
		ball.move(vx, vy);
		pause(10);
		checkWalls();
		getCollidingObject();
		removeBricks();
	}

	private void removeBricks() {
		if (getCollidingObject() != null) {
			if (collider == rect) {
				if (vy > 0) {
					vy = -vy;
				}
			} else if (collider != rect && (collider == getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1))
					|| collider == getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS + 1)) {
				remove(collider);
				count++;
				System.out.println("br");
				vy = -vy;
			} else if (collider != rect
					&& (collider == getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS)
							|| collider == getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS))) {
				remove(collider);
				count++;
				System.out.println("dzlivs");
				vx = -vx;
			}
		}
	}

	private GObject getCollidingObject() {
		if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1) != null) {// upper
			// middle
			collider = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1);
		} else if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS + 1) != null) {// down
			// middle
			collider = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS + 1);
		} else if (getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS) != null) {// right
			// middle
			System.out.println("right");
			collider = getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS);
		} else if (getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS) != null) {// left
			// middle
			System.out.println("left");
			collider = getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS);
		} else {
			collider = null;
		}

		return collider;
	}

	// private GObject getObjectToChangeXSpeed() {
	//
	// }

	// private GObject getObjectToChangeYSpeed() {
	// if (getElementAt(ball.getX(), ball.getY()) != null) {// upper left
	// // corner
	// collider = getElementAt(ball.getX(), ball.getY());
	// } else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY())
	// != null) {// upper
	// // right
	// // corner
	// collider = getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY());
	// } else if (getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS)
	// != null) {// bottom
	// // left
	// // corner
	// collider = getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
	// } else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() +
	// 2 * BALL_RADIUS) != null) {// bottom
	// // right
	// // corner
	// collider = getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() +
	// 2 * BALL_RADIUS);
	// }

	// }

	private void checkWalls() {
		if (ball.getX() + 2 * BALL_RADIUS >= getWidth() || ball.getX() < 0) {
			vx = -vx;
		}
		if (ball.getY() < 0) {
			vy = -vy;
		}
		if (ball.getY() + 2 * BALL_RADIUS >= getHeight()) {
			remove(ball);
			countHealth++;
			add(ball, getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS);
			vx = 0;
			vy = 0;
			pause(1000);
			ballIsPaused = true;
		}
	}

	private void generateRandomSpeed() {
		if (ballIsPaused == true) {
			// waitForClick();
			vx = rgen.nextDouble(1.0, 3.0);
			if (rgen.nextBoolean(0.5)) {
				vx = -vx;
			}
			vy = 3;
			ballIsPaused = !ballIsPaused;
		}
	}

	private void buildSetup() {
		makeBricks(NBRICK_ROWS, NBRICKS_PER_ROW, BRICK_SEP);
		makePaddle();
		makeBall();
	}

	private void makeBall() {
		ball = new GOval(2 * BALL_RADIUS, 2 * BALL_RADIUS);
		ball.setFilled(true);
		int x = getWidth() / 2 - BALL_RADIUS;
		int y = getHeight() / 2 - BALL_RADIUS;
		add(ball, x, y);
	}

	public void mouseMoved(MouseEvent e) { ///// 299/////
		if (e.getX() <= PADDLE_WIDTH / 2) {
			rect.setLocation(0, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		} else if (e.getX() >= getWidth() - PADDLE_WIDTH / 2) {
			rect.setLocation(getWidth() - PADDLE_WIDTH, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		} else {
			rect.setLocation(e.getX() - PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}
	}

	private GRect makePaddle() {
		rect = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		rect.setFilled(true);
		int x = getWidth() / 2 - PADDLE_WIDTH / 2;
		int y = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		add(rect, x, y);
		return rect;
	}

	private void makeBricks(int n1, int n2, int n3) {
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				GRect rect = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
				rect.setFilled(true);
				double x = (getWidth() - BRICK_WIDTH * NBRICKS_PER_ROW - ((NBRICKS_PER_ROW - 1) * BRICK_SEP)) / 2
						+ j * (BRICK_WIDTH + BRICK_SEP);
				double y = BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP);
				if (i % 10 == 0 || i % 10 == 1) {
					rect.setColor(Color.RED);
				}
				if (i % 10 == 2 || i % 5 == 3) {
					rect.setColor(Color.ORANGE);
				}
				if (i % 10 == 4 || i % 10 == 5) {
					rect.setColor(Color.YELLOW);
				}
				if (i % 10 == 6 || i % 10 == 7) {
					rect.setColor(Color.GREEN);
				}
				if (i % 10 == 8 || i % 10 == 9) {
					rect.setColor(Color.CYAN);
				}
				add(rect, x, y);
			}
		}
	}
}
