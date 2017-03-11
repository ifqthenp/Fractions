package fractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * {@code FractionConstructorWithZeroTest} class.
 */
public class FractionAddAndSubtractTest {

    private Fraction fraction;

    @Before
    public void setUpWithTwoBigIntegerArguments() throws Exception {
        fraction = new Fraction(new BigInteger("2"), new BigInteger("6"));
    }

    @Before
    public void setupWithTwoLongArguments() throws Exception {
        fraction = new Fraction(2, 6);
    }

    @Test
    public void add() throws Exception {
        assertEquals(new Fraction(7, 12), this.fraction.add(new Fraction(1, 4)));
    }

    @Test
    public void subtract() throws Exception {
        fraction = new Fraction(1, 2);
        assertEquals("", new Fraction(-1, 4), this.fraction.subtract(new Fraction(3, 4)));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
    }
}
