package hw5;

/**
 * hw5.Student class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Student {
    /**
     * firstName.
     */
    private String firstName;

    /**
     * lastName.
     */
    private String lastName;

    /**
     * andrewId.
     */
    private String andrewId;

    /**
     * phoneNumber.
     */
    private String phoneNumber;

    /**
     * Constructor.
     *
     * @param aId andrew id
     */
    public Student(String aId) {
        this.andrewId = aId;
    }

    /**
     * Constructor.
     * @param aId andrew id
     * @param fName firstName
     * @param lName lastName
     * @param pNumber phone number
     */
    public Student(String aId, String fName, String lName, String pNumber) {
        this.andrewId = aId;
        this.firstName = fName;
        this.lastName = lName;
        this.phoneNumber = pNumber;
    }

    /**
     * Getter for firstName.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName.
     *
     * @param fName first name
     */
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    /**
     * Getter for lastName.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName.
     *
     * @param lName last name
     */
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    /**
     * Getter for andrewId.
     *
     * @return andrew id
     */
    public String getAndrewId() {
        return andrewId;
    }

    /**
     * Getter for phoneNumber.
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for phoneNumber.
     *
     * @param pNumber phone number
     */
    public void setPhoneNumber(String pNumber) {
        this.phoneNumber = pNumber;
    }

    /**
     * toString().
     *
     * @return String representation of student
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " (Andrew ID: " + andrewId + ", Phone Number: " + phoneNumber + ")";
    }
}
