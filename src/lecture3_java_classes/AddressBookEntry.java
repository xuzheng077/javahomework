package lecture3_java_classes;

/**
 * Example code for lecture 3 (Java Classes).
 * @author Terry Lee
 */
public class AddressBookEntry {
    /**
     * Instance variable for first name.
     */
    String firstName;
    /**
     * Instance variable for last name.
     */
    String lastName;
    /**
     * Instance variable for phone number.
     */
    String telephoneNumber;
    /**
     * Instance variable for email address.
     */
    String eMailAddress;
    
    /**
     * Instance method to print fields.
     */
    void print() {
        System.out.println("Name:   " + firstName + " " + lastName);
        System.out.println("Tel:    " + telephoneNumber);
        System.out.println("E-Mail: " + eMailAddress);
    }

    /**
     * Code to instantiate AddressBookEntry objects and initialize fields
     * @param args arguments
     */
    public static void main(String[] args) {
        // local variable
        AddressBookEntry terry = new AddressBookEntry();
        terry.firstName = "Terry";
        terry.lastName = "Lee";
        terry.telephoneNumber = "412-268-1078";
        terry.eMailAddress = "terrylee@cs.cmu.edu";
    }
}
