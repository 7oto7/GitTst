
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.awt.event.*;

public class gpt extends GraphicsProgram {

    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;
    private static final int PADDLE_Y_OFFSET = 30;

    private static final int NBRICKS_PER_ROW = 10;
    private static final int NBRICK_ROWS = 10;
    private static final int BRICK_SEP = 4;
    private static final int BRICK_WIDTH = (APPLICATION_WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
    private static final int BRICK_HEIGHT = 8;
    private static final int BRICK_Y_OFFSET = 70;

    private static final int BALL_RADIUS = 10;
    private static final int NTURNS = 3;

    private RandomGenerator rgen = RandomGenerator.getInstance();
    private GRect paddle;
    private GOval ball;
    private double vx = 1;
    private double vy = 3;
    private GObject collider;
    private int brickCount;
    private int healthCount;
    private boolean ballIsStopped;

    public void run() {
        setupGame();
        playGame();
    }

    private void setupGame() {
        makeBricks(NBRICKS_PER_ROW, NBRICK_ROWS, BRICK_SEP);
        makePaddle();
        makeBall();
        checkWalls();
        waitForClick();
        addMouseListeners();
    }

    private void playGame() {
        while (true) {
            if (ballIsStopped) {
                waitForClick();
                initializeBall();
                ballIsStopped = !ballIsStopped;
            } else {
                moveBall();
                checkWalls();
                getCollidingObject();
                removeBricks();
                checkGameStatus();
                pause(20);
            }
        }
    }

    private void initializeBall() {
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) {
            vx = -vx;
        }
        vy = 3;
    }

    private void moveBall() {
        ball.move(vx, vy);
    }

    private void removeBricks() {
        if (collider != null && collider != paddle) {
            remove(collider);
            brickCount++;
            vy = -vy;
        }
    }

    private void checkGameStatus() {
        if (brickCount == NBRICKS_PER_ROW * NBRICK_ROWS) {
            displayGameResult("YOU WON", Color.GREEN);
        } else if (healthCount == NTURNS) {
            displayGameResult("YOU LOST", Color.RED);
        }
    }

    private void displayGameResult(String result, Color bgColor) {
        removeAll();
        GLabel text = new GLabel(result);
        setBackground(bgColor);
        text.setFont("Helvetica-50");
        double x = getWidth() / 2 - (text.getWidth() - text.getDescent()) / 2;
        double y = getHeight() / 2 + text.getHeight() / 2;
        add(text, x, y);
    }

    private void makePaddle() {
        paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        int x = getWidth() / 2 - PADDLE_WIDTH / 2;
        int y = getHeight() - PADDLE_Y_OFFSET;
        add(paddle, x, y);
    }

    public void mouseMoved(MouseEvent e) {
        int paddleX = (int) (e.getX() - PADDLE_WIDTH / 2);
        int paddleY = getHeight() - PADDLE_Y_OFFSET;
        paddle.setLocation(paddleX, paddleY);
    }

    private void makeBall() {
        ball = new GOval(2 * BALL_RADIUS, 2 * BALL_RADIUS);
        ball.setFilled(true);
        int x = getWidth() / 2 - BALL_RADIUS;
        int y = getHeight() / 2 - BALL_RADIUS;
        add(ball, x, y);
    }

    private void makeBricks(int rows, int cols, int separation) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                GRect brick = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                setBrickColor(brick, i);
                int x = j * (BRICK_WIDTH + separation);
                int y = BRICK_Y_OFFSET + i * (BRICK_HEIGHT + separation);
                add(brick, x, y);
            }
        }
    }

    private void setBrickColor(GRect brick, int row) {
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
        int colorIndex = row / 2;
        if (colorIndex < colors.length) {
            brick.setColor(colors[colorIndex]);
        }
    }

    private void getCollidingObject() {
        collider = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS * 2);
        if (collider != null) {
            vy = -vy;
        }
    }

    private void checkWalls() {
        double ballX = ball.getX();
        double ballY = ball.getY();

        if (ballX + 2 * BALL_RADIUS >= getWidth() || ballX < 0) {
            vx = -vx;
        }

        if (ballY < 0) {
            vy = -vy;
        }

        if (ballY + 2 * BALL_RADIUS >= getHeight()) {
            handleBallOutOfBounds();
        }
    }

    private void handleBallOutOfBounds() {
        remove(ball);
        healthCount++;
        add(ball, getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS);
        vx = 0;
        vy = 0;
        ballIsStopped = true;
    }
}
