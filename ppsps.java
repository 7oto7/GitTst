
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import javafx.scene.layout.BackgroundImage;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ppsps extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	// private static final int PADDLE_WIDTH = 60;
	private int PADDLE_WIDTH = 60;
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
	private int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;
	// AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");

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
	private int justCount = 1;
	private int yourScore = 0;
	private int highestScore = 0;
	private GLabel label;
	private GLabel highest;
	private GLabel lives;
	private int health = NTURNS;
	private int speed = 8;
	private int speedCount = 0;
	private int mouseX;
	private int difX;
	private int prevMouseX = 0;
	private boolean gameLost = false;


	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		addMouseListeners();

		while (playAgain) {
			playAgain = !playAgain;
			removeAll();
			setBackground(Color.WHITE);
			buildSetup();
			playGame();
		}
	}

	private void removeBricks() {
		if (getCollidingObject() != lives) {
			if (getCollidingObject() != highest) {
				if (getCollidingObject() != label) {
					if (getCollidingObject() != null) {

						ifColliderIsPaddle();
						ifColliderIsBrick();
					}
				}
			}
		}
	}

	private void ifColliderIsPaddle() {
		if (collider == rect) {
			if (difX >= 0 && vx < 0) {
				if (vy > 0) {
					vx = -vx;
					vy = -vy;
				}
			} else if (difX >= 0 && vx > 0) {
				if (vy > 0) {
					vy = -vy;
				}
			} else if (difX <= 0 && vx > 0) {
				if (vy > 0) {
					vx = -vx;
					vy = -vy;
				}
			} else if (difX <= 0 && vx < 0) {
				if (vy > 0) {
					vy = -vy;
				}
			} else {
				vy = -vy;
			}
		}
	}

	private void ifColliderIsBrick() {
		if (collider != rect && collider == secondRightSide()) {
			vx = -vx;
			remove(collider);
			countDifScore();
			randomThingHappens();
			count++;
			speedCount++;
			if (speedCount % 7 == 0 && speed > 3) {
				speed = speed - 1;
			}
		} else if (collider != rect && collider == fourthLeftSide()) {
			vx = -vx;
			remove(collider);
			countDifScore();
			randomThingHappens();
			count++;
			speedCount++;
			if (speedCount % 7 == 0 && speed > 3) {
				speed = speed - 1;
			}
		} else if (collider != rect && collider == firstUpperSide()) {// up and
																		// down
																		// sides
			vy = -vy;
			ball.move(vx, vy);
			remove(collider);
			countDifScore();
			randomThingHappens();
			count++;
			speedCount++;
			if (speedCount % 7 == 0 && speed > 3) {
				speed = speed - 1;
			}
		} else if (collider != rect && collider == thirdDownSide()) {
			vy = -vy;
			ball.move(vx, vy);
			remove(collider);
			countDifScore();
			randomThingHappens();
			count++;
			speedCount++;
			if (speedCount % 7 == 0 && speed > 3) {
				speed = speed - 1;
			}
		}
	}

	private void randomThingHappens() {
		if (collider.getColor() == Color.WHITE) {
			int randomNumber = rgen.nextInt(1, 6);
			if (randomNumber == 1) {
				remove(rect);
				PADDLE_WIDTH = PADDLE_WIDTH - 20;
				makePaddle(PADDLE_WIDTH, PADDLE_HEIGHT, mouseX - PADDLE_WIDTH / 2);

			} else if (randomNumber == 2) {
				remove(rect);
				PADDLE_WIDTH = PADDLE_WIDTH + 20;
				makePaddle(PADDLE_WIDTH, PADDLE_HEIGHT, mouseX - PADDLE_WIDTH / 2);

			} else if (randomNumber == 3) {
				health++;
				remove(lives);
				lives = new GLabel("Lives left: " + health);
				lives.setFont("Helvetica-15");
				lives.setColor(Color.WHITE);
				add(lives, highest.getWidth() + highest.getX() + (highest.getX() - label.getX() - label.getWidth()),
						20);
			} else if (randomNumber == 4) {
				remove(ball);
				BALL_RADIUS = BALL_RADIUS - 2;
				makeBall(BALL_RADIUS, BALL_RADIUS, ball.getX(), ball.getY());

			} else if (randomNumber == 5) {
				remove(ball);
				BALL_RADIUS = BALL_RADIUS + 5;
				makeBall(BALL_RADIUS, BALL_RADIUS, ball.getX(), ball.getY());
				if (ball.getX() + 2 * BALL_RADIUS > getWidth()) {
					ball.setLocation(ball.getX() - (2 * BALL_RADIUS - (getWidth() - ball.getX())), ball.getY());
				}
			}
		}
	}

	private void countDifScore() {
		if (collider.getColor() == Color.CYAN) {
			yourScore = yourScore + 1;
		} else if (collider.getColor() == Color.GREEN) {
			yourScore = yourScore + 2;
		} else if (collider.getColor() == Color.YELLOW) {
			yourScore = yourScore + 3;
		} else if (collider.getColor() == Color.ORANGE) {
			yourScore = yourScore + 4;
		} else if (collider.getColor() == Color.RED) {
			yourScore = yourScore + 5;
		}
	}

	private GObject fourthLeftSide() {
		for (int i = 236; i <= 305; i += 2) {
			if (i < 270) {
				if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1) != null) {
					collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
							ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1);
					return collider;
				}
			} else {
				if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1) != null) {
					collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
							ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1);
					return collider;
				}
			}

		}
		return null;
	}

	private GObject thirdDownSide() {
		for (int i = 126; i <= 235; i += 2) {
			if (i < 180) {
				if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1) != null) {
					collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
							ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1);
					return collider;
				}
			} else {
				if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1) != null) {
					collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
							ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1);
					return collider;
				}

			}

		}
		return null;
	}

	private GObject secondRightSide() {
		for (int i = 56; i <= 125; i += 2) {
			if (i < 90) {
				if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1) != null) {
					collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
							ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1);
					return collider;
				} else {
					if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
							ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1) != null) {
						collider = getElementAt(
								ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
								ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) + 1);
						return collider;

					}
				}

			}
		}
		return null;
	}

	private GObject firstUpperSide() {
		for (int i = -55; i <= 55; i += 2) {
			if (i < 0) {
				if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1) != null) {
					collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) - 1,
							ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1);
					return collider;
				}
			} else {
				if (getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
						ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1) != null) {
					collider = getElementAt(ball.getX() + BALL_RADIUS + BALL_RADIUS * Math.sin(Math.toRadians(i)) + 1,
							ball.getY() + BALL_RADIUS - BALL_RADIUS * Math.cos(Math.toRadians(i)) - 1);
					return collider;
				}

			}

		}
		return null;
	}

	private GObject getCollidingObject() {

		if (firstUpperSide() != null) {
			collider = firstUpperSide();
		} else if (secondRightSide() != null) {
			collider = secondRightSide();
		} else if (thirdDownSide() != null) {
			collider = thirdDownSide();
		} else if (fourthLeftSide() != null) {
			collider = fourthLeftSide();
		} else {
			collider = null;
		}
		return collider;
	}

	private void moveBall() {
		while (true) {
			if (ballIsStopped == true) {
				waitForClick();
				gameLost = true;
				vx = rgen.nextDouble(1.0, 3.0);
				if (rgen.nextBoolean(0.5)) {
					vx = -vx;
				}
				vx = 1;
				vy = 3;
				ballIsStopped = !ballIsStopped;
			}
			if (ballIsStopped == false) {
				ball.move(vx, vy);
				pause(speed);
				checkWalls();
				getCollidingObject();
				removeBricks();
				countScore();
			}
			if (winCount()) {
				removeAll();

				vx = 0;
				vy = 0;
				ballIsStopped = true;

				GImage winner = new GImage(
						"C:\\Users\\User\\Pictures\\pngtree-game-over-with-yellow-trophy-pixel-style-vector-png-image_2914623.jpg");
				winner.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
				add(winner);
				GLabel click = new GLabel("Click anywhere to start again");
				click.setFont("Helvetica-20");
				add(click, 80, 420);
				break;
			}
			if (loseCount()) {
				removeAll();
				GImage winner = new GImage(
						"C:\\Users\\User\\Pictures\\pngtree-game-over-sign-lose-creative-pixel-8-bit-style-png-image_2914643.jpg");
				winner.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
				add(winner);
				GLabel click = new GLabel("Click anywhere to start again");
				click.setFont("Helvetica-20");
				add(click, 80, 420);

				break;
			}

		}
	}

	private void countScore() {
		remove(label);
		label = new GLabel("Current score: " + yourScore);
		label.setFont("Helvetica-15");
		label.setColor(Color.WHITE);
		add(label, 15, 20);
	}

	private Boolean loseCount() {
		if (countHealth == NTURNS) {
			return true;
		}
		return false;
	}

	private Boolean winCount() {
		if (count == NBRICKS_PER_ROW * NBRICK_ROWS) {
			return true;
		}
		return false;
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
			remove(rect);
			add(rect, getWidth() / 2 - PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);

			vx = 0;
			vy = 0;
			gameLost = false;
			ballIsStopped = true;
			health = health - 1;
			speedCount = 0;
			speed = 8;

			remove(lives);
			lives = new GLabel("Lives left: " + health);
			lives.setFont("Helvetica-15");
			lives.setColor(Color.WHITE);
			add(lives, highest.getWidth() + highest.getX() + (highest.getX() - label.getX() - label.getWidth()), 20);
		}

	}

	private void makeBall(int i, int j, double k, double l) {
		ball = new GOval(2 * i, 2 * j);
		ball.setFilled(true);
		ball.setColor(Color.WHITE);
		double x = k;
		double y = l;
		add(ball, x, y);
	}

	public void mouseMoved(MouseEvent e) {
		if (gameLost == true) {
			prevMouseX = mouseX;
			mouseX = e.getX();
			difX = mouseX - prevMouseX;
			if (e.getX() <= PADDLE_WIDTH / 2) {
				rect.setLocation(0, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
			} else if (e.getX() >= getWidth() - PADDLE_WIDTH / 2) {
				rect.setLocation(getWidth() - PADDLE_WIDTH, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
			} else {
				rect.setLocation(e.getX() - PADDLE_WIDTH / 2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
			}

		}

	}

	private GRect makePaddle(int x1, int y2, int i) {
		rect = new GRect(x1, y2);
		rect.setFilled(true);
		rect.setColor(Color.WHITE);
		int y = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		add(rect, i, y);
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
					boolean helper = rgen.nextBoolean(0.05);
					if (helper) {
						rect.setColor(Color.WHITE);
					}
				}
				if (i == 2 || i == 3) {
					rect.setColor(Color.ORANGE);
					boolean helper = rgen.nextBoolean(0.05);
					if (helper) {
						rect.setColor(Color.WHITE);
					}
				}
				if (i == 4 || i == 5) {
					rect.setColor(Color.YELLOW);
					boolean helper = rgen.nextBoolean(0.05);
					if (helper) {
						rect.setColor(Color.WHITE);
					}
				}
				if (i == 6 || i == 7) {
					rect.setColor(Color.GREEN);
					boolean helper = rgen.nextBoolean(0.05);
					if (helper) {
						rect.setColor(Color.WHITE);
					}
				}
				if (i == 8 || i == 9) {
					rect.setColor(Color.CYAN);
					boolean helper = rgen.nextBoolean(0.05);
					if (helper) {
						rect.setColor(Color.WHITE);
					}
				}
				add(rect, x, y);
			}
		}
	}

	private void playGame() {
		if (justCount == 1) {
			waitForClick();
			gameLost = !gameLost;
		}

		moveBall();
		waitForClick();
		everythingAgain();

	}

	private void everythingAgain() {

		playAgain = !playAgain;

		countHealth = 0;
		if (yourScore > highestScore) {
			highestScore = yourScore;
		}
		yourScore = 0;
		justCount++;
		health = NTURNS;
		if (count == NBRICKS_PER_ROW * NBRICK_ROWS) {
			highestScore = 0;
		}
		count = 0;
		PADDLE_WIDTH = 60;
		BALL_RADIUS = 10;
	}

	private void buildSetup() {
		Color uniqueColor = new Color(64, 224, 208);
		setBackground(uniqueColor);
		makeBricks(NBRICK_ROWS, NBRICKS_PER_ROW, BRICK_SEP);
		makePaddle(PADDLE_WIDTH, PADDLE_HEIGHT, getWidth() / 2 - PADDLE_WIDTH / 2);
		makeBall(BALL_RADIUS, BALL_RADIUS, getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS);
		label = new GLabel("Current score: " + yourScore);
		label.setFont("Helvetica-15");
		label.setColor(Color.WHITE);
		add(label, 15, 20);

		highest = new GLabel("Highest score: " + highestScore);
		highest.setFont("Helvetica-15");
		highest.setColor(Color.WHITE);
		add(highest, getWidth() / 2 - highest.getWidth() / 2 + 15, 20);

		lives = new GLabel("Lives left: " + health);
		lives.setFont("Helvetica-15");
		lives.setColor(Color.WHITE);
		add(lives, highest.getWidth() + highest.getX() + (highest.getX() - label.getX() - label.getWidth()), 20);
	}
}