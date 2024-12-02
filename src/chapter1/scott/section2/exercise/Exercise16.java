package chapter1.scott.section2.exercise;

public class Exercise16 {

    public static void main(String[] args) {
        System.out.println(gcd(10, 5));

        Rational a = new Rational(6, 4);
        Rational b = new Rational(3, 2);
        Rational plusResult = a.plus(b);
        System.out.println(plusResult);

        Rational minusResult = a.minus(b);
        System.out.println(minusResult);

        Rational timesResult = a.times(b);
        System.out.println(timesResult);

        Rational dividesResult = a.divides(b);
        System.out.println(dividesResult);
    }

    public static int gcd(int p, int q) {
        if (q == 0) { return p; }
        int r = p % q;
        return gcd(q, r);
    }

    public static class Rational {
        private int numerator;
        private int denominator;

        public Rational(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Rational plus(Rational b) {
            int plusNumerator = this.getNumerator() * b.getDenominator() + b.getNumerator()* this.getDenominator();
            int plusDenominator = this.getDenominator() * b.getDenominator();
            int plusGreatestCommonDivisor = gcd(plusNumerator, plusDenominator);
            return new Rational(plusNumerator/plusGreatestCommonDivisor, plusDenominator/plusGreatestCommonDivisor);
        }

        public Rational minus(Rational b) {
            int minusNumerator = this.getNumerator() * b.getDenominator() - b.getNumerator()* this.getDenominator();
            int minusDenominator = this.getDenominator() * b.getDenominator();
            int minusGreatestCommonDivisor = gcd(minusNumerator, minusDenominator);
            return new Rational(minusNumerator/minusGreatestCommonDivisor, minusDenominator/minusGreatestCommonDivisor);
        }

        public Rational times(Rational b) {
            int timesNumerator = this.getNumerator() * b.getNumerator();
            int timesDenominator = this.getDenominator() * b.getDenominator();
            int timesGreatestCommonDivisor = gcd(timesNumerator, timesDenominator);
            return new Rational(timesNumerator/timesGreatestCommonDivisor, timesDenominator/timesGreatestCommonDivisor);
        }

        public Rational divides(Rational b) {
            int dividesNumerator = this.getNumerator() * b.getDenominator();
            int dividesDenominator = this.getDenominator() * b.getNumerator();
            int dividesGreatestCommonDivisor = gcd(dividesNumerator, dividesDenominator);
            return new Rational(dividesNumerator/dividesGreatestCommonDivisor, dividesDenominator/dividesGreatestCommonDivisor);
        }

        public int getDenominator() {
            return denominator;
        }

        public int getNumerator() {
            return numerator;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Rational other = (Rational) obj;
            if (denominator != other.denominator) return false;
            if (numerator != other.numerator) return false;
            return true;
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }
}
