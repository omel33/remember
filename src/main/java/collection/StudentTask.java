package collection;

import java.util.*;

public class StudentTask {
    public static void main(String[] args) {
        int year = 2023;
        System.out.println("Student Task for " + year);
        List<String> taskList = new ArrayList<>();
        taskList.add("Create a presentation");
        taskList.add("Planing meeting");
        taskList.add("Writing report");
        taskList.add("Create a presentation");
        taskList.add("Checking emails");
        System.out.println("-----------ArrayList--------------");
        System.out.println(taskList);
        taskList.remove(1);
        Set<String> uniqueTasks = new HashSet<>(taskList);
        System.out.println("-----------HashSet--------------");
        System.out.println(uniqueTasks);
        System.out.println("-----------HashSet for each--------------");
        for (String task : uniqueTasks) {
            System.out.println(task);
        }
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "John");
        students.put(2, "Jane");
        students.put(3, "Bob");
        System.out.println("-----------HashMap--------------");
        System.out.println(students);
        System.out.println("-----------HashMap for each--------------");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

}
