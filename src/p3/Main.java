package src.p3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final HashMap<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserInput("Виберіть дію: ");
            switch (choice) {
                case 1 -> addWord();
                case 2 -> findTranslation();
                case 3 -> showDictionary();
                case 4 -> removeWord();
                case 5 -> {
                    System.out.println("Програма завершена.");
                    return;
                }
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Меню:");
        System.out.println("1 - Додати слово");
        System.out.println("2 - Знайти переклад");
        System.out.println("3 - Показати весь словник");
        System.out.println("4 - Видалити слово");
        System.out.println("5 - Вийти");
    }

    private static int getUserInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Введіть число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addWord() {
        scanner.nextLine();
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine().trim();
        System.out.print("Введіть переклад: ");
        String translation = scanner.nextLine().trim();

        if (dictionary.containsKey(word)) {
            System.out.println("Це слово вже є в словнику. зараз оновлю переклажд");
        }
        dictionary.put(word, translation);
        System.out.println("Слово додано!");
    }

    private static void findTranslation() {
        scanner.nextLine();
        System.out.print("Введіть слово для пошуку: ");
        String word = scanner.nextLine().trim();
        if (dictionary.containsKey(word)) {
            System.out.println("Переклад: " + dictionary.get(word));
        } else {
            System.out.println("Цього слова немає в словнику.");
        }
    }

    private static void showDictionary() {
        if (dictionary.isEmpty()) {
            System.out.println("Словник порожній.");
            return;
        }
        System.out.println("Весь словник:");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static void removeWord() {
        scanner.nextLine();
        System.out.print("Введіть слово для видалення: ");
        String word = scanner.nextLine().trim();
        if (dictionary.remove(word) != null) {
            System.out.println("Слово видалено.");
        } else {
            System.out.println("Слово не знайдено.");
        }
    }
}

