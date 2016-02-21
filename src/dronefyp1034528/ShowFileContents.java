/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronefyp1034528;

import java.io.IOException;
import java.io.InputStream;

public class ShowFileContents {
    public static void showDir(){
        // cmd prompt command to view all files in a given directory
        // "/c" terminates the command window after usage
        // add " /s" after dir to view all sub folders as well
        // could be useful to show options of semi-autonomous movements as .js files in a dir?
        // also for chooseing images to compare for differences?
        // TODO enable this command to only return a list of image files (*.jpg or similar)
        final String command = ("cmd /c dir /b /a-d");
        final String location = ("C:\\Users\\Mark\\Desktop\\DroneFYP1034528\\droneimages"); // shows contents of pictures dir
        
        System.out.println("*** Contents of " + location + ": ***");       
        
        try{
            final Process p = Runtime.getRuntime().exec(command + " " + location);
            final InputStream in = p.getInputStream();
            int ch;
            // while there are still characters being read, output to console
            while((ch = in.read()) != -1){
                System.out.print((char)ch);
            }            
            System.out.println("\n*** All contents outputted above ***\n"); 
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
    } 
    
}
