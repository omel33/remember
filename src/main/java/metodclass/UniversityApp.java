package metodclass;

public class UniversityApp {
    public static void main(String[] args) {
        Student student1 = new Student("John Doe", 20, "S12345", 3.8);
        Student student2 = new Student("Jane Smith", 21, "S12346", 3.5);
        Student student3 = new Student("Mike Brown", 19, "S12347", 4.9);

        System.out.println("Student 1:");
        student1.displayInfo();
        System.out.println("Is student 1 eligible for scholarship? " + student1.isEligibleForScholarship());

        System.out.println("\nStudent 2:");
        student2.displayInfo();
        System.out.println("Is student 2 eligible for scholarship? " + student2.isEligibleForScholarship());

        System.out.println("\nStudent 3:");
        student3.displayInfo();
        System.out.println("Is student 3 eligible for scholarship? " + student3.isEligibleForScholarship());
        student1.setAge(160);
        student3.setGradePointAverage(10.0);

        Student student4 = new Student("Mike Brown", "S12347");
        student4.displayInfo();

    }
}
