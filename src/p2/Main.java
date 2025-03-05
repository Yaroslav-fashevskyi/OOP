package src.p2;

import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            System.out.println("Виберіть операцію:");
            System.out.println("1. Додавання");
            System.out.println("2. Віднімання");
            System.out.println("3. Множення");
            System.out.println("4. Ділення");
            System.out.println("5. Зведення до степеня");
            System.out.println("6. Вийти");


            int choice = scanner.nextInt();


            if (choice == 6) {
                System.out.println("вийшов");
                return;
            }


            System.out.println("Введіть перше число:");
            double num1 = scanner.nextDouble();
            System.out.println("Введіть друге число:");
            double num2 = scanner.nextDouble();


            switch (choice) {
                case 1 -> add(num1, num2);
                case 2 -> subtract(num1, num2);
                case 3 -> multiply(num1, num2);
                case 4 -> divide(num1, num2);
                case 5 -> power(num1, num2);
                default -> System.out.println("неправильний вибір");
            }
        }
    }


    private static void add(double a, double b) {
        System.out.println("Результат додавання: " + (a + b));
    }


    private static void subtract(double a, double b) {
        System.out.println("Результат віднімання: " + (a - b));
    }


    private static void multiply(double a, double b) {
        System.out.println("Результат множення: " + (a * b));
    }


    private static void divide(double a, double b) {
        if (b != 0) {
            System.out.println("Результат ділення: " + (a / b));
        } else {
            System.out.println("ділення на нуль");
        }
    }


    private static void power(double a, double b) {
        System.out.println("Результат піднесення до степеню: " + Math.pow(a, b));
    }
}



