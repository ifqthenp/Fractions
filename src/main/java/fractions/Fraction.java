package fractions;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Immutable fractions of whole numbers, also known as rational numbers,
 * with their usual arithmetic operations.
 * <p>
 * Similar to java.lang.BigInteger, the documentation uses pseudo-code
 * throughout the descriptions of Fraction methods. The pseudo-code
 * expression (i + j) is shorthand for "a Fraction whose value is that
 * of the Fraction plus that of the Fraction j". Other pseudo-code
 * expressions are interpreted similarly.
 *
 * @see java.math.BigInteger
 */
public class Fraction {

    private BigInteger numerator;
    private BigInteger denominator;

    /**
     * Constructs a Fraction taking the value of its parameter.
     *
     * @param val non-null; the value the Fraction is supposed to take
     */
    public Fraction(BigInteger val) {
        this(val, new BigInteger("1"));
    }

    /**
     * Constructs a new Fraction taking the value of its parameter.
     *
     * @param val the value that the Fraction is supposed to take
     */
    public Fraction(long val) {
        this(BigInteger.valueOf(val), new BigInteger("1"));
    }

    /**
     * Constructs a normalised form of Fraction corresponding to
     * numerator / denominator.
     * The value is 0 if denominator is 0.
     *
     * @param numerator   non-null; value of the numerator
     * @param denominator non-null; value of the denominator
     */
    public Fraction(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);

        if (denominator.signum() > 0) {
            this.numerator = numerator.divide(gcd);
        } else if (denominator.signum() < 0) {
            this.numerator = numerator.divide(gcd).negate();
        }
        this.denominator = denominator.abs().divide(gcd);

