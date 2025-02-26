package ContactTests;

import static org.junit.jupiter.api.Assertions.*;

import contacts.Contact;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testCreateContact() {
        Contact contact = new Contact("John", "Doe", "12345", "1234567890", "123 Main St");
        
        assertAll(
        	() -> assertEquals("John", contact.getFirstName()),
        	() -> assertEquals("Doe", contact.getLastName()),
        	() -> assertEquals("12345", contact.getId()),
        	() -> assertEquals("1234567890", contact.getPhone()),
        	() -> assertEquals("123 Main St", contact.getAddress())
        );
    }

    @Test
    void testContactIdTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", "Doe", "12345678901", "123456789", "123 Main St");
        });
        assertEquals("Invalid id", exception.getMessage());
    }
    
    @Test
    void testInvalidContactId_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Contact("John", "Doe", null, "123456789", "123 Main St")
        );
        assertEquals("Invalid id", exception.getMessage());
    }


    @Test
    void testContactFirstNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("SuperDuperLongName", "Doe", "12345", "1234567890", "123 Main St");
        });
        assertEquals("Invalid name", exception.getMessage());
    }
    
    @Test
    void testInvalidContactFirstName_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "Doe", "12345", "123456789", "123 Main St")
        );
        assertEquals("Invalid name", exception.getMessage());
    }

    @Test
    void testContactLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", "VeryLongLastName", "12345", "1234567890", "123 Main St");
        });
        assertEquals("Invalid name", exception.getMessage());
    }
    
    @Test
    void testInvalidContactLastName_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Contact("John", null, "12345", "123456789", "123 Main St")
        );
        assertEquals("Invalid name", exception.getMessage());
    }

    @Test
    void testContactAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", "Doe", "12345", "1234567890", "1234567890123456789012345678901");
        });
        assertEquals("Invalid address", exception.getMessage());
    }
    
    @Test
    void testInvalidContactAddress_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Contact("John", "Doe", "12345", "1234567890", null)
        );
        assertEquals("Invalid address", exception.getMessage());
    }

    @Test
    void testContactPhoneNumberNotTenDigits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", "Doe", "12345", "123456789", "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }
    
    @Test
    void testInvalidContactPhoneNUmber_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Contact("John", "Doe", "12345", null, "123 Main St")
        );
        assertEquals("Invalid phone number", exception.getMessage());
    }
}