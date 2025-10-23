/**
 * @author Nicholas Bean
 */

package contact;

public class Contact {
    // Variables for creating the ID
    private final String contactID; 
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Create ID with variables
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // ID verification (required, not null, max 10 chars)
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        this.contactID = contactID;

        // Apply validation
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Function names returning the result from the verification category
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Verification
    
    // Check first name to make sure firstName is not empty and is not longer than 10 characters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }
    // Check last name to make sure lastName is not empty and is not longer than 10 characters
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }
    // Check phone number to make sure setPhone is not empty and exactly 10 characters
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        this.phone = phone;
    }
    // Check address to make sure setAddress is not empty and less than 30 characters
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}