        if (numerator.equals(BigInteger.ZERO) || denominator.equals(BigInteger.ZERO)) {
            this.numerator = BigInteger.ZERO;
            this.denominator = BigInteger.ZERO;
        }
    }

    /**
     * Constructs a Fraction corresponding to numerator / denominator.
     * The value is 0 if denominator is 0.
     *
     * @param numerator   the numerator of the Fraction
     * @param denominator the denominator of the Fraction
     */
    public Fraction(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    /**
     * Returns the sum of all elements of vals.
     *
     * @param fractions array of Fractions to be summed up; may be or contain null
     * @return null if vals is or contains null; the sum of all elements of
     * vals otherwise
     */
    public static Fraction sumAll(Fraction[] fractions) {
        if (fractions == null || fractions.length == 0) {
            return null;
        }

        Fraction result = fractions[0];

        for (int i = 1; i < fractions.length; i++) {
            if (fractions[i] == null) {
                result = null;
                break;
            } else {
                result = result.add(fractions[i]);
            }
        }
        return result;
    }

    /**
     * Returns a Fraction whose value is (this + val).
     * (Note that a/b + c/d = (a*d + b*c)/(b*d).)
     *
     * @param val non-null; to be added to this
     * @return this + val
     */
    public Fraction add(Fraction val) {
        BigInteger n = (this.numerator.multiply(val.denominator)).add((this.denominator.multiply(val.numerator)));
        BigInteger d = this.denominator.multiply(val.denominator);
        return new Fraction(n, d);
    }

    /**
     * Returns a Fraction whose value is (this - val).
     *
     * @param val non-null; to be subtracted from this Fraction
     * @return this - val
     */
    public Fraction subtract(Fraction val) {
        return add(val.negate());
    }

    /**
     * Returns a Fraction whose value is (this * val).
     * (Note that a/b * c/d = (a*c)/(b*d).)
     *
     * @param val non-null; to be multiplied to this Fraction
     * @return this * val
     */
    public Fraction multiply(Fraction val) {
        BigInteger n = this.numerator.multiply(val.numerator);
        BigInteger d = this.denominator.multiply(val.denominator);
        return new Fraction(n, d);
    }

    /**
     * Returns a Fraction whose value is (this / val).
     *
     * @param val non-null; value by which this Fraction is to be divided
     * @return this / val
     */
    public Fraction divide(Fraction val) {
        return multiply(val.invert());
    }

    /**
     * Returns a Fraction whose value is (-this).
     *
     * @return -this
     */
    public Fraction negate() {
        return new Fraction(this.numerator.negate(), this.denominator);
    }

    /**
     * Returns the inverse of this Fraction, i.e., the Fraction 1 / this.
     *
     * @return 1 / this
     */
    public Fraction invert() {
        return new Fraction(this.denominator, this.numerator);
    }

    /**
     * Returns the sign of this Fraction: 1 if its value is positive,
     * 0 if it is zero, -1 if it is negative.
     *
     * @return the sign of this Fraction (1 if its value is positive,
     * 0 if it is zero, -1 if it is negative)
     */
    public int signum() {
        return this.numerator.signum();
    }

    /**
     * Returns the absolute value of this Fraction, i.e.,
     * the value of the Fraction itself if it is non-negative,
     * otherwise the negated value.
     *
     * @return the absolute value of this Fraction
     */
    public Fraction abs() {
        return new Fraction(this.numerator.abs(), this.denominator);
    }

    /**
     * Returns the maximum of this Fraction and val.
     *
     * @param val non-null; the value with which the maximum is to be computed
     * @return the maximum of this Fraction and val
     */
    public Fraction max(Fraction val) {
        if (this.compareTo(val) >= 0) {
            return this;
        } else {
            return val;
        }
    }

    /**
     * Returns the minimum of this Fraction and val.
     *
     * @param val non-null; the value with which the minimum is to be computed
     * @return the minimum of this Fraction and val
     */
    public Fraction min(Fraction val) {
        if (this.compareTo(val) <= 0) {
            return this;
        } else {
            return val;
        }
    }

    /**
     * Returns this Fraction taken to the power of exponent. Here
     * exponent may also be zero or negative. Note that a^0 = 1 and
     * a^b = (1/a)^(-b) if b < 0.
     *
     * @param exponent the exponent to which we want to take this
     * @return this Fraction taken to the power of exponent
     */
    public Fraction pow(int exponent) {
        if (exponent >= 0) {
            return new Fraction(this.numerator.pow(exponent),
                    this.denominator.pow(exponent));
        } else {
            return new Fraction(this.denominator.pow(-exponent),
                    this.numerator.pow(-exponent));
        }
    }

    /**
     * Compares this Fraction with the specified Fraction.
     *
     * @param val non-null; value with which this Fraction is to be compared
     * @return -1, 0 or 1 as this Fraction is numerically less than,
     * equal to, or greater than val
     * @see BigInteger#compareTo(BigInteger)
     */
    public int compareTo(Fraction val) {
        int diff;
        if (this.denominator.equals(val.denominator)) {
            diff = this.numerator.compareTo(val.numerator);
        } else if (this.numerator.equals(val.numerator)) {
            diff = this.denominator.compareTo(val.denominator) * (-1);
        } else {
            BigInteger gcd = this.denominator.gcd(val.denominator);
            BigInteger lcm = this.denominator.multiply(val.denominator).divide(gcd);

            BigInteger lcm1 = lcm.divide(this.denominator);
            BigInteger lcm2 = lcm.divide(val.denominator);

            diff = (this.numerator.multiply(lcm1)).compareTo(val.numerator.multiply(lcm2));
        }
        return diff;
    }

    /**
     * Checks if this Fraction and val represent equal values.
     *
     * @param val potentially null (in this case the method returns false);
     *            the value with which this Fraction is to be compared for equality
     * @return true if this Fraction and other represent the same value;
     * false otherwise
     */
    public boolean isEqualTo(Fraction val) {
        return this.equals(val);
    }

    /**
     * Returns a normalised String representation of this Fraction.
     * For example, new Fraction(5,3) and new Fraction(-10,-6) will
     * be represented as "(5 / 3)". The String representation of
     * new Fraction(5,-10) and new Fraction(-12,24) is "(-1 / 2)".
     * <p>
     * In case this Fraction has an integer value, just the String
     * representation of the integer value is returned. For example,
     * new Fraction(-2) has the String representation "-2"; and
     * new Fraction(0), new Fraction(0,3), and new Fraction(4,0)
     * all have the String representation "0".
     *
     * @return a normalised String representation of this Fraction
     */
    @Override
    public String toString() {
        String result;
        if (this.denominator.equals(BigInteger.ZERO) || this.numerator.equals(BigInteger.ZERO)) {
            result = "0";
        } else if (this.denominator.equals(BigInteger.ONE)) {
            result = String.format("%d", this.numerator);
        } else {
            result = String.format("(%d / %d)", this.numerator, this.denominator);
        }
        return result;
    }

    /**
     * The {@code equals} method indicates whether some other object
     * is "equal to" this one.
     *
     * @param o the other object to compare
     * @return {@code true} if this object is the same as the obj argument
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fraction fraction = (Fraction) o;

        return Objects.equals(this.numerator, fraction.numerator) &&
                Objects.equals(this.denominator, fraction.denominator);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        int result = numerator.hashCode();
        result = 31 * result + denominator.hashCode();
        return result;
    }
}
