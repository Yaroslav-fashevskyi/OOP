package cafe;

public class CardPayment implements PaymentStrategy {
    private String cardNumber;
    private BankService bankService;

    public CardPayment(String cardNumber, BankService bankService) {
        this.cardNumber = cardNumber;
        this.bankService  = bankService;
    }

    @Override
    public void pay(double amount) {
        boolean ok = bankService.processPayment(cardNumber, amount);
        if (!ok) {
            throw new RuntimeException("Транзакцію відхилено банком");
        }
    }
}
