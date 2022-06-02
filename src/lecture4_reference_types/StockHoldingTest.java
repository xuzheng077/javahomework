package lecture4_reference_types;

/**
 * Example code to test StockHolding constructor.
 * @author Terry Lee
 */
public class StockHoldingTest {
    /**
     * Demo of Constructor usage.
     * @param args arguments (ticker and shares)
     */
    public static void main(String[] args) {
        StockHolding h = new StockHolding(args[0], Integer.parseInt(args[1]));
        System.out.println(h.ticker + ", " + h.shares + ", $" + h.price + " (" + h.name + ")");
    }
}
