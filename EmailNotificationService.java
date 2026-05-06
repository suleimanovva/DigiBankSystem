public class EmailNotificationService implements Observer {
    private String adminEmail;

    public EmailNotificationService(String email) {
        this.adminEmail = email;
    }

    @Override
    public void update(String message) {
        System.out.println("\n[SIMULATED EMAIL SENT to " + adminEmail + "]");
        System.out.println("Subject: DigiBank Real-Time File Alert");
        System.out.println("Body: " + message);
        System.out.println("Attachment: [File attached successfully]");
    }
}