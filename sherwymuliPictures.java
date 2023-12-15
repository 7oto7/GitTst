import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class sherwymuliPictures {
    public static void main(String[] args) {
        try {
            // Load the images
            BufferedImage image1 = ImageIO.read(new File("path/to/first/image.jpg"));
            BufferedImage image2 = ImageIO.read(new File("path/to/second/image.jpg"));

            // Create a new BufferedImage with a width and height that can accommodate both images
            int combinedWidth = Math.max(image1.getWidth(), image2.getWidth());
            int combinedHeight = Math.max(image1.getHeight(), image2.getHeight());
            BufferedImage combinedImage = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_INT_ARGB);

            // Get the Graphics object from the combined image
            Graphics2D g = combinedImage.createGraphics();

            // Draw the first image at the top-left corner
            g.drawImage(image1, 0, 0, null);

            // Draw the second image next to the first one
            g.drawImage(image2, image1.getWidth(), 0, null);

            // Dispose of the Graphics object to free up resources
            g.dispose();

            // Save the merged image to a file
            File outputFile = new File("path/to/output/mergedImage.jpg");
            ImageIO.write(combinedImage, "jpg", outputFile);

            System.out.println("Images merged successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

