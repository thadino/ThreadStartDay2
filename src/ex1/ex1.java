/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author Dino
 */
public class ex1 {

     
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        
        long start = System.nanoTime();
        
        
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
        
        
        
        
        String URL = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png";
        String URL2 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png";
        String URL3 = "https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png";
        
       //  String URI = "" + getBytesFromUrl(URL);
       
        ByteCount count = new ByteCount(URL);
        ByteCount count2 = new ByteCount(URL2);
        ByteCount count3 = new ByteCount(URL3);
        count.start();
        count2.start();
        count3.start();
        System.out.println(Thread.activeCount()); // how many active Threads.... (4 because this class is also a active thread).
        count.join();
        count2.join();
        count3.join();
        
        
        long finalsum = count.sum + count2.sum + count3.sum;

        
        System.out.println(count.sum); // Assignment A.
        System.out.println(finalsum); // Assignment B.
        
        
        
        
       long end = System.nanoTime();
        System.out.println("Time Sequental: "+(end-start));

  
        // test 1 with count.start(); 828632945
        // test 1 with count.run(); 1021419681
        // test 1 difference from .start() to .run() is 192786736 which is roughly 18.88% difference on 8 processors. Meaning the time saving is quite large.
        
        
          
          
        
        
        
    }
    


    
}
