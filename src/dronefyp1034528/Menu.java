package dronefyp1034528;

import java.io.IOException;
import java.util.Scanner;

public final class Menu {
    public Menu() throws IOException {
        
        System.out.println("Marks first step to completing his FYP and degree!");
        System.out.println("Would you like to see all the desktop items using dir?");
        System.out.println("1 - Yes");
        System.out.println("2 - Quick drone flight instead");
        System.out.println("3 - Reconnect to Wifi@Brunel");
        System.out.println("4 - Compare 2 images");
        System.out.println("5 - Exit" + "\n");
        
        Scanner MenuChoice = new Scanner(System.in);
        int ChosenOption = MenuChoice.nextInt();
        MenuChoiceAction(ChosenOption);    
        System.out.println("\n");
    }

    public void MenuChoiceAction(int i) throws IOException {
                
        switch (i) {
            case 1:
            {
                ShowFileContents.showDir();
                DroneFYP1034528.main(null);
                break;
            }          
            case 2:
            {
                DroneWifi.main();
                StartWebflight.SWF();
                DroneFYP1034528.main(null);
                break;
            }
            case 3:
            {
                WifiBrunel.main();
                DroneFYP1034528.main(null);
                break;
            }
            case 4:
            {        
                compareImages.compare();                
                break;
            }
            case 5:
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