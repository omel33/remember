package core;

public class ArrayGradesProcessor {
    public static void main(String[] args) {
        int[]grades = {82, 92, 78, 65, 95};

        for(int i=0;i< grades.length;i++) {
            System.out.println("Grade " + (i+1) + ": " + grades[i]);
        }
        System.out.println("--------------------------------------------------");
        int sum=0;
        for(int grade:grades) {
            System.out.println("Grade: " + grade);
            sum+=grade;
        }
        System.out.println("--------------------------------------------------");
        double average =(double) sum/grades.length;
        System.out.println("Average: " + average);

    }
}
