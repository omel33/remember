package topic3.day14;

import java.util.List;

public class CopyUtils {
    private CopyUtils() {}

    public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (T item : src) {
            dst.add(item);
        }
    }
}
