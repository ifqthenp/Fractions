package fractions;

import org.junit.After;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * {@code FractionNegateTest} class.
 */
public class FractionNegateTest {

    private Fraction fraction;

    @Test
    public void negateToStringWithNegativeArguments() throws Exception {
        fraction = new Fraction(-10, -6);
        String expected = new Fraction(-5, 3).toString();
        assertEquals("Fraction is positive", expected, fraction.negate().toString());
    }

    @Test
    public void negateToStringWithPositiveArguments() throws Exception {
        fraction = new Fraction(10, 6);
        String expected = new Fraction(-5, 3).toString();
        assertEquals("Fraction is positive", expected, fraction.negate().toString());
    }

    @Test
    public void negateToStringWithNegativeNumerator() throws Exception {
        fraction = new Fraction(-10, 6);
        String expected = new Fraction(5, 3).toString();
        assertEquals("Fraction is negative", expected, fraction.negate().toString());
    }

    @Test
    public void negateImproperFractionWithNegativeNumerator() throws Exception {
        fraction = new Fraction(-10, 5);
        Fraction expected = new Fraction(2, 1);
        assertEquals("Expected 2, but was -2", expected, this.fraction.negate());
    }

    @Test
    public void negateProperFractionWithNegativeNumerator() throws Exception {
        fraction = new Fraction(-10, 23);
        Fraction expected = new Fraction(10, 23);
        assertEquals("Fraction is negative", expected, this.fraction.negate());
    }

    @Test
    public void negateProperFractionWithPositiveNumeratorAndDenominator() throws Exception {
        fraction = new Fraction(10, 23);
        Fraction expected = new Fraction(-10, 23);
        assertEquals("Fraction is positive", expected, this.fraction.negate());
    }

    @Test
    public void negateProperFractionWithNegativeDenominator() throws Exception {
        fraction = new Fraction(10, -23);
        Fraction expected = new Fraction(10, 23);
        assertEquals("Fraction is negative", expected, this.fraction.negate());
    }

    @Test
    public void negateImproperFractionWithSingleNegativeArgument() throws Exception {
        fraction = new Fraction(-3);
        Fraction expected = new Fraction(3);
        assertEquals("Fraction is negative", expected, this.fraction.negate());
    }

    @Test
    public void negateImproperFractionWithSinglePositiveArgument() throws Exception {
        fraction = new Fraction(3);
        Fraction expected = new Fraction(-3);
        assertEquals("Fraction is positive", expected, this.fraction.negate());
    }

    @Test
    public void negateProperFractionTwoBigIntegerNegativeArguments() throws Exception {
        fraction = new Fraction(new BigInteger("-100"), new BigInteger("-200"));
        BigInteger n = new BigInteger("-1");
        BigInteger d = new BigInteger("2");
        Fraction expected = new Fraction(n, d);
        assertEquals("Fraction is positive", expected, this.fraction.negate());
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
    }
}
