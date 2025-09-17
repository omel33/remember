package topic1.day9;

public class Main2 {
    public static void main(String[] args)
    {
        int val = getElement(new int[]{1, 2, 3}, 4);
        System.out.println("getElement result = " + val);
        System.out.println("Operation finished");
        try {
            checkAge(17);
        } catch (InvalidAgeException e) {
            System.out.println("Denied: " + e.getMessage());;
        }

        try {
            System.out.println(div(10, 0));
        }catch (ArithmeticException  e){
            System.out.println("Division by zero");
        }
        try {
            System.out.println("10 / 2 = " + div(10, 2));
        } catch (ArithmeticException e) {
            System.out.println("Divide error: " + e.getMessage());
        }
    }
    public static int div(int a, int b)
    {
        if(b==0)  {
            throw new ArithmeticException("Division by zero");

        }
        return a / b;
    }
    public static void checkAge(int age) throws InvalidAgeException
    {
        if(age < 18)
        {
            throw new InvalidAgeException("Invalid age, age must be >=18");
        }else {
            System.out.println("Access granted");
        }
    }
    public static int getElement(int[] arr, int index)
    {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + index);
            return -1;
        } finally {
            System.out.println("Operation finished");
        }
    }
}
