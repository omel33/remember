package topic1.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
    public static void main(String[] args)
    {
        ExecutorService executor= Executors.newFixedThreadPool(4);
        List<Future<Long>> results=new ArrayList<>();

        for(int i=0;i<10;i++){
            int taskId=i;
            executor.submit(()->{
                System.out.println("Task"+taskId+" is running"+Thread.currentThread()
                        .getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        executor.shutdown();
    }
}
