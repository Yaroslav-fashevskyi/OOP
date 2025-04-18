package cafe;

public class SmsNotification implements NotificationService {
    private String phoneNumber;

    public SmsNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notifyCustomer(String message) {
        System.out.println("Відправлено SMS на " + phoneNumber + ": " + message);
    }
}
