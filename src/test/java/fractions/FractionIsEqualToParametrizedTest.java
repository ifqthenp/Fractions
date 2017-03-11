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
 * {@code FractionIsEqualToTest} class.
 */
@RunWith(value = Parameterized.class)
public class FractionIsEqualToParametrizedTest {

    private Fraction fraction;
    private Fraction val;
    private boolean expected;

    public FractionIsEqualToParametrizedTest(Fraction fraction, Fraction val, boolean expected) {
        this.fraction = fraction;
        this.val = val;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Fraction(3, 5), new Fraction(3, 5), true},
                {new Fraction(-3, 5), new Fraction(3, 5), false},
                {new Fraction(-3, -5), new Fraction(3, 5), true},
                {new Fraction(3, -5), new Fraction(3, 5), false},
        });
    }

    @Test
    public void isEqualToWithParameters() throws Exception {
        assertThat(this.fraction.isEqualTo(this.val), is(this.expected));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
        val = null;
        expected = false;
    }
}
