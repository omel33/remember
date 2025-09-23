package topic3;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class MinUtils {
    private MinUtils() {}

    // Basic: requires a Comparator for T (accepts Comparator of supertype of T)
    public static <T> T min(List<? extends T> list, Comparator<? super T> cmp) {
        Objects.requireNonNull(list, "list");
        Objects.requireNonNull(cmp, "cmp");
        if (list.isEmpty()) throw new NoSuchElementException("empty list");
        T best = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T candidate = list.get(i);
            if (cmp.compare(candidate, best) < 0) {
                best = candidate;
            }
        }
        return best;
    }

    // Overload: works for elements that are Comparable (no comparator needed)
    public static <T extends Comparable<? super T>> T min(List<? extends T> list) {
        Objects.requireNonNull(list, "list");
        if (list.isEmpty()) throw new NoSuchElementException("empty list");
        T best = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T candidate = list.get(i);
            if (candidate.compareTo(best) < 0) {
                best = candidate;
            }
        }
        return best;
    }
}
