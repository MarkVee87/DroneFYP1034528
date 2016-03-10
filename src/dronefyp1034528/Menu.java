package dronefyp1034528;

import java.io.IOException;
import java.util.Scanner;

public final class Menu {
    public Menu() throws IOException {
        
        System.out.println("Mark's Drone Flight and Image Comparison Application");

        System.out.println("1 - Connect to drone and run WebFlight");
        System.out.println("2 - Reconnect to Wifi@Brunel");
        System.out.println("3 - Compare 2 images (console output)");
        System.out.println("4 - Compare 2 images (new image output)");
        System.out.println("5 - Output JPanel overlaying diff and after image");
        System.out.println("6 - Exit" + "\n");
        
        Scanner MenuChoice = new Scanner(System.in);
        int ChosenOption = MenuChoice.nextInt();
        MenuChoiceAction(ChosenOption);    
        System.out.println("\n");
    }

    public void MenuChoiceAction(int i) throws IOException {
                
        switch (i) {          
            case 1:
            {
                ChangeWifi.main("ardrone2_062272");
                StartWebflight.SWF();
                DroneFYP1034528.main(null);
                break;
            }
            case 2:
            {
                ChangeWifi.main("Wifi@Brunel");
                DroneFYP1034528.main(null);
                break;
            }
            case 3:
            {        
                CompImagesSimple.compare();                
                break;
            }
            case 4:
            {
                CompImages.CI();
                DroneFYP1034528.main(null);
                break;
            }                  
            case 5:
            {
                OverlayDiff.OverlayOutput();
                // TODO upgrade JPanelOutput to just take any image URI for output
                JPanelOutput.outputImg();
                DroneFYP1034528.main(null);
                break;
            } 
            case 6:
            {
                System.exit(0);
                break;
            } 
            default:
            {
                System.out.println("Incorrect entry, please choose an option between 1 and 6");
                DroneFYP1034528.main(null);
            }
        }        
    }    
}