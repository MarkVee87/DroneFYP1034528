package dronefyp1034528;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OverlayDiff {
    
    public static void OverlayOutput(){
        
        try{
            // takes "after" image as well as the image with transparent bg (diff) to output a visual of change
            // String before = ("C:\\Users\\Mark\\Desktop\\drone1.png");
            String after = ("C:\\Users\\Mark\\Desktop\\drone2.png");
            String difference = ("C:\\Users\\Mark\\Desktop\\diff10trans.png");
            // BufferedImage bef = ImageIO.read(new File (before));
            BufferedImage aft = ImageIO.read(new File (after));
            BufferedImage diff = ImageIO.read(new File (difference));
            
            int w = aft.getWidth();
            int h = aft.getHeight();

            // Composes final images as a combination of the two images above
            // Layers them on top of each other
            final BufferedImage finalImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = finalImage.createGraphics();
            g.drawImage(aft, 0, 0, null);
            g.drawImage(diff, 0, 0, null);            

            File out = new File("C:\\Users\\Mark\\Desktop\\difference.png");
            ImageIO.write(finalImage, "PNG", out);
            g.dispose();
        }
        catch (IOException e){
            
        }        
            
    } 
}