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
public class FractionMinTest {

    private Fraction fraction;
    private Fraction val;
    private Fraction expFraction;

    public FractionMinTest(Fraction fraction, Fraction val, Fraction expFraction) {
        this.fraction = fraction;
        this.val = val;
        this.expFraction = expFraction;

    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Fraction(3, 5), new Fraction(3, 5), new Fraction(3, 5)},
                {new Fraction(3), new Fraction(5), new Fraction(3)},
                {new Fraction(-3), new Fraction(5), new Fraction(-3)},
                {new Fraction(3), new Fraction(-5), new Fraction(-5)},
                {new Fraction(3, 3), new Fraction(-5), new Fraction(-5)},
                {new Fraction(3, 3), new Fraction(-5, 5), new Fraction(-1)},
                {new Fraction(-3, 3), new Fraction(-5, 5), new Fraction(-1)},
                {new Fraction(-3, 4), new Fraction(-5, 5), new Fraction(-1)},
        });
    }

    @Test
    public void min() throws Exception {
        assertThat(this.fraction.min(this.val), is(this.expFraction));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
        val = null;
        expFraction = null;
    }
}
