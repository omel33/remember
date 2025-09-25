package topic3.day14;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> opt1 = Optional.ofNullable(" Java ");
        String result1  = opt1
                .map(String::trim)
                .map(String::toUpperCase)
                .orElse("EMPTY");
        System.out.println(result1);
        Optional<String> opt2 = Optional.ofNullable(null);
        String result2  = opt2.
                map(String::trim)
                .orElse("EMPTY");
        System.out.println(result2);
        Optional<String> opt3 = Optional.ofNullable("");
        String result3  = opt3.
                map(String::trim)
                .orElse("EMPTY");
                System.out.println(result3);


    }
}
