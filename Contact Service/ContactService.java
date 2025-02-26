package contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public boolean addContact(Contact newContact) {
        if (contacts.containsKey(newContact.getId())) {
            throw new IllegalArgumentException("Duplicate ID is not allowed.");
        }
        contacts.put(newContact.getId(), newContact);
        return true;
    }

    public Contact getContact(String ID) {
        if (!contacts.containsKey(ID)) {
            throw new IllegalArgumentException("Contact cannot be found.");
        }
        return contacts.get(ID);
    }

    public boolean deleteContact(String ID) {
        return contacts.remove(ID) != null;
    }

    public boolean updateContactFirstName(String ID, String newFirstName) {
        Contact contact = contacts.get(ID);
        if (contact != null) {
            contact.setFirstName(newFirstName);
            return true;
        }
        return false;
    }

    public boolean updateContactLastName(String ID, String newLastName) {
        Contact contact = contacts.get(ID);
        if (contact != null) {
            contact.setLastName(newLastName);
            return true;
        }
        return false;
    }

    public boolean updateContactAddress(String ID, String newAddress) {
        Contact contact = contacts.get(ID);
        if (contact != null) {
            contact.setAddress(newAddress);
            return true;
        }
        return false;
    }

    public boolean updateContactPhone(String ID, String newPhone) {
        Contact contact = contacts.get(ID);
        if (contact != null) {
            contact.setPhone(newPhone);
            return true;
        }
        return false;
    }
}
