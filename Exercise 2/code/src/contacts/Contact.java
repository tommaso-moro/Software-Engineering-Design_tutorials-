package contacts;

public class Contact {
    Person person;
    ContactInfo contactInfo;

    Contact(Person p, ContactInfo c) {
        person = p;
        contactInfo = c;
    }

    public Person getPerson() {
        return person;
    }
}
