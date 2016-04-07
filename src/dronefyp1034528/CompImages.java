package dronefyp1034528;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompImages {

    static int imgW1, imgW2; 
    static int imgH1, imgH2;
    static String imgLocation1, imgLocation2;
    static BufferedImage img1, img2;

    public static void main() throws IOException {

        imgLocation1 = "./droneimages\\testimages\\drone1.png";
        imgLocation2 = "./droneimages\\testimages\\drone2.png";

        img1 = ImageIO.read(new File(imgLocation1));
        img2 = ImageIO.read(new File(imgLocation2));

        if (dimCheck(img1, img2)){
            System.out.println("Now processing through image comparison function");
            checkDifferences(img1,img2);
        }
    }

    public static boolean dimCheck(BufferedImage before, BufferedImage after){

        imgW1 = before.getWidth();
        imgH1 = before.getHeight();
        imgW2 = after.getWidth();
        imgH2 = after.getHeight();

        if((imgW1 != imgW2) || (imgH1 != imgH2)){
            System.out.println("Error: Images are different dimensiosns");
            System.exit(1);
        }
        System.out.println("Image dimensions are equal");

        return(true);
    }

    public static void checkDifferences(BufferedImage img1, BufferedImage img2) throws IOException {

        BufferedImage outImg = new BufferedImage(imgW1, imgH1, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0;i < imgH1; i++){
            for (int j = 0; j < imgW1; j++){
                int rgb1 = img1.getRGB(j,i);
                int rgb2 = img2.getRGB(j,i);

                int red1 = (rgb1 >> 16) & 0xff;
                int green1 = (rgb1 >> 8) & 0xff;
                int blue1 = (rgb1) & 0xff;

                int red2 = (rgb2 >> 16) & 0xff;
                int green2 = (rgb2 >> 8) & 0xff;
                int blue2 = (rgb2) & 0xff;

                int diff = Math.abs(red1 - red2);
                diff += Math.abs(green1 - green2);
                diff += Math.abs(blue1 - blue2);
                
                diff /= 3;

                outImg.setRGB(j,i,tolerance(diff));
            }
        }
        System.out.print("Image comparison complete, now outputting to file location: ");
        printImage(outImg);
    }

    public static int tolerance(int difference){

        int OrangeDiff = 25;
        int YellowDiff = 20;
        int GreenDiff = 15;

        Color red = Color.red;
        Color orange = Color.orange;
        Color yellow = Color.yellow;
        Color green = Color.green;
        Color trans = new Color(255, 0, 0, 0);

        if(difference > OrangeDiff){
            difference = red.getRGB();
        }
        else if (difference <= OrangeDiff && difference > YellowDiff){
            difference = orange.getRGB();
        }
        else if(difference <= YellowDiff && difference > GreenDiff){
            difference = yellow.getRGB();
        }
        else if(difference <= GreenDiff && difference > 5){
            difference = green.getRGB();
        }
        else{
            difference = trans.getRGB();
        }

        return difference;
    }

    public static BufferedImage printImage(BufferedImage bi) throws IOException {
        String saveLocation = "./dronecomparisonimages\\masks\\diffheatmap.png";
        ImageIO.write(bi, "PNG", new File(saveLocation));
        System.out.println(saveLocation);
        return bi;
    }
}