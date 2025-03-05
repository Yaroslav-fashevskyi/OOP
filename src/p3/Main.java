package src.p3;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] array;


    public static void main(String[] args) {
        System.out.println("Введіть розмір масиву:");
        int size = scanner.nextInt();
        array = new int[size];


        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }


        while (true) {
            System.out.println("Виберіть дію:");
            System.out.println("1. Сума всіх елементів");
            System.out.println("2. Середнє значення");
            System.out.println("3. Максимальне та мінімальне значення");
            System.out.println("4. Виведення масиву");
            System.out.println("5. Замінити значення, менші за середнє, на 0");
            System.out.println("6. Вийти");


            int choice = scanner.nextInt();


            switch (choice) {
                case 1 -> sumElements();
                case 2 -> averageValue();
                case 3 -> minMaxValues();
                case 4 -> printArray();
                case 5 -> replaceBelowAverage();
                case 6 -> {
                    System.out.println("Вийшов");
                    return;
                }
                default -> System.out.println("Неправильний вибір");
            }
        }
    }


    private static void sumElements() {
        int sum = Arrays.stream(array).sum();
        System.out.println("Сума всіх елементів: " + sum);
    }


    private static void averageValue() {
        double average = Arrays.stream(array).average().orElse(0);
        System.out.println("Середнє значення: " + average);
    }


    private static void minMaxValues() {
        int min = Arrays.stream(array).min().orElse(Integer.MIN_VALUE);
        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
    }


    private static void printArray() {
        System.out.println("Масив у прямому порядку: " + Arrays.toString(array));
        System.out.print("Масив у зворотному порядку: [");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + (i > 0 ? ", " : ""));
        }
        System.out.println("]");
    }


    private static void replaceBelowAverage() {
        double average = Arrays.stream(array).average().orElse(0);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) {
                array[i] = 0;
            }
        }
        System.out.println("Масив після заміни: " + Arrays.toString(array));
    }
}

