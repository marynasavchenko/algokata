import java.util.List;

public class ReverseElements {

    public static void reverseElements(List<Integer> listToReverse) {
        if (listToReverse == null || listToReverse.isEmpty()) {
            throw new IllegalArgumentException("No elements to reverse");
        }

        int size = listToReverse.size();
        for (int i = 0; i < size / 2; i++) {
            int temp = listToReverse.get(i);
            listToReverse.set(i, listToReverse.get(size - 1 - i));
            listToReverse.set((size - i - 1), temp);
        }
    }
}
