package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * @author Lars Mortensen
 */
class DeadLockDetector implements Runnable {

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