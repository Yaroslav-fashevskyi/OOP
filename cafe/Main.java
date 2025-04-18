package cafe;

public class Main {
    public static void main(String[] args) {
        // Створюємо симулятор банку
        BankService simulator = new BankServiceSimulator();

        // Інжектимо його в CardPayment
        PaymentStrategy payment = new CardPayment("4441-****-****-1234", simulator);
        NotificationService notif = new EmailNotification("guest@example.com");

        Order order = new Order(payment, notif);
        order.addItem(new Item("Лате", 50));
        order.addItem(new Item("Круасан", 30));
        order.addItem(new Item("Чай", 20));

        try {
            order.processOrder();
        } catch (RuntimeException ex) {
            System.err.println("Замовлення НЕ оформлене: " + ex.getMessage());
        }
    }
}
