
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import javafx.scene.layout.BackgroundImage;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class practiseBreakOut extends GraphicsProgram {

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
	//AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");

	private RandomGenerator rgen = RandomGenerator.getInstance();

	private GRect rect;
	private GOval ball;
	private double vx = 1;
	private double vy = 3;;
	private GObject collider;
	private int count;
	private int countHealth;
	private boolean ballIsStopped;
	private boolean playAgain = true;

	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		while(playAgain){
			removeAll();
			buildSetup();
			playGame();
		}
	}

	private void removeBricks() {
		if (firstUpperSide() != null && firstUpperSide() != rect) {
			remove(collider);
			System.out.print("works");
			vy = -vy;
		//	bounceClip.play();
		} else
		if (secondRightSide() != null && secondRightSide() != rect) {
			remove(collider);
			vx = -vx;
		//	bounceClip.play();
		} else if (secondRightSide() == rect) {
			if (vy > 0) {
				//System.out.println("blead");
			//	vx = -vx;
				vy = -vy;
			//	bounceClip.play();
			}
		} else 
		if (thirdDownSide() != null && thirdDownSide() != rect) {
			remove(collider);
			vy = -vy;
			//bounceClip.play();
		} else if (thirdDownSide() == rect) {
			vy = -vy;
			//bounceClip.play();
		} else
		if (fourthLeftSide() != null && fourthLeftSide() != rect) {
			remove(collider);
			vx = -vx;
			//bounceClip.play();
		} else if (fourthLeftSide() == rect) {
			if (vy > 0) {
				//vx = -vx;
				vy = -vy;
			//	bounceClip.play();
			}

		}

		// if (collider != null) {
		// if (collider != rect && ball.getY() <= collider.getY() + BRICK_HEIGHT
		// && ball.getY() >= collider.getY()) {
		// remove(collider);
		// vx = -vx;
		// vy = -vy;
		// count++;
		// } else if (collider != rect) {
		// remove(collider);
		// count++;
		// vy = -vy;
		// }
		// if (collider == rect && ball.getY() - 2 * BALL_RADIUS <= rect.getY()
		// ) {
		// if (vy > 0) {
		// vy = -vy;
		// }
		// } else if(collider == rect && ball.getY() + 2 * BALL_RADIUS >
		// rect.getY()){
		// if(vy > 0){
		// vy = -vy;
		// vx = -vx;
		// }
		// }
		//
		// }

	}
	private GObject fourthLeftSide() {
		for (int i = 226; i <= 315; i+=5) {
			if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
					ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i))) != null) {
				collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)));
			}
		}
		return collider;
	}

	private GObject thirdDownSide() {
		for (int i = 136; i <= 225; i+=5) {
			if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)),
					ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1) != null) {
				collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)),
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1);
			}
		}
		return collider;
	}

	private GObject secondRightSide() {
		for (int i = 46; i <= 135; i+=5) {
			if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
					ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i))) != null) {
				collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)));
			}
		}
		return collider;
	}

	private GObject firstUpperSide() {
		for (int i = -45; i <= 45; i+=5) {
			if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)),
					ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1) != null) {
				collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)),
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1);
			}
		}
		return collider;
	}

	private void getCollidingObject() {
		firstUpperSide();
		secondRightSide();
		thirdDownSide();
		fourthLeftSide();
	}

	private void moveBall() {
		while (true) {
			if (ballIsStopped == true) {
				waitForClick();
				vx = rgen.nextDouble(1.0, 3.0);
				if (rgen.nextBoolean(0.5)) {
					vx = -vx;
				}
				vy = 3;
				ballIsStopped = !ballIsStopped;
			}
			if (ballIsStopped == false) {
				//System.out.println("blead");
				ball.move(vx, vy);
				pause(10);
				checkWalls();
				getCollidingObject();
				removeBricks();
			}
			winCount();
			loseCount();
		}
	}

	private void loseCount() {
		if (countHealth == NTURNS) {
			removeAll();
			GLabel text = new GLabel("YOU LOST");
			setBackground(Color.RED);
			text.setFont("Helvetica-50");
			double x = getWidth() / 2 - (text.getWidth() - text.getDescent()) / 2;
			double y = getHeight() / 2 + text.getHeight() / 2;
			add(text, x, y);
		}
	}

	private void winCount() {
		if (count == NBRICKS_PER_ROW * NBRICK_ROWS) {
			removeAll();
			GLabel text = new GLabel("YOU WON");
			setBackground(Color.GREEN);
			text.setFont("Helvetica-50");
			double x = getWidth() / 2 - (text.getWidth() - text.getDescent()) / 2;
			double y = getHeight() / 2 + text.getHeight() / 2;
			add(text, x, y);
		}

	}

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
			ballIsStopped = true;

		}

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
				if (i == 0 || i == 1) {
					rect.setColor(Color.RED);
				}
				if (i == 2 || i == 3) {
					rect.setColor(Color.ORANGE);
				}
				if (i == 4 || i == 5) {
					rect.setColor(Color.YELLOW);
				}
				if (i == 6 || i == 7) {
					rect.setColor(Color.GREEN);
				}
				if (i == 8 || i == 9) {
					rect.setColor(Color.CYAN);
				}
				add(rect, x, y);
			}
		}
	}

	private void playGame() {
		waitForClick();
		addMouseListeners();
		moveBall();
	}

	private void buildSetup() {
		makeBricks(NBRICK_ROWS, NBRICKS_PER_ROW, BRICK_SEP);
		makePaddle();
		makeBall();
	}
}
