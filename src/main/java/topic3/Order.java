package topic3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class Order {
    private final String id;
    private final String product;
    private final int quantity;
    private final double price;



}
