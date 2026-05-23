import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide exactly 1 argument: the absolute path to the image.");
            return;
        }

        try {
            File imgFile = new File(args[0]);
            BufferedImage img = ImageIO.read(imgFile);

            if (img != null) {
                rowCounter(img);
            } else {
                System.out.println("Error: Could not read the image file.");
            }
        }
        catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    private static void rowCounter(BufferedImage img) {
        int width = img.getWidth();
        int midY = img.getHeight() / 2;
        int lineCount = 0;
        boolean inLine = false;

        for (int x = 0; x < width; x++) {
            Color pixel = new Color(img.getRGB(x, midY));
            boolean isBlack = checkColor(pixel);
            if (isBlack && !inLine) {
                lineCount++;
                inLine = true;
            } else if (!isBlack) {
                inLine = false;
            }
        }

        System.out.println("Number of vertical lines: " + lineCount);
    }

    private static boolean checkColor(Color pixel) {
        return pixel.getRed() < 128 && pixel.getGreen() < 128 && pixel.getBlue() < 128;
    }
}
