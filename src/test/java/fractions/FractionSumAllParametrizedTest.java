package fractions;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * {@code FractionSumAllParametrizedTest} class.
 */
@RunWith(value = Parameterized.class)
public class FractionSumAllParametrizedTest {

    private Fraction[] fractions;
    private Fraction expected;

    public FractionSumAllParametrizedTest(Fraction[] fractions, Fraction expected) {
        this.fractions = fractions;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new Fraction[]
                                {
                                        new Fraction(5, -10),
                                        new Fraction(5, 3),
                                        new Fraction(12, 5)
                                },
                        new Fraction(107, 30)
                },
                {
                        new Fraction[]
                                {
                                        new Fraction(5, 7),
                                        null,
                                        new Fraction(2, 8)
                                },
                        null
                },
                {
                        null, null
                }
        });
    }

    @Test
    public void sumAllParametrizedTest() throws Exception {
        assertThat(Fraction.sumAll(fractions), is(expected));
    }

    @After
    public void tearDown() throws Exception {
        fractions = null;
        expected = null;
    }
}
