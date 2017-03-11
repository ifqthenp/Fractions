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
 * {@code FractionAbsTest} class.
 */
@RunWith(value = Parameterized.class)
public class FractionCompareToTest {

    private Fraction fraction;
    private Fraction val;
    private int diff;

    public FractionCompareToTest(Fraction f1, Fraction f2, int diff) {
        this.fraction = f1;
        this.val = f2;
        this.diff = diff;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Fraction(3, 4), new Fraction(2, 3), 1},    // 0
                {new Fraction(5, 8), new Fraction(7, 10), -1},  // 1
                {new Fraction(5, 6), new Fraction(3, 4), 1},    // 2
                {new Fraction(14, 9), new Fraction(5, 3), -1},  // 3
                {new Fraction(1, 3), new Fraction(2, 3), -1},   // 4
                {new Fraction(3, 4), new Fraction(1, 4), 1},    // 5
                {new Fraction(14, 9), new Fraction(5, 9), 1},   // 6
                {new Fraction(4, 12), new Fraction(6, 12), -1}, // 7
                {new Fraction(6, 12), new Fraction(4, 12), 1},  // 8
                {new Fraction(12, 12), new Fraction(12, 12), 0},// 9
                {new Fraction(12), new Fraction(12), 0},        // 10
                {new Fraction(12, 12), new Fraction(12), -1},   // 11
                {new Fraction(12, 1), new Fraction(12), 0},     // 12
                {new Fraction(-3, 4), new Fraction(3, 4), -1},  // 13
                {new Fraction(3, -4), new Fraction(3, 4), -1},  // 14
                {new Fraction(-3, -4), new Fraction(3, 4), 0},  // 15
                {new Fraction(-4, 3), new Fraction(3, 4), -1},  // 16
                {new Fraction(9, -3), new Fraction(3, 4), -1}   // 17
        });
    }

    @Test
    public void compareTo() {
        assertThat(this.fraction.compareTo(this.val), is(this.diff));
    }

    @After
    public void tearDown() throws Exception {
        fraction = null;
        val = null;
        diff = 0;
    }
}
