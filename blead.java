import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class blead {

    // Assuming N_DICE is the number of dice to be displayed
    private static final int N_DICE = 5;

    // Assuming each die image has a fixed width and height
    private static final int DIE_WIDTH = 50;
    private static final int DIE_HEIGHT = 50;

    // Assuming die images are named "die1.png", "die2.png", ..., "die6.png"
    private static final String DIE_IMAGE_PREFIX = "die";

    public static void main(String[] args) {
        // Example usage:
        int[] diceValues = {1, 2, 3, 4, 5};
        displayDice(diceValues);
    }

    public static void displayDice(int[] dice) {
        // Check if the length of the array is equal to the number of dice
        if (dice.length != N_DICE) {
            throw new IllegalArgumentException("Invalid number of dice values provided");
        }

        // Check if each value in the array is a valid die roll between 1 and 6
        for (int value : dice) {
            if (value < 1 || value > 6) {
                throw new IllegalArgumentException("Invalid die roll value: " + value);
            }
        }

        // Assuming you are using a JFrame for display
        JFrame frame = new JFrame("Dice Display");
        frame.setSize(N_DICE * DIE_WIDTH, DIE_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel to hold the dice images
        JPanel dicePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawDice(g, dice);
            }
        };

        frame.add(dicePanel);
        frame.setVisible(true);
    }

    private static void drawDice(Graphics g, int[] dice) {
        ImageObserver observer = null; // You might need to set an observer

        for (int i = 0; i < dice.length; i++) {
            // Assuming die images are named "die1.png", "die2.png", ..., "die6.png"
            String imageName = DIE_IMAGE_PREFIX + dice[i] + ".png";

            // Load the image (you need to have the images in your project)
            ImageIcon icon = new ImageIcon(imageName);
            Image image = icon.getImage();

            // Draw the image at the specified location
            g.drawImage(image, i * DIE_WIDTH, 0, DIE_WIDTH, DIE_HEIGHT, observer);
        }
    }
}