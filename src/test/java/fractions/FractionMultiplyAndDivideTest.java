package fractions;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * {@code FractionMultiplyAndDivideTest} class.
 */
public class FractionMultiplyAndDivideTest {

    private Fraction fraction;

    @Test
    public void multiply() {
        fraction = new Fraction(2);
        Fraction m = fraction.multiply(new Fraction(2));
        assertTrue("2 * 2 = 4", m.equals(new Fraction(4)));
    }

    @Test
    public void divide() throws Exception {
        fraction = new Fraction(2);
        Fraction m = fraction.divide(new Fraction(4));
        System.out.println(m.toString());
        assertTrue(m.equals(new Fraction(1, 2)));
    }
}
