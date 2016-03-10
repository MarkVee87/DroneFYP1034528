package dronefyp1034528;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FindDifferences {
    
    public static BufferedImage getDifferenceImage(BufferedImage img1, BufferedImage img2) throws IOException {
        
    int width1 = img1.getWidth();
    int width2 = img2.getWidth();
    int height1 = img1.getHeight();
    int height2 = img2.getHeight();
    
    if ((width1 != width2) || (height1 != height2)) {
        System.err.println("Error: Images dimensions mismatch");
        System.exit(1);
    }

    // New BufferedImage to store the image showing differences between input images
    BufferedImage outImg = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_ARGB);   
    
    int diff;
    int result; // Stores output pixel
    
    for (int i = 0; i < height1; i++) {
        for (int j = 0; j < width1; j++) {
            
            // Registering the RGB values of each image at position [i][j] for comparison
            int rgb1 = img1.getRGB(j, i);
            int rgb2 = img2.getRGB(j, i);
            
            // Accessing the octet (byte) values for each images' RGB values
            int r1 = (rgb1 >> 16) & 0xff;
            int g1 = (rgb1 >> 8) & 0xff;
            int b1 = (rgb1) & 0xff;
            
            int r2 = (rgb2 >> 16) & 0xff;
            int g2 = (rgb2 >> 8) & 0xff;
            int b2 = (rgb2) & 0xff;
            
            // Checking the difference between the pixel r, g, and b values seperately
            // Then adding them together to get a total diff value per pixel
            diff = Math.abs(r1 - r2);
            diff += Math.abs(g1 - g2);
            diff += Math.abs(b1 - b2);
            
            // Now the diff value is divided by three to give a value between 0 and 255
            diff /= 3;            
                     
            // Tolerance variable
            int diffTolerance = 10;
            
            if (diff > diffTolerance){
                // make pixel yellow
                Color yellow = new Color(255, 255, 0);
                int yel = yellow.getRGB();
                result = yel;
                outImg.setRGB(j, i, result);
            }
            else{             
                // make pixel transparent
                Color trans = new Color(255, 0, 0, 0);
                int t = trans.getRGB();
                result = t;
                outImg.setRGB(j, i, result);                
            }            
        }
    }
    // Creating diff png and return return
    ImageIO.write(outImg, "PNG", new File("C:\\Users\\Mark\\Desktop\\diff.png"));
    return outImg;
    }    
    // TODO overlay the diff image with transparent background on top of the second image to show differences    
}
