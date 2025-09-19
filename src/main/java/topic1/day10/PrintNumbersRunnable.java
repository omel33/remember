package topic1.day10;

public class PrintNumbersRunnable implements Runnable{
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("PrintNumbersRunnable: " + i);
        }
    }
}
