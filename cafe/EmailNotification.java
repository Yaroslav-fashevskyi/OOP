package cafe;

public class EmailNotification implements NotificationService {
    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void notifyCustomer(String message) {
        System.out.println("Відправлено e‑mail на " + email + ": " + message);
    }
}

