package topic3;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> notBlank=s -> !s.isBlank();
        System.out.println(notBlank.test(""));
        Predicate< String> isEmail=s -> s.contains("@");
        Predicate<String> validEmail=notBlank.and(isEmail);
        System.out.println(validEmail.test(""));

        Function<String, String> norm=s -> s.trim().toLowerCase();
        Function<String, String> collapseSpaces=s -> s.replaceAll("\\s+", " ");
        Function<String, String> toSnakeCase=s -> s.replaceAll("\\s", "_");
        Function<String, String> toSnakeCaseAndNormalize=norm.andThen(collapseSpaces).andThen(toSnakeCase);


    }
}
