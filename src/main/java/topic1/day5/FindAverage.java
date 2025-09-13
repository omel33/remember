package topic1.day5;

public class FindAverage {
    public static void main(String[] args) {
        int[] numbers={3,10,6,8,12};
        System.out.println("Min: " + findMin(numbers));
        System.out.println("Max: " + findMax(numbers));
        System.out.println("Average: " + findAverage(numbers));

    }
    public static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int findMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static double findAverage(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }
}
