/**
 * @author Nicholas Bean
 */

package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Contacts are stored and labeled with an ID
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact) {
    	// Contact cannot be created due to being empty
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        // Contact cannot be created because the ID cannot be the same
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactID);
    }

    // Update first name
    public void updateFirstName(String contactID, String firstName) {
        Contact contact = getContactByID(contactID);
        contact.setFirstName(firstName);
    }

    // Update last name
    public void updateLastName(String contactID, String lastName) {
        Contact contact = getContactByID(contactID);
        contact.setLastName(lastName);
    }

    // Update phone number
    public void updatePhone(String contactID, String phone) {
        Contact contact = getContactByID(contactID);
        contact.setPhone(phone);
    }

    // Update address
    public void updateAddress(String contactID, String address) {
        Contact contact = getContactByID(contactID);
        contact.setAddress(address);
    }

    // Helper method to find a contact by ID
    private Contact getContactByID(String contactID) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contact;
    }

    // Return the list of contacts with their IDs
    public Map<String, Contact> getAllContacts() {
        return contacts;
    }
}
