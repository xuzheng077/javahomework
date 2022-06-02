package lecture3_java_classes;

/**
 * Example code for lecture 3 (Java Classes).
 * First example of inheritance
 * @author Terry Lee
 */
public class MyEntry extends AddressBookEntry {
    /**
     * additional instance variable for age.
     */
    int age;

    /**
     * additional instance method for birthday operation.
     */
    void birthday() {
        age = age + 1;
    }

    /**
     * Overridden print method.
     */
    @Override
    void print() {
        super.print();
        System.out.println("Age:    " + age);
    }

    /**
     * Demo code to instantiate MyEntry instantiation and initialize fields.
     * @param args arguments
     */
    public static void main(String[] args) {
        // local variable
        MyEntry terry = new MyEntry();
        terry.firstName = "Terry";
        terry.lastName = "Lee";
        terry.telephoneNumber = "412-268-1078";
        terry.eMailAddress = "terrylee@cs.cmu.edu";
        terry.age = 20;
        terry.print();
    }
}
