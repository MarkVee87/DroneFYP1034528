package dronefyp1034528;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CompImagesSimple {

    static long startTime = System.currentTimeMillis();
    static double goodPix = 0;
    static double badPix = 0;

    public static void compare() {
        String sImage1 = "C:\\Users\\Mark\\Desktop\\vsmall1.png";
        String sImage2 = "C:\\Users\\Mark\\Desktop\\vsmall2.png";

        BufferedImage testImage1, testImage2;

        try {
            // Getting files and their dimensions
            testImage1 = ImageIO.read(new File(sImage1));
            testImage2 = ImageIO.read((new File(sImage2)));
            int tImage1W = testImage1.getWidth();
            int tImage1H = testImage1.getHeight();
            int tImage2W = testImage2.getWidth();
            int tImage2H = testImage2.getHeight();

            // create integer array to hold pixel values
            int[][] pixels = new int[tImage1H * tImage1W][3];
            int [] rgb;

            // check images are the same size
            if ((tImage1W != tImage2W) || (tImage1H != tImage2H)){
                System.out.println("Images are not of the same dimensions so cannot compare...");
            }
            else {
                System.out.println("Images are of the same dimensions, comparing now...");

                int counter = 0;
                for (int i = 0; i < tImage1H; i++){
                    for (int j = 0; j < tImage1W; j++){
                        rgb = CompareAndOutputPixelValues(testImage1, testImage2, i, j);
                        for (int k = 0; k < rgb.length; k++){
                            pixels[counter][k] = rgb[k];
                        }
                        counter++;
                    }
                }

                double totalPixels = badPix + goodPix;
                double similarity = (goodPix/totalPixels)*100;
                System.out.println("\nTotal Pixels = " + totalPixels);
                System.out.println("Matching Pixels = " + goodPix);
                System.out.println("Non-matching Pixels = " + badPix);
                System.out.println("Image similarity = " + similarity + "%");

                final long endTime = System.currentTimeMillis();
                System.out.println("Total execution time: " + (endTime - startTime) + "ms");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] CompareAndOutputPixelValues(BufferedImage tImage1, BufferedImage tImage2, int x, int y) {

        // Getting a pixel from the image according to for loop above
        int argb1 = tImage1.getRGB(y,x);
        int argb2 = tImage2.getRGB(y,x);

        // TODO add tolerance by giving the below if statement a threshold of +/- 10 when comparing RGB? Too fine-tuned at the minute
        if (argb1 != argb2){
            System.out.println("\nrow: " + (x+1) + " " + "column: " + (y+1) + " ARE NOT EQUAL");
            counter(false);
        }
        else {
            System.out.println("\nrow: " +(x+1) + " " + "column: " + (y+1) + " are equal");
            counter(true);
        }
        
        // Byte array to store RGB value of each pixel
        int rgb[] = new int[]{
                (argb1 >> 16) & 0xff, // third octet = red
                (argb1 >> 8) & 0xff, // second octet = green
                (argb1) & 0xff // first octet = blue
        };

        // Outputting the values to the user
        System.out.println("rgb for pixel = " + rgb[0] + " " + rgb[1] + " " + rgb[2]);
        return rgb;
    }

    public static void counter(Boolean x){
        if (x == true){
            goodPix++;
        }
        else {
            badPix++;
        }
    }
}
