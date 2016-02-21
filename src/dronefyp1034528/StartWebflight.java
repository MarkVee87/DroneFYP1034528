package dronefyp1034528;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartWebflight {
    
    static Process p = null;
    
    public static void SWF() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "start", "node", "C:\\droneFYP\\DroneFYP1034528\\app.js");
        pb.redirectErrorStream(true);
        
        try {
            p = pb.start();
        }
        catch (IOException ex) {
            Logger.getLogger(StartWebflight.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Webflight started on localhost:3000");
    }
        
    public void endProcess(){
        System.out.println("finished ");
        p.destroy();        
    }  
}