package collection;

import java.util.*;

public class StudentController {
    public static void main(String[] args)
    {

        List <Student> studentList = new ArrayList<>();
        studentList.add(new Student("John", 1));
        studentList.add(new Student("Mike", 2));
        studentList.add(new Student("Mike", 3));
        studentList.add(new Student("Anne", 4));
        studentList.add(new Student("John", 1));

        System.out.println(studentList+ " Student list");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Set<Student> uniqueStudents = new HashSet<>(studentList);
        System.out.println(uniqueStudents);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Student student : uniqueStudents) {
            System.out.println(student);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Map<Student, Double> studentsGrades = new HashMap<>();
        studentsGrades.put(new Student("John", 1), 90.0);
        studentsGrades.put(new Student("Mike", 2), 85.0);
        studentsGrades.put(new Student("Mike", 3), 95.0);
        studentsGrades.put(new Student("Anne", 4), 80.0);
        studentsGrades.put(new Student("John", 1), 90.0);
        System.out.println(studentsGrades);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Map.Entry<Student, Double> entry : studentsGrades.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(studentsGrades.get(new Student("John", 1)));

    }
}
