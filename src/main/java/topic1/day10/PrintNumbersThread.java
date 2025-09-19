package topic1.day10;

public class PrintNumbersThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("PrintNumbersThread: " + i);
        }
    }
}
