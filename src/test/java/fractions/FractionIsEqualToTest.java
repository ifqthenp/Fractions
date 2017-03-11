package fractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * {@code FractionIsEqualToTest} class.
 */
public class FractionIsEqualToTest {

    private Fraction fraction;

    @Before
    public void setUp() throws Exception {
        fraction = new Fraction(3, 5);
    }

    @Test
    public void isEqualToIsFalseIfValIsNull() throws Exception {
        assertThat(this.fraction.isEqualTo(null), is(false));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
    }
}
