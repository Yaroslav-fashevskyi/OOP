package cafe;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Прийнято готівку: " + amount + " ₴");
    }
}
