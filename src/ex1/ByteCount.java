/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Dino
 */



public class ByteCount extends Thread {


        String url;
    long sum = 0;


    public ByteCount(String Url)
    {
        this.url = Url;
    }
    
    /**
     *
     */
    @Override
    public void run()
    {
        byte[] bytes = getBytesFromUrl(url);
        for(byte b : bytes)
        {
            sum += b;
        }
    }
    
protected byte[] getBytesFromUrl(String url) {
 ByteArrayOutputStream bis = new ByteArrayOutputStream();
 try {
 InputStream is = new URL(url).openStream();
 byte[] bytebuff = new byte[4096];
 int read;
 while ((read = is.read(bytebuff)) > 0) {
 bis.write(bytebuff, 0, read);
 }
 } catch (IOException ex) {System.out.println(ex);}
  return bis.toByteArray();
 }

    
}

