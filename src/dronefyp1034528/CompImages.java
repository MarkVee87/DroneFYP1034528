package dronefyp1034528;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CompImages {
    
    static long startTime = System.currentTimeMillis();
    
    public static void CI() throws IOException{ 
    
    String image1 = "./droneimages\\testimages\\dronecomplex1.png";
    String image2 = "./droneimages\\testimages\\dronecomplex2 _3px shift.png";
    
    BufferedImage img1 = ImageIO.read(new File(image1)), img2 = ImageIO.read(new File(image2));
    
    final long endTime = System.currentTimeMillis();
    System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }   
}
