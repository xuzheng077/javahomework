package lecture3_java_classes;

/**
 * An extension of AddressBookEntry without using inheritance.
 * @author Terry Lee
 */
public class AddressBookEntry2 {
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
     * Instance variable for age.
     */
    int age;

    /**
     * Instance method to print fields.
     */
    void print() {
        System.out.println("Name:   " + firstName + " " + lastName);
        System.out.println("Tel:    " + telephoneNumber);
        System.out.println("E-Mail: " + eMailAddress);
        System.out.println("Age     " + age);
    }

    /**
     * Instance method for birthday operation.
     */
    void birthday() {
        age = age + 1;
    }

    /**
     * Code to instantiate AddressBookEntry2 objects and initialize fields
     * @param args arguments
     */
    public static void main(String[] args) {
        AddressBookEntry2 terry = new AddressBookEntry2();
        terry.firstName = "Terry";
        terry.lastName = "Lee";
        terry.telephoneNumber = "412-268-1078";
        terry.eMailAddress = "terrylee@cs.cmu.edu";
        terry.age = 20;

        terry.print();

        AddressBookEntry2 jeff = new AddressBookEntry2();
        jeff.firstName = "Jeffrey";
        jeff.lastName = "Eppinger";
        jeff.telephoneNumber = "412-268-7688";
        jeff.eMailAddress = "eppinger@cmu.edu";
        jeff.age = 59;

        jeff.print();

        AddressBookEntry2 barry = new AddressBookEntry2();
        barry.firstName = "Barack";
        barry.lastName = "Obama";
        barry.telephoneNumber = "202-456-1111";
        barry.eMailAddress = "president@whitehouse.gov";
        barry.age = 58;

        barry.print();

        jeff.birthday();
        terry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();
        barry.birthday();

        jeff.print();
        terry.print();
        barry.print();
    }
}
