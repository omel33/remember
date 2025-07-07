package core;

public class StudentGrades {
    public static void main(String[] args) {
        String studentName="Hanna";
        int mathGrade=85;
        int physicsGrade=92;
        int chemistryGrade=88;

        int totalGrade=mathGrade+physicsGrade+chemistryGrade;
        double numberOfSubjects=3.0;
        double averageGrade= totalGrade/numberOfSubjects;

        System.out.println("Student Name: "+studentName);
        System.out.println("Math Grade: "+mathGrade);
        System.out.println("Physics Grade: "+physicsGrade);
        System.out.println("Chemistry Grade: "+chemistryGrade);
        System.out.println("Total Grade: "+totalGrade);
        System.out.println("Average Grade: "+averageGrade);

        boolean isExcellent=(averageGrade>=90.0);
        boolean needImprovement=(averageGrade<60.0);

        System.out.println("Is excellent: "+isExcellent);
        System.out.println("Need improvement: "+needImprovement);
    }
}
