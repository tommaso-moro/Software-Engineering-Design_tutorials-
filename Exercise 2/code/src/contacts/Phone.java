package contacts;

public class Phone extends ContactInfo implements AudioMessageEnabled {
    String phoneNumber;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    };

    public String contactInfo() {
        return phoneNumber;
    };

    public String contactInfoType() {
        return "Phone Number";
    };

    @Override
    public void sendAudioMessage(Audio msg) {
        System.out.println(phoneNumber);
        System.out.println(msg.toString());
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println(msg);
    }
}
