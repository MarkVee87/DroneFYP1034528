package dronefyp1034528;

import java.io.IOException;

public class DroneWifi {
   
        public static void main() throws IOException {        

        String wifi = "ardrone2_062272";
        Process changeNetwork;        
        changeNetwork = Runtime.getRuntime().exec("cmd /C netsh wlan connect " + wifi);

    }
    
}
