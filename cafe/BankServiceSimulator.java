package cafe;

import java.util.Random;

public class BankServiceSimulator implements BankService {
    private final Random rnd = new Random();

    @Override
    public boolean processPayment(String cardNumber, double amount) {
        System.out.println("=== Симуляція виклику банку: стягнення "
                + amount + " ₴ з картки " + cardNumber + " ===");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        boolean success = rnd.nextDouble() < 0.8;
        System.out.println(success
                ? "=== Платіж успішний ==="
                : "=== Платіж НЕСПІВПРАЦЯ (відхилено банком) ===");
        return success;
    }
}
