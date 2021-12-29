import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PrimeNumberTest {

    @Test
    void shouldReturnTrueWhenPrimeNumber() {
        boolean isPrime = PrimeNumber.isPrimeNumber(13);

        assertTrue(isPrime);
    }

    @Test
    void shouldReturnFalseWhenNotAPrimeNumber() {
        boolean isPrime = PrimeNumber.isPrimeNumber(15);

        assertFalse(isPrime);
    }
}