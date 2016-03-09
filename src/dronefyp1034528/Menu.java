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
        System.out.println("5 - Output old, new and difference images");
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
                DroneWifi.main();
                StartWebflight.SWF();
                DroneFYP1034528.main(null);
                break;
            }
            case 2:
            {
                WifiBrunel.main();
                DroneFYP1034528.main(null);
                break;
            }
            case 3:
            {        
                compareImages.compare();                
                break;
            }
            case 4:
            {
                // "4 - Compare 2 images (new image output)"
                break;
            }                  
            case 5:
            {
                // "5 - Output old, new and difference images"
                break;
            } 
            case 6:
            {
                System.exit(0);
                break;
            } 
            default:
            {
                System.out.println("Incorrect entry, please choose an option between 1 and 4");
                DroneFYP1034528.main(null);
            }
        }        
    }    
}