package topic3.day14;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Task2 {
    public static void main(String[] args) {
        List<UserG> users = List.of(
                new UserG("Ann", "Kyiv", 20),
                new UserG("Jon", "Kharkiv", 13),
                new UserG("Dorian", "Lviv", 40),
                new UserG("Sem", "Odessa", 16),
                new UserG("Patrick", "Kyiv", 18),
                new UserG("Josh", "Kharkiv", 13),
                new UserG("Dora", "Lviv", 40));

        Optional<String> userName = Optional.ofNullable(users.stream()
                .filter(u -> u.getAge() == 13)
                .map(UserG::getName)
                .findAny().orElseThrow(() -> new NoSuchElementException("User not found")));
        System.out.println(userName);


    }
}
