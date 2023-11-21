/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

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

	private GRect rect; //paddle
	private GOval ball; //ball
	private double vx = 1; //vx speed
	private double vy = 1;; //vy speed
	private GObject collider; //any object which is hit by a ball
	private int count; //count for winning
	private int countHealth; //count for losing
	private boolean ballIsPaused; //tells if ball starts from center or not
	private GImage background;
	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {

		buildSetup();
		playGame();

	}

	// builds everything we need to play the game
	private void buildSetup() {
		background = new GImage("C:\\Users\\User\\Pictures\\EsLqjamXMAEwmsw.png");
		background.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		background.sendBackward();
		add(background);
		makeBricks(NBRICK_ROWS, NBRICKS_PER_ROW, BRICK_SEP);// makes bricks
		makePaddle();// makes puddle
		makeBall();// makes ball
	}

	// makes everything to run the game process and waits for mouse click to
	// start playing
	private void playGame() {
		waitForClick();
		addMouseListeners();
		moveBall();
	}

	// this function moves ball by random vx and vy and also counts if player
	// has enough point to win game
	// or if he is run out of health to continue game.in each case, program
	// prints different texts
	private void moveBall() {
		while (true) {
			generateRandomSpeed();// generates random vx speed and direction
			startMoving();// starts moving
			if (winCount()) {// if player wins, program breaks,deletes
								// everything and prints specific text
				removeAll();
				printText("YOU WON", Color.GREEN);
				break;
			}
			if (loseCount()) {// if player loses program also breaks,
				removeAll(); // deletes everything and prints different text
				printText("YOU LOST", Color.RED);
				break;
			}

		}
	}

	// counts if player still has health to continue playing.
	// if he has, function returns false, if not - true.
	private boolean loseCount() {
		if (countHealth == NTURNS) {
			return true;
		}
		return false;
	}

	// counts points that player needs to reach to win the game
	// if he has enough, function returns true, if not - false
	private boolean winCount() {
		if (count == NBRICKS_PER_ROW * NBRICK_ROWS) {
			return true;
		}
		return false;
	}

	// this function makes quested label and prints it in the middle of the
	// canvas
	// with the specific color background
	private void printText(String string, Color color) {
		GLabel text = new GLabel(string);
		setBackground(color);
		text.setFont("Helvetica-50");
		double x = getWidth() / 2 - text.getWidth() / 2;
		double y = getHeight() / 2 + (50 - text.getHeight()) / 2 + text.getHeight() / 2;
		add(text, x, y);
	}

	// This function moves ball with pause time and check each time if it hits a
	// wall
	// or any element on the canvas.if ball hits walls, wall reflects ball and
	// changes its vx or vy speed
	// if ball hits any element, it acts differently in each occasion
	private void startMoving() {
		ball.move(vx, vy);
		pause(5);
		checkWalls();// checks walls
		getCollidingObject();// gets an element that ball crashed
		removeBricks();// removes element if it exists(not the paddle).
	}

	private void removeBricks() {
		if (getCollidingObject() != null) {// if ball hits something and it is not null
											
			ifColliderIsPaddle(); //if it is paddle 
			ifColliderIsBrick(); // if it is brick
		} 
	}

	//this function changes balls vx speed with vy if it is hit by sides of paddle
	//if ball is hit by upper parts of the paddle, it will change only vy speed
	private void ifColliderIsPaddle() {
		if (collider == rect) { //left and right sides
			if (collider == getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS)
					|| collider == getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS)) {
				if (vy > 0) {
					vx = -vx;
					vy = -vy;
				}
			} else {  //up and down sides
				if (vy > 0) {
					vy = -vy;
				}
			}
		}
	}

	//this function runs when ball hits any brick and it will remove colliding object.
	//balls vx speed will be changes if it will crush brick by left or right side
	// vy speed will change when balls' upper and down part will hit the brick
	private void ifColliderIsBrick() {
		if (collider != rect    // left and right sides
				&& (collider == getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS)
						|| collider == getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS))) {
			remove(collider);
			count++;
			System.out.println("dzlivs");
			vx = -vx;
		} else if (collider != rect) {// up and down sides
			remove(collider); 
			count++;
			vy = -vy;
		}
	}

	//This function checks four points of the ball moved by 1 pixel, in order not to return ball itself
	//and return object which is hit
	//if there is nothing on the indicated coordinate, function will return null
	private GObject getCollidingObject() {
		if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1) != null && getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1) != background) {// upper middle point
			
			collider = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1);
			
		} else if (getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS + 1) != null && getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS + 1) != background) {// down middle pont
			
			collider = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS + 1);
			
		} else if (getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS) != null && getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS) != background) {// right middle point
			
			collider = getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS);
			
		} else if (getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS) != null && getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS) != background) {// left middle point
			
			collider = getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS);
			
		} else {
			collider = null;
		}
		return collider;
	}

	//this function check all 4 walls and changes speed depend on whick wall ball hit
	private void checkWalls() {
		if (ball.getX() + 2 * BALL_RADIUS >= getWidth() || ball.getX() < 0) { //right  and left walls,
			vx = -vx;                                                         //change vx spped
		}
		if (ball.getY() < 0) { //upper wall, changes vy speed
			vy = -vy;
		}
		if (ball.getY() + 2 * BALL_RADIUS >= getHeight()) { // when ball hits bottom wall, player loses health
			remove(ball);               //and ball is placed in the center with 0 speed on each direction
			countHealth++;
			add(ball, getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS);
			vx = 0;
			vy = 0;
			pause(1000);
			ballIsPaused = true; // this is used to randomly generate balls vx speed only once when ball
			                  //is moving.
		}
	}

	//ballIsPaused means that ball starts from the center with 0 speed and it needs
	// vx and vy, so this function gives it random vx and vy = 1 speed only once and until
	//it crushes bottom wall
	private void generateRandomSpeed() {
		if (ballIsPaused == true) {
			vx = rgen.nextDouble(1.0, 3.0);
			if (rgen.nextBoolean(0.5)) {
				vx = -vx;
			}
			vy = 1;
			ballIsPaused = !ballIsPaused; // we need ballIsPauses to be false in order not to change
			                  //speed until player loses health and starts from the center with 0 speed
		}
	}

	//this function simply makes ball and places in the center
	private void makeBall() {
		ball = new GOval(2 * BALL_RADIUS, 2 * BALL_RADIUS);
		ball.setFilled(true);
		int x = getWidth() / 2 - BALL_RADIUS;
		int y = getHeight() / 2 - BALL_RADIUS;
		add(ball, x, y);
	}

	//this method is used to control paddle with mouse movement
	//paddles' middle x coordinates should be moved with mouse, so i calculated exactly the middle point
	//of the paddle which moves with mouse. paddle only moves on x axis.
	public void mouseMoved(MouseEvent e) {
		if (e.getX() <= PADDLE_WIDTH / 2) {
			rect.setLocation(0, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		} else if (e.getX() >= getWidth() - PADDLE_WIDTH / 2) {
			rect.setLocation(getWidth() - PADDLE_WIDTH, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		} else {
			rect.setLocation(e.getX() - PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}
	}

	//this function simply makes paddle and places where it should be
	private GRect makePaddle() {
		rect = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		rect.setFilled(true);
		int x = getWidth() / 2 - PADDLE_WIDTH / 2;
		int y = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		add(rect, x, y);
		return rect;
	}

	//this function makes brick walls with different colors on each line
	//if number of lines is more than 10, brick colors will be repeated depend on its remain
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
