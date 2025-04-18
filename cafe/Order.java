package cafe;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderProcessor {
    private List<Item> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;
    private NotificationService notificationService;

    public Order(PaymentStrategy paymentStrategy, NotificationService notificationService) {
        this.paymentStrategy = paymentStrategy;
        this.notificationService = notificationService;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    @Override
    public void processOrder() {
        // 1) Друкуємо заголовок і список товарів
        System.out.println("Ваше замовлення:");
        for (Item item : items) {
            // item.toString() поверне, наприклад, "Лате (50.0 ₴)"
            System.out.println(" – " + item);
        }

        // 2) Розраховуємо й друкуємо загальну суму
        double total = calculateTotal();
        System.out.println("Сума до сплати: " + total + " ₴");

        // 3) Виконуємо оплату
        paymentStrategy.pay(total);

        // 4) Відправляємо сповіщення
        notificationService.notifyCustomer(
                "Ваше замовлення на суму " + total + " ₴ успішно оформлено!"
        );
    }
}


