package Bai04;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double getValue() {
        return (double) numerator / denominator;
    }

    public Fraction add(Fraction f){
        Fraction result = new Fraction();
        result.setNumerator(this.getNumerator() * f.getDenominator() + f.getNumerator() * this.getDenominator());
        result.setDenominator(this.getDenominator() * f.getDenominator());
        return result;
    }

    public Fraction subtract(Fraction f){
        Fraction result = new Fraction();
        result.setNumerator(this.getNumerator() * f.getDenominator() - f.getNumerator() * this.getDenominator());
        result.setDenominator(this.getDenominator() * f.getDenominator());
        return result;
    }

    public Fraction multiply(Fraction f){
        Fraction result = new Fraction();
        result.setNumerator(this.getNumerator() * f.getNumerator());
        result.setDenominator(this.getDenominator() * f.getDenominator());
        return result;
    }

    public Fraction divide(Fraction f){
        Fraction result = new Fraction();
        result.setNumerator(this.getNumerator() * f.getDenominator());
        result.setDenominator(this.getDenominator() * f.getNumerator());
        return result;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
