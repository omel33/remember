package topic1.day8;

import java.util.HashSet;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        Set<String> listName=new HashSet<>();
        listName.add("John");
        listName.add("Alice");
        listName.add("Bob");
        listName.add("John");
        listName.add("Alice");
        System.out.println(listName);

        System.out.println(listName.contains("dddds"));
        System.out.println(listName.contains("John"));

        listName.remove("John");
        System.out.println("After remove"+listName);

    }
}
