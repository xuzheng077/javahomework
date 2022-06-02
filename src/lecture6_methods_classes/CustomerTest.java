package lecture6_methods_classes;

/**
 * Example code for lecture 6.
 * A simple test code for Customer (static members)
 * @author Jeffrey Eppinger & Terry Lee
 */
public class CustomerTest {
    /**
     * A simple program to use static method.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println(Customer.getNumCustomers() + " customers");

        Customer[] list = new Customer[5];
        list[0] = new Customer("Joe", "Biden");
        list[1] = new Customer("Barack", "Obama");
        list[2] = new Customer("Bill", "Clinton");
        list[3] = new Customer("Donald", "Trump");
        list[4] = new Customer("Hillary", "Clinton");

        for (Customer c : list) {
            System.out.println(c);
        }

        System.out.println(Customer.getNumCustomers() + " customers");
    }
}
