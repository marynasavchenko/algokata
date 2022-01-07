import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffle {

    public static List<Integer> shuffle(List<Integer> toShuffle) {
        if (toShuffle == null || toShuffle.isEmpty()) {
            throw new IllegalArgumentException("No elements to shuffle");
        }
        List<Integer> toReturn = Arrays.asList(new Integer[toShuffle.size()]);
        Collections.copy(toReturn, toShuffle);
        int size = toReturn.size();
        for (int i = 0; i < size; i++) {
            Integer temp = toReturn.get(i);
            int ran = getRandomNumber(size - 1);
            toReturn.set(i, toReturn.get(ran));
            toReturn.set(ran, temp);
        }
        return toReturn;

    }

    private static int getRandomNumber(int size) {
        Random random = new Random();
        return random.ints(0, size)
                .findFirst()
                .getAsInt();
    }
}
