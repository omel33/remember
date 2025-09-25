import org.junit.jupiter.api.Test;
import topic3.day14.CopyUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyUtilsTest {
    @Test
    void copy_shouldCopyArray() {
        int[] src = {1,2,3};
        int[] dst = {1,2,3};
        assertEquals(src, dst);
    }
    @Test
    void copy_shouldCopyArrayWithoutModification() {
        int[] src = {};
        int[] dst = {10};
        assertEquals(src, dst);
    }

}
