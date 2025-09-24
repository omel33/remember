package topic3;

import java.util.List;

public class Streem {
    public static void main(String[] args) {
        List<String> name = List.of("Ann", "Abigel", "Jonn", "Dorian", "Sem","Patrick");
        name.stream()
                .map(String::toUpperCase)
                .filter(s -> s.length()>3)
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
//        //*Є список List<Integer> numbers.
//
//        Знайди суму всіх парних чисел.
//
//                Знайди максимум і мінімум.
//
//                Зроби список квадратів без дублікатів...00//*

        List< Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        numbers.stream()
                .filter(n-> n%2==0)
                .map(n-> n+n)
                .min(Integer::compareTo)
                .ifPresent(System.out::println);
        numbers.stream()
                .map(n-> n+n)
                .distinct()
                .forEach(System.out::println);
        numbers.stream()
                .map(n-> n+n)
                .distinct()
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

    }
}
