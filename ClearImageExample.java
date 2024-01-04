import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import javax.imageio.ImageIO;

public class ClearImageExample {
    public static void main(String[] args) {
        try {
            // Load the image
            BufferedImage image = ImageIO.read(new File("C:/Users/User/Pictures/Screenshot 2023-12-15 204546.png"));

            // Apply a sharpening filter
            float[] sharpenMatrix = {0, -1, 0, -1, 5, -1, 0, -1, 0};
            Kernel kernel = new Kernel(3, 3, sharpenMatrix);
            ConvolveOp op = new ConvolveOp(kernel);
            BufferedImage sharpenedImage = op.filter(image, null);

            // Save the processed image
            File outputFile = new File("C:/Users/User/Pictures/ClearedImage.png");
            ImageIO.write(sharpenedImage, "png", outputFile);

            System.out.println("Image processing completed. Processed image saved to: " + outputFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
