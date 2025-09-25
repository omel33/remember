package topic3;

import topic3.day14.UserG;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Task2 {
    public static void main(String[] args) {
        UserG user = new UserG("Ann", "Kyiv", 20);
        UserG user2 = new UserG("Jon", "Kharkiv", 13);
        UserG user3 = new UserG("Dorian", "Lviv", 40);
        UserG user4 = new UserG("Sem", "Odessa", 16);
        List<UserG> users = List.of(user, user2, user3, user4);
        Map<String, List<UserG>> usersByCity = users.stream().collect(groupingBy(UserG::getCity));
        System.out.println(usersByCity);
        Map<String, Double> averageAgeByCity = users.stream().
                collect((Collectors.groupingBy(UserG::getCity,Collectors.averagingDouble(UserG::getAge))));
        System.out.println(averageAgeByCity);
        Map<Boolean, List<UserG>> adultUsers = users.stream()
                .collect(Collectors.partitioningBy(u -> u.getAge() >= 18));
        System.out.println(adultUsers);

    }
}
