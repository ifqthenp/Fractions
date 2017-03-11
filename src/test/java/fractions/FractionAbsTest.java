package fractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * {@code FractionAbsTest} class.
 */
@RunWith(value = Parameterized.class)
public class FractionAbsTest {

    private int numerator;
    private int denominator;
    private Fraction expFraction;

    private Fraction fraction;

    public FractionAbsTest(int n, int d, Fraction f) {
        numerator = n;
        denominator = d;
        expFraction = f;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 5, new Fraction(2, 5)},
                {-2, 5, new Fraction(2, 5)},
                {2, -5, new Fraction(2, 5)},
                {-2, -5, new Fraction(2, 5)}
        });
    }

    @Before
    public void setUp() throws Exception {
        fraction = new Fraction(this.numerator, this.denominator);
    }

    @Test
    public void abs() {
        assertThat(this.fraction.abs(), is(this.expFraction));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
    }
}
