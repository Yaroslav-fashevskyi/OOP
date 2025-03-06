package src.p1;

import java.util.Scanner;
import java.util.Random;




public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Game();
    }

    private static void Game() {
        int target = new Random().nextInt(100) + 1;
        int guess;
        System.out.println("Загадано потужне число від 1 до 100. Відгадайте його!");
        do {
            System.out.print("Ваш варіант: ");
            guess = scanner.nextInt();
            if (guess > target) {
                System.out.println("Менше!");
            } else if (guess < target) {
                System.out.println("Більше!");
            } else {
                System.out.println("Вітаємо! Ви вгадали потужне число " + target);
            }
        } while (guess != target);
    }
}




/*
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        System.out.println("Вітаємо у потужній грі \"Тепло/Холодно\"!");
        System.out.println("Загадано потужне число від 1 до 100. Спробуйте вгадати в цій потужній грі!");

        Game(scanner, secretNumber);

        scanner.close();
    }

    public static void Game(Scanner scanner, int secretNumber) {
        int guess = 0;
        while (guess != secretNumber) {
            System.out.print("Введіть потужне число: ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                if (guess < secretNumber) {
                    System.out.println("Загадане число більше.");
                } else if (guess > secretNumber) {
                    System.out.println("Загадане число менше.");
                } else {
                    System.out.println("Вітаємо, ви вгадали потужне число!");
                }
            } else {
                System.out.println("Будь ласка, введіть ціле число.");
                scanner.next();
            }
        }
    }
}
*/
