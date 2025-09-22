import org.junit.jupiter.api.Test;
import tests.MathUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {
    @Test
    void sum_shouldAddTwoNumbers() {
        assertEquals(7, MathUtils.sum(3, 4));
    }
    @Test
    void div_shouldDivideTwoNumbers() {
        assertEquals(5, MathUtils.div(10, 2));
    }
    @Test
    void div_shouldThrowExceptionWhenDivisorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.div(10, 0));
    }
}
