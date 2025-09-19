package topic1.day11;

public class Counter {
    int v=0;
    synchronized void inc()
    {
        v++;
    }
   synchronized int get()
    {
        return v;
    }
}
