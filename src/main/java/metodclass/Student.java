package metodclass;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private double gradePointAverage;

    public Student(String name, int age, String studentId, double gradePointAverage) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.gradePointAverage = gradePointAverage;
    }
    public Student(String name, String studentId) {
        this(name, 18, studentId, 0.0);
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getStudentId() {
        return studentId;
    }
    public double getGradePointAverage() {
        return gradePointAverage;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("Invalid age");
            return;
        }
        this.age = age;
    }
    public void setGradePointAverage(double gradePointAverage) {
        if (gradePointAverage < 0.0 || gradePointAverage > 5.0) {
            System.out.println("Invalid grade point average");
            return;
        }
        this.gradePointAverage = gradePointAverage;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade Point Average: " + gradePointAverage);
    }
    public boolean isEligibleForScholarship() {
        return gradePointAverage >= 4.5;
    }
}
