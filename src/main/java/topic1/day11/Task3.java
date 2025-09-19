package topic1.day11;

import java.time.Duration;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        Thread ta=new Thread(()-> {for (int i=0;i<5;i++){
            System.out.println("A");
            try {
                Thread.sleep(Duration.ofMillis(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}, "PrintA");
        Thread tb=new Thread(()-> {for (int i=0;i<5;i++){
            System.out.println("B");
            try {
                Thread.sleep(Duration.ofMillis(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}, "PrintB");
        ta.start();
        tb.start();
        ta.join();
        tb.join();
        System.out.println("Done");
    }
}
