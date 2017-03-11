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
 * {@code FractionSignumTest} class.
 */
@RunWith(Parameterized.class)
public class FractionSignumTest {

    private int numerator;
    private int denominator;
    private int expected;

    private Fraction fraction;

    public FractionSignumTest(int numerator, int denominator, int expected) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 5, 1}, {2, 1, 1}, {5, 5, 1}, {5, 3, 1}, {-5, 3, -1},
                {-3, -3, 1}, {3, -3, -1}, {3, -9, -1}, {0, 4, 0}, {4, 0, 0}
        });
    }

    @Before
    public void setUp() throws Exception {
        fraction = new Fraction(this.numerator, this.denominator);
    }

    @Test
    public void signum() {
        assertThat(fraction.signum(), is(expected));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
    }
}
