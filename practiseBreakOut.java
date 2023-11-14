
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

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
	private static final int NBRICKS_PER_ROW = 4;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 4;

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
	private static final int NTURNS = 50;

	private RandomGenerator rgen = RandomGenerator.getInstance();

	private GRect rect;
	private GOval ball;
	private double vx = 1;
	private double vy = 3;;
	private GObject collider;
	private int count;
	private int countHealth;
	private boolean ballIsStopped;
	private boolean sheexo_padls = false;

	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		makeBricks(NBRICKS_PER_ROW, NBRICK_ROWS, BRICK_SEP);
		makePaddle();
		makeBall();
		
		waitForClick();
		addMouseListeners();
		moveBall();

	}
	

	private void removeBricks() {
	
		if (collider != null) {
			if (collider == rect && sheexo_padls==false ) {
				if(vy > 0){
					vy = -vy;
				}
				sheexo_padls=true;
			}  
			else if(collider != rect) {
				sheexo_padls=false;
				remove(collider);
				count++;
				vy = -vy;
			}
		}
	}

	
	private GObject getCollidingObject() {

		if (getElementAt(ball.getX(), ball.getY()) != null) {// upper left corner
			collider = getElementAt(ball.getX(), ball.getY());
		} else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY()) != null) {// upper right corner
			collider = getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY());		
		} else if (getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS) != null) {// bottom left corner
			collider = getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
		} else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS) != null) {// bottom right corner
			collider = getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS);
		} else if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY()) != null) {// upper middle
			collider = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1);
		} else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + BALL_RADIUS) != null) {// right middle
			collider = getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS);
		} else if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS) != null) {// down middle
			collider = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS + 1);
		} else if (getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS) != null ) {// left middle
			collider = getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS);
		} 
//		else if (getElementAt(rect.getX(), rect.getY()) != null){
//			collider = getElementAt(rect.getX(), rect.getY());
//		} else if (getElementAt(rect.getX() + PADDLE_WIDTH, rect.getY()) != null){
//			collider = getElementAt(rect.getX() + PADDLE_WIDTH, rect.getY());
//		}
		return collider;
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
				// vy = 3;
				ball.move(vx, vy);
				pause(5);
				checkWalls();
				getCollidingObject();
				removeBricks();
			}
			if (count == NBRICKS_PER_ROW * NBRICK_ROWS) {
				removeAll();
				GLabel text = new GLabel("YOU WON");
				setBackground(Color.GREEN);
				text.setFont("Helvetica-50");
				double x = getWidth() / 2 - (text.getWidth() - text.getDescent()) / 2;
				double y = getHeight() / 2 + text.getHeight() / 2;
				add(text, x, y);
			}
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
			sheexo_padls = false;
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
			rect.setLocation(getWidth() - PADDLE_WIDTH, getHeight() - PADDLE_Y_OFFSET);
		} else {
			rect.setLocation(e.getX() - PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET);
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
				int x = BRICK_SEP / 2 + j * (BRICK_WIDTH + BRICK_SEP);
				int y = BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP);
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

}
