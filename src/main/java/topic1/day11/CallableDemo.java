package topic1.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService executor= Executors.newFixedThreadPool(4);

        List<Future<Long>> results=new ArrayList<>();

        for(int i=0;i<=10;i++){
            int n=i*1000;
            Future<Long> future=executor.submit(() -> {
                long sum=0;
                for(int j=1;j<=n;j++){
                    sum+=j;
                }
                System.out.println("Task for N=" + n + " done in " + Thread.currentThread().getName());
                return sum;
            });
            results.add(future);
        }
        for (Future<Long> future : results){
            System.out.println("Results"+ future.get());
        }
        executor.shutdown();
    }
}
