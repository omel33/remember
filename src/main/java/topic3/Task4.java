package topic3;

import topic3.day14.UserG;

import java.util.List;
import java.util.Map;
import java.util.Set;



import static java.util.stream.Collectors.*;

public class Task4 {
    public static void main(String[] args) {
        List<UserG> userGList=List.of(
                new UserG("Ann", "Kyiv", 20),
                new UserG("Jon", "Kharkiv", 13),
                new UserG("Dorian", "Lviv", 40),
                new UserG("Sem", "Odessa", 16),
                new UserG("Patrick", "Kyiv", 18),
                new UserG("Josh", "Kharkiv", 13),
                        new UserG("Dora", "Lviv", 40),
                                new UserG("SemLJekson", "Odessa", 16));
        Map<String, List<String>> userByCity=userGList.stream()
                .collect(groupingBy(UserG::getCity,mapping(UserG::getName,toList())));
        System.out.println(userByCity);
        Map<String, Set<Character>> initailsByCity=userGList.stream()
                .collect(groupingBy(UserG::getCity,mapping(u-> u.getName().trim().toUpperCase().charAt(0),toSet())));
        System.out.println(initailsByCity);

    }
}
