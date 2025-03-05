package src.p2;

public class Fraction {
    private int numerator;   // Чисельник
    private int denominator; // Знаменник

    // Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Знаменник не може бути нулем!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reductionFraction(); // Автоматично скорочуємо дріб при створенні
    }

    // Метод додавання
    public Fraction addition(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод віднімання
    public Fraction subtraction(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод множення
    public Fraction multiplication(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод ділення
    public Fraction division(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе!");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод скорочення дробу
    private void reductionFraction() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Метод для знаходження найбільшого спільного дільника (НСД)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Метод для виведення дробу у вигляді рядка
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

