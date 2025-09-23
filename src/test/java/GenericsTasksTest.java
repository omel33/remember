import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import topic3.Box;
import topic3.CopyUtils;
import topic3.MinUtils;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GenericsTasksTest {
    @Test
    @DisplayName("Box: get/set/of/equals/hashCode")
    void boxBasics() {
        Box<Integer> bi = new Box<>(42);
        assertEquals(42, bi.get());
        bi.set(7);
        assertEquals(7, bi.get());

        Box<String> bs = Box.of("hi");
        assertEquals("hi", bs.get());

        assertEquals(new Box<>(7), bi);
        assertEquals(new Box<>(7).hashCode(), bi.hashCode());
        assertTrue(bs.toString().contains("hi"));
    }

    @Test
    @DisplayName("Min: with comparator")
    void minWithComparator() {
        List<Number> nums = Arrays.asList(10, 3.5, 7L, 2);
        // comparator on Number that compares by doubleValue
        Number m = MinUtils.min(nums, Comparator.comparingDouble(Number::doubleValue));
        assertEquals(2, m);
    }

    @Test
    @DisplayName("Min: comparable overload")
    void minComparable() {
        List<String> names = Arrays.asList("Zoe", "Ann", "Mike");
        String m = MinUtils.min(names);
        assertEquals("Ann", m);
    }

    @Test
    @DisplayName("Min: empty list should throw")
    void minEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> MinUtils.min(new ArrayList<Integer>()));
    }

    @Test
    @DisplayName("Copy: PECS bounds allow Number <- Integer")
    void copyPecs() {
        List<Number> dst = new ArrayList<>();
        List<Integer> src = Arrays.asList(1, 2, 3);
        CopyUtils.copy(dst, src);
        assertEquals(Arrays.asList(1,2,3), dst);
    }

    @Test
    @DisplayName("Copy: appends to destination")
    void copyAppends() {
        List<Object> dst = new ArrayList<>(List.of("x"));
        List<String> src = List.of("a", "b");
        CopyUtils.copy(dst, src);
        assertEquals(List.of("x","a","b"), dst);
    }
}
