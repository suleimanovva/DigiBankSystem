import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailNotificationService implements Observer {
    private String adminEmail;

    private static final String SENDER_EMAIL = "nigaraazamatovna@gmail.com";
    private static final String APP_PASSWORD  = "nilu ocro firj mzha";

    public EmailNotificationService(String email) {
        this.adminEmail = email;
    }

    @Override
    public void update(String message) {
        System.out.println("\n[SENDING REAL EMAIL to " + adminEmail + "]");

        Properties props = new Properties();
        props.put("mail.smtp.auth",            "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host",            "smtp.gmail.com");
        props.put("mail.smtp.port",            "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER_EMAIL, APP_PASSWORD);
            }
        });

        try {
            MimeMessage mail = new MimeMessage(session);
            mail.setFrom(new InternetAddress(SENDER_EMAIL));
            mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adminEmail));
            mail.setSubject("DigiBank Real-Time File Alert");
            mail.setText(message);
            Transport.send(mail);
            System.out.println("✅ Email sent successfully to " + adminEmail);
        } catch (MessagingException e) {
            System.out.println("❌ Email failed: " + e.getMessage());
        }
    }
}