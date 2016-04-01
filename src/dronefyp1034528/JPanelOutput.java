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
        
        String fimage = ("./dronecomparisonimages\\layeredimages\\finaldifference.png");
        BufferedImage finalimg = ImageIO.read(new File (fimage));
        JPanel diffImage = new JPanel(new GridLayout(1, 1, 3, 3));
        diffImage.add(new JLabel(new ImageIcon(finalimg)));
        JOptionPane.showMessageDialog(null, diffImage, "Difference Overlay", JOptionPane.INFORMATION_MESSAGE);
        
    }   
}
