package topic1.day11;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapTask {
    public static void main(String[] args) throws InterruptedException{
        ConcurrentHashMap<String,Integer> map=new ConcurrentHashMap<>();

        Thread writer=new Thread(()->{
            for (int i=0;i<=5;i++){
                map.put("user0"+i,i*10);
                System.out.println("Writer: " + "user0"+i+" = "+(i*10));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread reader=new Thread(()->{
            for (int i=0;i<=5;i++){
                Integer val=map.get("user0"+i);
                System.out.println("Reader read: user" + i + "=" + val);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        writer.start();
        reader.start();
        writer.join();
        reader.join();
        System.out.println("Map size: " + map);

    }
}
