package dronefyp1034528;

import java.io.IOException;

public class ChangeWifi {
    
    public static void main(String wifi) throws IOException {        
    
        Process changeNetwork = Runtime.getRuntime().exec("cmd /C netsh wlan connect " + wifi);
    }    
}