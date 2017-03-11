package fractions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@code FractionToStringTest} class.
 */
public class FractionToStringTest {

    @Test
    public void toStringRepresentsFullyReducedFraction() throws Exception {
        assertEquals("(5 / 3)", new Fraction(10, 6).toString());
        assertEquals("(5 / 3)", new Fraction(-10, -6).toString());
        assertEquals("(-1 / 2)", new Fraction(-12, 24).toString());
        assertEquals("(-1 / 2)", new Fraction(12, -24).toString());
    }

    @Test
    public void toStringRepresentsIntegerIfFractionHasSingleIntegerValue() throws Exception {
        assertEquals("-2", new Fraction(-2).toString());
        assertEquals("3", new Fraction(3).toString());
    }

    @Test
    public void toStringRepresentsZeroIfAnyOfFractionValuesIsZero() throws Exception {
        assertEquals("0", new Fraction(0).toString());
//        assertEquals("0", new Fraction(0, 0).toString());
//        assertEquals("0", new Fraction(3, 0).toString());
//        assertEquals("0", new Fraction(-5, 0).toString());
        assertEquals("0", new Fraction(0, 4).toString());
        assertEquals("0", new Fraction(0, -5).toString());
    }
}
