package dronefyp1034528;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JPanelOutput {

    public static void outputImg() throws IOException {
        
        String fimage = ("C:\\Users\\Mark\\Desktop\\DroneFYP\\dronecomparisonimages\\layeredimages\\finaldifference.png");
        BufferedImage finalimg = ImageIO.read(new File (fimage));
        JPanel threeImages = new JPanel(new GridLayout(1, 1, 3, 3));
        threeImages.add(new JLabel(new ImageIcon(finalimg)));
        JOptionPane.showMessageDialog(null, threeImages, "Difference", JOptionPane.INFORMATION_MESSAGE);
        
    }   
}
