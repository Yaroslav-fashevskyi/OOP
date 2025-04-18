package cafe;

/**
 * Інтерфейс для звернення до зовнішнього банку або його симулятора.
 */
public interface BankService {
    /**
     * Спробувати стягнути amount ₴ з картки cardNumber.
     * @param cardNumber номер картки
     * @param amount сума платежу
     * @return true — якщо банк «пропустив» платіж, false — якщо відхилив
     */
    boolean processPayment(String cardNumber, double amount);
}
