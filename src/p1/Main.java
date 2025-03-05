package src.p1;

import java.util.Scanner;

public class Main {
    private static int counter = 0;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            System.out.println("Виберіть дію:");
            System.out.println("1. Збільшити значення на 1");
            System.out.println("2. Зменшити значення на 1");
            System.out.println("3. Показати значення");
            System.out.println("4. Вийти");


            int choice = scanner.nextInt();


            switch (choice) {
                case 1 -> increaseCounter();
                case 2 -> decreaseCounter();
                case 3 -> showCounter();
                case 4 -> {
                    System.out.println("вийшов");
                    return;
                }
                default -> System.out.println("Неправильний вибір");
            }
        }
    }


    private static void increaseCounter() {
        counter++;
        System.out.println("збільшено на 1. Поточне значення: " + counter);
    }


    private static void decreaseCounter() {
        counter--;
        System.out.println("зменшено на 1. Поточне значення: " + counter);
    }


    private static void showCounter() {
        System.out.println("Поточне значення лічильника: " + counter);
    }
}

