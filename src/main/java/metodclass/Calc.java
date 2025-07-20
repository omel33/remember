package metodclass;

class Calc {

   public static double calculateRectangleArea(double length, double width) {
       return length * width;
   }
   public static double calculateCircleArea(double radius){
       return Math.PI * radius * radius;
   }
   public void printArea(String figureName, double area){
       System.out.println("The area of " + figureName + " is " + area);
   }
}
