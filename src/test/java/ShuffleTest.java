import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShuffleTest {

    @Test
    void shouldThrowAnExceptionWhenNoElementsToShuffle() {
        try {
            Shuffle.shuffle(new ArrayList<>());
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("No elements to shuffle", exception.getMessage());
        }
    }

    @Test
    void shouldShuffleElementsInACollection() {
        List<Integer> toShuffle = Arrays.asList(5, 9, 56, 32);

        List<Integer> shuffled = Shuffle.shuffle(toShuffle);
        assertTrue(CollectionUtils.isEqualCollection(toShuffle, shuffled));
        assertThat(shuffled).isNotSameAs(toShuffle);
    }
}