package dronefyp1034528;

import java.io.IOException;

// Could refactor this method and DroneWifi into one class with a Wifi Profile passed into it instead?
public class ChangeWifi {
    
    public static void main(String wifi) throws IOException {        
    
        Process changeNetwork = Runtime.getRuntime().exec("cmd /C netsh wlan connect " + wifi);

    }
    
}