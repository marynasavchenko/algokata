import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HarmonicNumberTest {

    @Test
    void shouldReturnHarmonicNumber() {
        double harmN10 = 2.9289682539682538;
        double harmonicNumber = HarmonicNumber.harmonicNumber(10);

        assertEquals(harmN10, harmonicNumber);
    }

    @Test
    void harmonicNumberOfZeroShouldBeZero() {
        double harmonicNumber = HarmonicNumber.harmonicNumber(0);

        assertEquals(0.0, harmonicNumber);
    }

    @Test
    void harmonicNumberOfOneShouldBeOne() {
        double harmonicNumber = HarmonicNumber.harmonicNumber(1);

        assertEquals(1.0, harmonicNumber);
    }
}