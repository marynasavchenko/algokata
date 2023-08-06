import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Median {

    public static Double getMedian(List<Double> input) {
        Collections.sort(input);
        int size = input.size();

        if (size % 2 == 0) {
            return (input.get(size / 2) + input.get(size / 2 - 1)) / 2;
        } else {
            return input.get(size / 2);
        }
    }
}
