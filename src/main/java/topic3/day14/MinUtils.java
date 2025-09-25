package topic3.day14;

import java.util.List;
import java.util.NoSuchElementException;

public class MinUtils {
    private MinUtils() {}

    public static <T extends Comparable<? super T>> T min(List<? extends T> list) {
        if (list.isEmpty()) throw new NoSuchElementException("empty list");
        T best = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(best) < 0) {
                best = list.get(i);
            }
        }
        return best;
    }
}
