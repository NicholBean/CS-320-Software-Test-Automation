package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    // Create Contact - Should pass
    void testValidContactCreationIDPass() {
        Contact contact = new Contact("54321", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
		assertTrue(contact.getContactID().equals("54321"));
	    assertTrue(contact.getFirstName().equals("Nicholas"));
	    assertTrue(contact.getLastName().equals("Bean"));
	    assertTrue(contact.getPhone().equals("4196046829"));
	    assertTrue(contact.getAddress().equals("2965 Rocky St"));
    }
    
    @Test
    // Test if an error occurs if the contact ID is too long
    void testContactIdTooLongThrowsException() {
    	// Should Pass since contact ID was over 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
        	// Exception was thrown - should fail
            new Contact("543211532645367534", "Nicholas", "Bean", "4196046829", "2965 Rocky St");
        });
    }
    
    @Test
    // Test if an error occurs if the contact first name is too long
    void testFirstNameTooLongThrowsException() {
    	// Should pass since first name is over 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
        	// Exception was thrown - should fail
            new Contact("54321", "Nicholassss", "Bean", "4196046829", "2965 Rocky St");
        });
    }

    @Test
    // Test if an error occurs if the contact's last name is too long
    void testLastNameTooLongThrowsException() {
    	//Should pass since last name is over 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
        	// Exception was thrown - should fail
            new Contact("54321", "Nicholas", "LightGreenBean", "4196046829", "2965 Rocky St");
        });
    }

    @Test
    // Test if an error occurs if the phone number is not exactly 10 characters
    void testPhoneNotTenDigitsThrowsException() {
    	// Should pass since phone number is over 10 characters 
        assertThrows(IllegalArgumentException.class, () -> {
        	// Exception was thrown - should fail
            new Contact("54321", "Nicholas", "Bean", "41960468299", "2965 Rocky St");
        });
    }
    
    @Test
    // Test if an error occurs if the contact address is too long
    void testAddressTooLongThrowsException() {
    	// Should pass since address is over 30 characters
        assertThrows(IllegalArgumentException.class, () -> {
        	// Exception was thrown - should fail
            new Contact("54321", "Nicholas", "Bean", "41960468299", "2956 Dairy Queen Moose Track Rockey Ice Cream Road Street");
        });
    }
}
