package dronefyp1034528;

import java.io.IOException;

// Could refactor this method and DroneWifi into one class with a Wifi Profile passed into it instead?
public class WifiBrunel {
    
    public static void main() throws IOException {        

        String wifi = "Wifi@Brunel";     
        Process changeNetwork = Runtime.getRuntime().exec("cmd /C netsh wlan connect " + wifi);

    }
    
}