package ru.stepup.payments.mobile;

public class Fraction extends Number{
    private int numerator; //числитель
    private int denominator; //знаменатель

    private Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction of(int numerator, int denominator) {
        if (denominator==0)
            throw new IllegalArgumentException("Знаменатель не может быть равен 0!");
        if (denominator<0)
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным!");
        return new Fraction(numerator,denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return ""+numerator + "/" + denominator;
    }
    public Fraction sum(Fraction fraction){
        //приводим к общему знаменателю
        int newnumer=this.numerator* fraction.denominator + fraction.numerator*this.denominator;
        int newdenom=this.denominator*fraction.denominator;
        return new Fraction(newnumer,newdenom);
    }
    public Fraction sum(int num){
        //приводим к общему знаменателю
        int newnumer=this.numerator + num*this.denominator;
        int newdenom=this.denominator;
        return new Fraction(newnumer,newdenom);
    }

    public Fraction minus(Fraction fraction){
        //приводим к общему знаменателю
        int newnumer=this.numerator* fraction.denominator - fraction.numerator*this.denominator;
        int newdenom=this.denominator*fraction.denominator;
        return new Fraction(newnumer,newdenom);
    }

    public Fraction minus(int num){
        //приводим к общему знаменателю
        int newnumer=this.numerator-num*this.denominator;
        int newdenom=this.denominator;
        return new Fraction(newnumer,newdenom);
    }

    @Override
    public long longValue() {
        return (long)numerator/denominator;
    }

    @Override
    public float floatValue() {
        return (float)numerator/denominator;
    }

    @Override
    public double doubleValue() {
        return (double)numerator/denominator;
    }

    @Override
    public int intValue() {
        return (int)numerator/denominator;
    }
}
