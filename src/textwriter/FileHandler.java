/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textwriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dino
 */
public class FileHandler extends Thread {

    
    FileHandler(int si) {
 
    }
    
    public String SaveToDocument(List<String> lines) throws IOException
    {      
PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
    for(String txt : lines)
    {
      writer.println(txt);
    }   
 writer.close();   
 
   return "Saved!";
    }
    

    @Override
    public void run() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
}
