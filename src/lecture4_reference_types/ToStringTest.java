package lecture4_reference_types;

/**
 * Example code for Polymorphism.
 * @author Terry Lee
 */
public class ToStringTest {
    /**
     * Demo code to show polymorphism with subclasses.
     * @param args arguments
     */
    public static void main(String[] args) {
        Object o1 = new Square(3);
        Object o2 = new StockHolding("GOOG", 100);

        System.out.println(o1);
        System.out.println(o2);
    }
}
