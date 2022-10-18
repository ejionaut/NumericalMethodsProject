// Fraction class

public class Fraction {

    // object fields
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 0;
    }

    public Fraction(int wholeNumber) {
        this(wholeNumber, 1);
    }

    public Fraction(int numerator, int denominator) {
        try {
            this.numerator = numerator;
            this.denominator = denominator;
        } catch (NoNumeratorException nException) {
            throw new NoNumeratorException("Numerator must be an integer value.");
        } catch (NoDenominatorException dException) {
            throw new NoDenominatorException("Zero is an invalid denominator");
        }
    }

    // Getter Methods
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Setter Methods
    public void setNumerator(int numerator) {
        try {
            this.numerator = numerator;
        } catch (NoNumeratorException exception) {
            throw new NoNumeratorException("Numerator must be an integer value.");
        }
    }

    public void setDenominator(int denominator) {
        if (denominator == 0)
            throw new NoDenominatorException("Zero is an invalid denominator.");
        else
            this.denominator = denominator;
    }

    // Methods to reduce fraction to its lowest term
    protected int computeGCD() {
        int num = numerator, den = denominator, a = num,
                b = den, temp, rem, gcd, count = 0;
        do {
            rem = a % b;
            temp = b;
            b = rem;
            a = temp;
            count++;
        } while (rem != 0);
        gcd = temp;
        return gcd;
    }

    public void reduceFraction() throws Exception {
        int gcd = computeGCD();
        int newNumerator = numerator / gcd;
        int newDenominator = denominator / gcd;
        setNumerator(newNumerator);
        setDenominator(newDenominator);
    }

    // Methods for printing fraction value
    public String toString() {
        return (numerator + "/" + denominator);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }
}
