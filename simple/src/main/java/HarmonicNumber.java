/**
 * Harmonic numbers are described by the formula: (sum of inverses of natural numbers)
 */
public class HarmonicNumber {

    public static double harmonicNumber(int n) {
        double harmonicNumber = 0.0;
        for (int i = 1; i <= n; i++) {
            harmonicNumber += 1.0 / i;
        }
        return harmonicNumber;
    }
}
