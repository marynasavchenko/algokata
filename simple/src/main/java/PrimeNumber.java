/**
 * A prime number is a number that can only be divided by itself and 1 without remainders.
 */
public class PrimeNumber {
    public static boolean isPrimeNumber(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
