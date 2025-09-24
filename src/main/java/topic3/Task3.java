package topic3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Task3 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("o1","Book",    2, 12.50),
                new Order("o2","Pen",     5,  1.20),
                new Order("o3","Book",    1, 12.00),
                new Order("o4","Notebook",3,  3.40),
                new Order("o5","Pen",    10,  1.10),
                new Order("o6","Backpack",1, 39.99),
                new Order("o7","Book",    4, 11.75),
                new Order("o8","Notebook",2,  3.60)
        );
        double totalRevenue = orders.stream()
                .mapToDouble(o -> o.getPrice() * o.getQuantity())
                .sum();
        System.out.println(totalRevenue);

        Map<String, Integer> qtyByProduct=orders.stream()
                .collect(groupingBy(Order::getProduct, summingInt(Order::getQuantity)));
        System.out.println(qtyByProduct);
        Map<String, Double> revenueByProduct=orders.stream()
                .collect(groupingBy(Order::getProduct, summingDouble(o -> o.getPrice() * o.getQuantity())));
                System.out.println(revenueByProduct);

        System.out.println(qtyByProduct.entrySet().stream().sorted().limit(3));
        Map<String, Long> ordersCountByProduct=orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.counting()));
        System.out.println(ordersCountByProduct);
    }
}
