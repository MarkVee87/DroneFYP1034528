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

    BufferedImage outImg = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_RGB);   
    
    int diff, result;
    
    for (int i = 0; i < height1; i++) {
        for (int j = 0; j < width1; j++) {
            
            int rgb1 = img1.getRGB(j, i);
            int rgb2 = img2.getRGB(j, i);
            
            int r1 = (rgb1 >> 16) & 0xff;
            int g1 = (rgb1 >> 8) & 0xff;
            int b1 = (rgb1) & 0xff;
            
            int r2 = (rgb2 >> 16) & 0xff;
            int g2 = (rgb2 >> 8) & 0xff;
            int b2 = (rgb2) & 0xff;
            
            diff = Math.abs(r1 - r2);
            diff += Math.abs(g1 - g2);
            diff += Math.abs(b1 - b2);
            
            diff /= 3;            
                     
            int diffTolOrange = 25;
            int diffTolYellow = 20;
            int diffTolGreen = 15; 
            
            Color Red = new Color(255,0,0);
            Color orange = new Color(255, 165, 0);
            Color yellow = new Color(255, 255, 0);  
            Color green = new Color(0, 255, 0);
            Color trans = new Color(0, 0, 0, 0);
            
            if (diff > diffTolOrange){
                // make pixel red
                result = Red.getRGB();
                outImg.setRGB(j, i, result);
            }
            else if (diff <= diffTolOrange && diff > diffTolYellow){
                // make pixel orange
                result = orange.getRGB();
                outImg.setRGB(j, i, result);
            }
            else if (diff <= diffTolYellow && diff > diffTolGreen){
                // make pixel yellow
                result = yellow.getRGB();
                outImg.setRGB(j, i, result);
            }
            else if (diff <= diffTolGreen && diff > 5){
                // make pixel green
                result = green.getRGB();
                outImg.setRGB(j, i, result);
            }
            else{             
                // make pixel transparent
                result = trans.getRGB();
                outImg.setRGB(j, i, result);                
            }          
        }
    }
    
    // Creating diff png and return return
    ImageIO.write(outImg, "PNG", new File("./dronecomparisonimages\\masks\\diffheatmap.png"));
    return outImg;
    }     
}
