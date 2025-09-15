package topic1.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Listick {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i <= 10; i++){

            numbers.add(random.nextInt(100)+1);
        }
        System.out.println(numbers);

        int min=numbers.get(0);
        int max=numbers.get(0);
        int sum=0;
        for(int n: numbers){
            if(n<min) min=n;
            if(n>max) max=n;
            sum+=n;
        }
        System.out.println("Min: "+min);
        System.out.println("Max: "+max);

        double avg=(double)sum/numbers.size();
        System.out.println("Avg: "+avg);

    }
}
