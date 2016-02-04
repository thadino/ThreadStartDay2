package deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Tester {
    
    Boolean run = true;
  public static void main(String[] args) {
      

    try {
      ResourceContainer resources = new ResourceContainer();
      ResourceUser1 t1 = new ResourceUser1(resources);
      ResourceUser2 t2 = new ResourceUser2(resources);
      t1.start();
      t2.start();
      
      DeadLockDetector dld = new DeadLockDetector();
      Thread lockthread = new Thread(dld);
      
      lockthread.start();
      lockthread.interrupt();
    //  new Thread(new DeadLockDetector()).start();
      
     
      t1.join();
      t2.join();
      t1.interrupt();
      t2.interrupt();
 
      System.out.println("Done");
      System.out.println("Words produced: "+resources.getResourceWords().size());
      System.out.println("Numbers produced: "+resources.getResourceNumbers().size());
      
    } catch (InterruptedException ex) {
      Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  }
