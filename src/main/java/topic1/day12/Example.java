package topic1.day12;

public class Example {
    @Run
    public void test1() {
        System.out.println("Test1 is running...");
    }

    public void test2() {
        System.out.println("Test2 is NOT annotated");
    }

    @Run
    public void test3() {
        System.out.println("Test3 is running...");
    }
}
