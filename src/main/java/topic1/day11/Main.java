package topic1.day11;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Counter c=new Counter();
        int threads=10;
        int perThread=1000;
        Thread[] ts=new Thread[threads];
         for(int t=0;t<threads;t++){
             ts[t]=new Thread(()-> {
                 for(int i=0;i<perThread;i++)c.inc();
                 }
                 , "Thread"+t);
             ts[t].start();
         }
        for (Thread t:ts)t.join();
        int expected=threads*perThread;
        System.out.println(" Actual: "+c.get());
        System.out.println(" Expected: "+expected);
    }
}
