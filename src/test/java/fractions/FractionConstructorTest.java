package fractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertNotNull;

/**
 * {@code FractionTest} test class.
 */
public class FractionConstructorTest {

    private Fraction fraction;

    @Before
    public void setUpWithLongNumeratorAndDenominator() throws Exception {
        fraction = new Fraction(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    @Before
    public void setUpWithLongValue() throws Exception {
        fraction = new Fraction(Long.MAX_VALUE);
    }

    @Before
    public void setUpWithBigIntegerNumeratorAndDenominator() throws Exception {
        BigInteger numerator = new BigInteger(100, new Random());
        BigInteger denominator = new BigInteger(1000, new Random());
        fraction = new Fraction(numerator, denominator);
    }

    @Before
    public void setUpWithBigIntegerValue() throws Exception {
        BigInteger val = new BigInteger("1000000000000000000000000000");
        fraction = new Fraction(val);
    }

    @Test
    public void fractionIsNotNullAfterConstruction() throws Exception {
        assertNotNull("fraction is null", fraction);
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
    }
}
