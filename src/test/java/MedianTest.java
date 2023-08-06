import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianTest {

    @Test
    void valueInTheMiddleWhenNumOfObservationsIsOdd() {
        List<Double> dataset = Arrays.asList(12.5, 18.3, 11.2, 19.0, 22.1, 14.3, 16.2, 12.5, 17.8, 16.5, 12.5);

        Double median = Median.getMedian(dataset);

        assertEquals(16.2, median);
    }

    @Test
    void averageOfMiddleWhenNumOfObservationsIsEven() {
        List<Double> dataset = Arrays.asList(12.5, 18.3, 11.2, 19.0, 14.3, 16.2, 12.5, 17.8, 16.5, 12.5);

        Double median = Median.getMedian(dataset);

        assertEquals(15.25, median);

    }
}