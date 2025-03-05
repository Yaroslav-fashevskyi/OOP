package src.p2;

public class Main {
    public static void main(String[] args) {
        Fraction frac1 = new Fraction(7, 9);
        Fraction frac2 = new Fraction(1, 2);

        System.out.println("Дроби:");
        System.out.println("frac1 = " + frac1);
        System.out.println("frac2 = " + frac2);


        System.out.println("Результати операцій:");
        System.out.println("Додавання: " + frac1.addition(frac2));
        System.out.println("Віднімання: " + frac1.subtraction(frac2));
        System.out.println("Множення: " + frac1.multiplication(frac2));
        System.out.println("Ділення: " + frac1.division(frac2));
    }
}
