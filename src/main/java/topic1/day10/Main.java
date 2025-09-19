package topic1.day10;

public class Main {
    public static void main(String[] args) {
        PrintNumbersThread t1=new PrintNumbersThread();
        Thread t2=new Thread(new PrintNumbersRunnable());
        t1.start();
        t2.start();

    }
}
