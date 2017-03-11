package fractions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@code FractionInvertTest} class.
 */
public class FractionInvertTest {

    private Fraction fraction;

    @Test
    public void invertImproperFractionWithSingleLongArgument() throws Exception {
        fraction = new Fraction(2);
        Fraction expected = new Fraction(1, 2);
        assertEquals("Fraction was not inverted", expected, this.fraction.invert());
    }

    @Test
    public void invertImproperFunctionWithTwoLongArguments() throws Exception {
        fraction = new Fraction(9, 3);
        Fraction expected = new Fraction(1, 3);
        assertEquals("Fraction was not inverted", expected, this.fraction.invert());
    }

    @Test
    public void invertProperFunctionWithPositiveArguments() throws Exception {
        fraction = new Fraction(25, 31);
        Fraction expected = new Fraction(31, 25);
        assertEquals("Fraction was not inverted", expected, this.fraction.invert());
    }

    @Test
    public void invertProperFunctionWithBothNegativeArguments() throws Exception {
        fraction = new Fraction(-100, -50);
        Fraction expected = new Fraction(1, 2);
        assertEquals("Fraction was not inverted", expected, this.fraction.invert());
    }

    @Test
    public void invertProperFunctionWithNegativeNumerator() throws Exception {
        fraction = new Fraction(-25, 5);
        Fraction expected = new Fraction(-1, 5);
        assertEquals("Fraction was not inverted", expected, this.fraction.invert());
    }

    @Test
    public void invertProperFunctionWithNegativeDenominator() throws Exception {
        fraction = new Fraction(25, -5);
        Fraction expected = new Fraction(-1, 5);
        assertEquals("Fraction was not inverted", expected, this.fraction.invert());
    }


}
