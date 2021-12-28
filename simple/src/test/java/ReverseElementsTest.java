import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseElementsTest {
    @Test
    void shouldThrowAnExceptionWhenNoElements() {
        try {
            ReverseElements.reverseElements(new ArrayList<>());
            fail("Should have thrown IllegalArgumentException");

        } catch (IllegalArgumentException exception) {
            assertEquals("No elements to reverse", exception.getMessage());
        }
    }

    @Test
    void shouldReverseElementInTheList() {
        List<Integer> listToRevert = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        ReverseElements.reverseElements(listToRevert);
        Integer[] expected = {7, 6, 5, 4, 3, 2, 1};

        assertArrayEquals(listToRevert.toArray(new Integer[0]), expected);
    }
}