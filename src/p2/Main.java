package src.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Integer> numbers = new ArrayList<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        initializeArray();
        while (true) {
            showMenu();
            int choice = getUserInput("Виберіть дію: ");
            switch (choice) {
                case 1 -> addNumber();
                case 2 -> updateNumber();
                case 3 -> removeNumber();
                case 4 -> viewNumbers();
                case 5 -> sortAscending();
                case 6 -> sortDescending();
                case 7 -> {
                    System.out.println("Програма завершена.");
                    return;
                }
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void initializeArray() {
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100)); // Генерує випадкове число від 0 до 99
        }
        System.out.println("Початковий масив: " + numbers);
    }

    private static void showMenu() {
        System.out.println("Меню:");
        System.out.println("1 - Додати нове значення");
        System.out.println("2 - Перезаписати існуюче значення");
        System.out.println("3 - Видалити значення");
        System.out.println("4 - Переглянути всі значення");
        System.out.println("5 - Сортувати за зростанням");
        System.out.println("6 - Сортувати за спаданням");
        System.out.println("7 - Вийти");
    }

    private static int getUserInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Введіть число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addNumber() {
        int newValue = getUserInput("Введіть нове число: ");
        numbers.add(newValue);
        System.out.println("Додано: " + newValue);
    }

    private static void updateNumber() {
        int index = getUserInput("Введіть індекс для оновлення (0-" + (numbers.size() - 1) + "): ");
        if (index >= 0 && index < numbers.size()) {
            int newValue = getUserInput("Введіть нове значення: ");
            numbers.set(index, newValue);
            System.out.println("Значення оновлено.");
        } else {
            System.out.println("Некоректний індекс.");
        }
    }

    private static void removeNumber() {
        int index = getUserInput("Введіть індекс для видалення (0-" + (numbers.size() - 1) + "): ");
        if (index >= 0 && index < numbers.size()) {
            numbers.remove(index);
            System.out.println("Елемент видалено.");
        } else {
            System.out.println("Некоректний індекс.");
        }
    }

    private static void viewNumbers() {
        System.out.println("Масив: " + numbers);
    }

    private static void sortAscending() {
        Collections.sort(numbers);
        System.out.println("Відсортовано за зростанням: " + numbers);
    }

    private static void sortDescending() {
        numbers.sort(Collections.reverseOrder());
        System.out.println("Відсортовано за спаданням: " + numbers);
    }
}
