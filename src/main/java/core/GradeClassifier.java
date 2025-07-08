package core;

public class GradeClassifier {
    public static void main(String[] args) {
        int score=60;

        if(score>=90 && score<=100){
            System.out.println("A");
        }else if (score>=80&& score<90){
                System.out.println("B");
            }else if(score>=70&& score<80){
            System.out.println("C");
            }else if(score>=60&& score<70){
            System.out.println("D");
            }else{
            System.out.println("F");
        }
        }
    }

