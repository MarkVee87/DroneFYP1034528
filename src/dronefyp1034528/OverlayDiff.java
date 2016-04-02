package dronefyp1034528;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OverlayDiff {
    
    public static void OverlayOutput(){
        
        try{
            String after = ("./droneimages\\testimages\\drone2.png");
            String difference = ("./dronecomparisonimages\\masks\\diffheatmap.png");
            BufferedImage aft = ImageIO.read(new File (after));
            BufferedImage diff = ImageIO.read(new File (difference));
            
            int w = aft.getWidth();
            int h = aft.getHeight();

            final BufferedImage finalImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = finalImage.createGraphics();
            
            g.drawImage(aft, 0, 0, null);
            g.drawImage(diff, 0, 0, null);

            File out = new File("./dronecomparisonimages\\layeredimages\\finaldifference.png");
            ImageIO.write(finalImage, "PNG", out);
            g.dispose();
        }
        catch (IOException e){            
        }                    
    } 
}