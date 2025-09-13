package topic1.day5;

public class Max {
    public static void main(String[] args) {
        System.out.println(max(5, 10));
        System.out.println(isPrime(7));
    }

    private static boolean isPrime(int n) {
        if(n<2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }



}
