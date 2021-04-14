package contacts;

public class Email extends ContactInfo implements TextMessageEnabled {
    String emailAddress = "";

    Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String contactInfo() {
        return emailAddress;
    };

    public String contactInfoType() {
        return "email address";
    };

    public void sendMessage(String msg) {
        sendTextMessage(msg);
    };

    @Override
    public void sendTextMessage(String msg) {
        System.out.println(emailAddress);
        System.out.println(msg);
    }
}
