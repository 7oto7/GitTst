//import java.util.StringTokenizer;
//
//import acm.program.ConsoleProgram;
//
//public class tokenizer extends ConsoleProgram{
//	public void run(){
//		String text = "mari 2 3 4 5";
//		StringTokenizer tokenizer = new StringTokenizer(text);
//		
//		while(tokenizer.hasMoreTokens()){
//			String currToken = tokenizer.nextToken();
//			println(currToken);
//		}
//	}
//}
//////50,51,52


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class tokenizer extends JFrame implements KeyListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    private int paddleX = WIDTH / 2;
    private int ballX = WIDTH / 2;
    private int ballY = HEIGHT - 50;

    private int paddleSpeed = 5;
    private int ballSpeedX = 3;
    private int ballSpeedY = -3;

    public tokenizer() {
        setTitle("Breakout Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        Timer timer = new Timer(10, e -> gameLoop());
        timer.start();
    }

    private void gameLoop() {
        // Update paddle position based on user input
        paddleX += paddleSpeed;

        // Update ball position
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Check for collisions with walls
        if (ballX <= 0 || ballX >= WIDTH) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballY <= 0 || ballY >= HEIGHT) {
            ballSpeedY = -ballSpeedY;
        }

        // Check for collision with paddle
        if (ballY + 20 >= HEIGHT - 30 && ballX >= paddleX && ballX <= paddleX + 60) {
            ballSpeedY = -ballSpeedY;
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // Draw paddle
        g.fillRect(paddleX, HEIGHT - 30, 60, 10);

        // Draw ball
        g.fillOval(ballX, ballY, 20, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            tokenizer game = new tokenizer();
            game.setVisible(true);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddleSpeed = -5;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddleSpeed = 5;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        paddleSpeed = 0;
    }
}