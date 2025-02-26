package ContactTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import contacts.Contact;
import contacts.ContactService;

class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    private Contact createContact(String firstName, String lastName, String id, String phone, String address) {
        return new Contact(firstName, lastName, id, phone, address);
    }

    @Test
    void testAddContact() {
        Contact contact = createContact("John", "Doe", "1", "1234567890", "123 Street");
        assertTrue(contactService.addContact(contact));
        
        Contact retrieved = contactService.getContact("1");
        assertAll(
            () -> assertNotNull(retrieved),
            () -> assertEquals("John", retrieved.getFirstName()),
            () -> assertEquals("Doe", retrieved.getLastName()),
            () -> assertEquals("1", retrieved.getId()),
            () -> assertEquals("1234567890", retrieved.getPhone()),
            () -> assertEquals("123 Street", retrieved.getAddress())
        );
    }

    @Test
    void testAddMultipleContacts() {
        Contact contact1 = createContact("John", "Doe", "1", "1234567890", "123 Street");
        Contact contact2 = createContact("Jane", "Doe", "2", "0987654321", "456 Avenue");

        assertTrue(contactService.addContact(contact1));
        assertTrue(contactService.addContact(contact2));

        Contact retrieved1 = contactService.getContact("1");
        Contact retrieved2 = contactService.getContact("2");

        assertAll(
            () -> assertEquals("John", retrieved1.getFirstName()),
            () -> assertEquals("Doe", retrieved1.getLastName()),
            () -> assertEquals("1234567890", retrieved1.getPhone()),
            () -> assertEquals("123 Street", retrieved1.getAddress()),

            () -> assertEquals("Jane", retrieved2.getFirstName()),
            () -> assertEquals("Doe", retrieved2.getLastName()),
            () -> assertEquals("0987654321", retrieved2.getPhone()),
            () -> assertEquals("456 Avenue", retrieved2.getAddress())
        );
    }

    @Test
    void testAddDuplicateContactId() {
        Contact contact1 = createContact("John", "Doe", "1", "1234567890", "123 Street");
        Contact contact2 = createContact("Jane", "Doe", "1", "0987654321", "456 Avenue");

        assertTrue(contactService.addContact(contact1));
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test
    void testUpdateContact() {
        Contact contact = createContact("John", "Doe", "1", "1234567890", "123 Street");
        contactService.addContact(contact);

        assertTrue(contactService.updateContactFirstName("1", "Mike"));
        assertTrue(contactService.updateContactLastName("1", "Smith"));
        assertTrue(contactService.updateContactPhone("1", "1112223333"));
        assertTrue(contactService.updateContactAddress("1", "789 Boulevard"));

        Contact updated = contactService.getContact("1");
        
        assertAll(
            () -> assertEquals("Mike", updated.getFirstName()),
            () -> assertEquals("Smith", updated.getLastName()),
            () -> assertEquals("1112223333", updated.getPhone()),
            () -> assertEquals("789 Boulevard", updated.getAddress())
        );
    }

    @Test
    void testDeleteContact() {
        Contact contact = createContact("John", "Doe", "1", "1234567890", "123 Street");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("1"));

        assertThrows(IllegalArgumentException.class, () -> contactService.getContact("1"));
    }
}
