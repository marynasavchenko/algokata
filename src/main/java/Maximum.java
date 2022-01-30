import java.util.List;

public class Maximum {
    public static Integer findMaximum(List<Integer> listToSearch) {
        Integer max = 0;
        if (listToSearch == null || listToSearch.isEmpty()) {
            throw new IllegalArgumentException("No values in the input to search for maximum");
        }
        for (Integer val : listToSearch) {
            if (val > max) {
                max = val;
            }

        }
        return max;
    }
}
