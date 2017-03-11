package fractions;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * {@code FractionMaxTest} test class.
 */
@RunWith(value = Parameterized.class)
public class FractionMaxTest {

    private Fraction fraction;
    private Fraction val;
    private Fraction maxFraction;

    public FractionMaxTest(Fraction fraction, Fraction val, Fraction maxFraction) {
        this.fraction = fraction;
        this.val = val;
        this.maxFraction = maxFraction;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Fraction(3, 4), new Fraction(3, 5), new Fraction(3, 4)},
                {new Fraction(3, 5), new Fraction(3, 5), new Fraction(3, 5)},
                {new Fraction(3, 8), new Fraction(3, 5), new Fraction(3, 5)},
                {new Fraction(-10, 13), new Fraction(5, 8), new Fraction(5, 8)},
                {new Fraction(-10, -13), new Fraction(5, 8), new Fraction(10, 13)},
                {new Fraction(10, -13), new Fraction(5, 8), new Fraction(5, 8)},
                {new Fraction(10, 13), new Fraction(-5, 8), new Fraction(10, 13)},
                {new Fraction(10, 13), new Fraction(-5, -8), new Fraction(10, 13)},
                {new Fraction(10, 13), new Fraction(5, -8), new Fraction(10, 13)},
                {new Fraction(10), new Fraction(5), new Fraction(10)},
                {new Fraction(-10), new Fraction(5), new Fraction(5)},
                {new Fraction(10), new Fraction(-5), new Fraction(10)},
                {new Fraction(-10), new Fraction(-5), new Fraction(-5)},
                {new Fraction(-10, 10), new Fraction(-5, 5), new Fraction(-1)},
        });
    }

    @Test
    public void max() throws Exception {
        assertThat(this.fraction.max(this.val), is(this.maxFraction));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
        val = null;
        maxFraction = null;
    }
}
