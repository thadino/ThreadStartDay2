/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock_philosophers;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author Dino
 */
public class DeadLockDetector implements Runnable {
 ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
  boolean doRun = true;
  
  public void stop() {
    this.doRun = false;
  }
  
  @Override
  public void run() {
    while (doRun) {
      long[] threadIds = tmxb.findDeadlockedThreads();
      
      if(threadIds != null)
      {
      
        for (long threadInfo1 : threadIds)
{
    System.out.println(threadInfo1);    //Prints the name of deadlocked thread
    stop();
}
    }
    else
    {
         System.out.println("no DeadLocks.");   
         stop();
            }
  }
  }}
