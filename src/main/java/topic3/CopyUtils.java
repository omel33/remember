package topic3;

import java.util.List;
import java.util.Objects;

public final class CopyUtils {
    private CopyUtils() {}

    /**
     * Copies all items from src into dst, appending to dst.
     * dst uses ? super T because it CONSUMES T; src uses ? extends T because it PRODUCES T.
     */
    public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        Objects.requireNonNull(dst, "dst");
        Objects.requireNonNull(src, "src");
        for (int i = 0; i < src.size(); i++) {
            dst.add(src.get(i));
        }
    }

}
