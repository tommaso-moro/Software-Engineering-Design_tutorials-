package contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    List<Contact> contacts = new ArrayList<>();

    void add(Person p, ContactInfo c) {
        Contact contact = new Contact(p, c);
        contacts.add(contact);
    }

    List<ContactInfo> contactDetails(Person p) {
        List<ContactInfo> contactInfo = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.person.name() == p.name()) {
                contactInfo.add(contact.contactInfo);
            }

        }
        return contactInfo;
    }

    void spam(String msg) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            contact.contactInfo.sendMessage(msg);
        }
    }
}
