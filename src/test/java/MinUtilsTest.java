import org.junit.jupiter.api.Test;
import topic3.day14.MinUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static topic3.day14.CopyUtils.copy;

public class MinUtilsTest {
    @Test
    void copy_shouldCopyAllFromSrcToEmptyDst() {
        List<Integer> src = List.of(1, 2, 3);
        List<Number> dst = new ArrayList<>();
        copy(dst, src); // викликаємо метод!
        assertEquals(List.of(1, 2, 3), dst);
    }

    @Test
    void copy_shouldNotModifyDstWhenSrcEmpty() {
        List<Integer> src = List.of();
        List<Integer> dst = new ArrayList<>(List.of(10));
        copy(dst, src);
        assertEquals(List.of(10), dst);
    }

    @Test
    void copy_shouldAppendToDestination() {
        List<String> src = List.of("a");
        List<Object> dst = new ArrayList<>(List.of("x", "y"));
        copy(dst, src);
        assertEquals(List.of("x", "y", "a"), dst);
    }

    @Test
    void copy_shouldAllowNumberSuperTypeForIntegerSrc_PECS() {
        List<Integer> src = List.of(1, 2);
        List<Number> dst = new ArrayList<>();
        copy(dst, src); // ? super T (Number), ? extends T (Integer)
        assertEquals(List.of(1, 2), dst);

}
