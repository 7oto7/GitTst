
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class gpthelp extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int BALL_RADIUS = 10;

    public gpthelp() {
        setTitle("Circle Visualization");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void drawCircleWithPoints(Graphics g, int startAngle, int endAngle, int increment) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        Ellipse2D.Double circle = new Ellipse2D.Double(centerX - BALL_RADIUS, centerY - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
        g2d.draw(circle);

        g2d.setColor(Color.RED);

        for (int i = startAngle; i <= endAngle; i += increment) {
            double x = centerX + BALL_RADIUS * Math.sin(Math.toRadians(i));
            double y = centerY - BALL_RADIUS * Math.cos(Math.toRadians(i));
            g2d.drawLine(centerX, centerY, (int) x, (int) y);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCircleWithPoints(g, 226, 315, 5);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            gpthelp example = new gpthelp();
            example.setVisible(true);
        });
    }
}
