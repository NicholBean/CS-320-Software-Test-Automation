/**
 * @author Nicholas Bean
 */

package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactServiceTest {

    private ContactService service;
    
    // Refreshes the service BEFORE running a test
    @BeforeEach
    void setUp() {
        service = new ContactService(); 
    }
    
    @Test
    // Test adding a single contact
    void testAddContact() {
        Contact contact = new Contact("1", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        service.addContact(contact);
        // Should pass
        assertTrue(service.getAllContacts().containsKey("1"));
    }

    @Test
    // Test adding multiple contacts (2)
    void testAddDuplicateContactIdThrowsException() {
        System.out.println("Running testAddDuplicateContactIdThrowsException");
        Contact contact1 = new Contact("1", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        Contact contact2 = new Contact("2", "Allie", "Robberts", "5675948927", "8365 Shawnee Rd");
        service.addContact(contact1);
        service.addContact(contact2);
        }

    @Test
    // Test Deleting a contact
    void testDeleteContact() {
        Contact contact = new Contact("1", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        // Create contact
        service.addContact(contact);
        // Proof contact exists
        assertTrue(service.getAllContacts().containsKey("1"));
        // Delete it
        service.deleteContact("1");
        // Proof contact is deleted
        assertFalse(service.getAllContacts().containsKey("1"));
    }

    @Test
    void testAddContactDuplicateIdFails() {
        // Add contact
        Contact contact1 = new Contact("1", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        service.addContact(contact1);

        // Add second contact with same ID
        Contact contactDuplicate = new Contact("1", "Allie", "Robberts", "5675948927", "8365 Shawnee Rd");

        // Try adding another contact with same ID
        try {
            service.addContact(contactDuplicate);
            // Duplicate was added - should fail
            assertFalse(true, "Duplicate contact was added but should not have been.");
        } catch (IllegalArgumentException e) {
            // Exception thrown
            assertTrue(true);
        }

        // Proof only the original contact exists
        assertEquals(1, service.getAllContacts().size());
        assertTrue(service.getAllContacts().containsKey("1"));
    }


    @Test
    // Update First Name
    void testUpdateFirstName() {
        Contact contact = new Contact("1", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        service.addContact(contact);
        // Should pass
        service.updateFirstName("1", "Nick");
        assertEquals("Nick", service.getAllContacts().get("1").getFirstName());
    }

    @Test
    // Update Last Name
    void testUpdateLastName() {
        Contact contact = new Contact("1", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        service.addContact(contact);
        // Should pass
        service.updateLastName("1", "Roberts");
        assertEquals("Roberts", service.getAllContacts().get("1").getLastName());
    }

    @Test
    // Update phone number
    void testUpdatePhone() {
        Contact contact = new Contact("1", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        service.addContact(contact);
        // Should pass
        service.updatePhone("1", "4192224444");
        assertEquals("4192224444", service.getAllContacts().get("1").getPhone());
    }

    @Test
    // Update Address
    void testUpdateAddress() {
        Contact contact = new Contact("1", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        service.addContact(contact);
        // Should pass
        service.updateAddress("1", "8537 Makley St");
        assertEquals("8537 Makley St", service.getAllContacts().get("1").getAddress());
    }
}
