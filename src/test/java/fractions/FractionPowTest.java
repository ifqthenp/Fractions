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
 * {@code FractionPowTest} class.
 */
@RunWith(value = Parameterized.class)
public class FractionPowTest {

    private Fraction fraction;
    private int val;
    private Fraction expFraction;

    public FractionPowTest(Fraction fraction, int val, Fraction expFraction) {
        this.fraction = fraction;
        this.val = val;
        this.expFraction = expFraction;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Fraction(3, 5), 0, new Fraction(1)},
                {new Fraction(-3, 5), 0, new Fraction(1)},
                {new Fraction(-3, -5), 0, new Fraction(1)},
                {new Fraction(3, -5), 0, new Fraction(1)},

                {new Fraction(3, 5), 1, new Fraction(3, 5)},
                {new Fraction(-3, 5), 1, new Fraction(-3, 5)},
                {new Fraction(-3, -5), 1, new Fraction(3, 5)},
                {new Fraction(3, -5), 1, new Fraction(-3, 5)},

                {new Fraction(3, 5), 2, new Fraction(9, 25)},
                {new Fraction(-3, 5), 2, new Fraction(9, 25)},
                {new Fraction(-3, -5), 2, new Fraction(9, 25)},
                {new Fraction(3, -5), 2, new Fraction(9, 25)},

                {new Fraction(3, 5), 3, new Fraction(27, 125)},
                {new Fraction(-3, 5), 3, new Fraction(-27, 125)},
                {new Fraction(-3, -5), 3, new Fraction(27, 125)},
                {new Fraction(3, -5), 3, new Fraction(-27, 125)},

                {new Fraction(3, 5), -1, new Fraction(5, 3)},
                {new Fraction(-3, 5), -1, new Fraction(-5, 3)},
                {new Fraction(-3, -5), -1, new Fraction(5, 3)},
                {new Fraction(3, -5), -1, new Fraction(-5, 3)},

                {new Fraction(5, 3), -1, new Fraction(3, 5)},
                {new Fraction(-5, 3), -1, new Fraction(-3, 5)},
                {new Fraction(-5, -3), -1, new Fraction(3, 5)},
                {new Fraction(5, -3), -1, new Fraction(-3, 5)},

                {new Fraction(5, 3), -2, new Fraction(9, 25)},
                {new Fraction(-5, 3), -2, new Fraction(9, 25)},
                {new Fraction(-5, -3), -2, new Fraction(9, 25)},
                {new Fraction(5, -3), -2, new Fraction(9, 25)},

                {new Fraction(5, 3), -3, new Fraction(27, 125)},
                {new Fraction(-5, -3), -3, new Fraction(27, 125)},
                {new Fraction(-5, 3), -3, new Fraction(-27, 125)},
                {new Fraction(5, -3), -3, new Fraction(-27, 125)}
        });
    }

    @Test
    public void min() throws Exception {
        assertThat(this.fraction.pow(this.val), is(this.expFraction));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
        val = 0;
        expFraction = null;
    }

}
