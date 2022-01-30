import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class MaximumTest {
    @Test
    void shouldThrowAnExceptionWhenNoValuesInList() {
        try {
            Maximum.findMaximum(new ArrayList<>());
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("No values in the input to search for maximum", exception.getMessage());
        }
    }

    @Test
    void shouldThrowAnExceptionWhenListIsNull() {
        try {
            Maximum.findMaximum(null);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("No values in the input to search for maximum", exception.getMessage());
        }
    }

    @Test
    void shouldReturnMaximumValue() {
        List<Integer> listToSearch = Arrays.asList(25, 2, 8, 96, 12, 2, 91);
        Integer max = Maximum.findMaximum(listToSearch);
        assertEquals(96, max);
    }

    @Test
    void shouldReturnValueWhenSameValues() {
        List<Integer> listToSearch = Arrays.asList(96, 96, 96);
        Integer max = Maximum.findMaximum(listToSearch);
        assertEquals(96, max);
    }
}