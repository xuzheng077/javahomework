package lecture5_loops_arrays;

/**
 * Example code for array of objects and for loop.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StockHoldingTest2 {
    /**
     * Build an array of StockHolding object and print using for loop.
     * @param args arguments
     */
    public static void main(String[] args) {
        StockHolding[] ha = new StockHolding[5];
        ha[0] = new StockHolding("IBM", 500);
        ha[1] = new StockHolding("MSFT", 400);
        ha[2] = new StockHolding("AAPL", 300);
        ha[3] = new StockHolding("GOOG", 200);
        ha[4] = new StockHolding("AMZN", 100);

        for (StockHolding sh : ha) {
            System.out.println(sh.getTicker() + ", " + sh.getShares() + ", $"
                    + sh.getPrice() + " (" + sh.getName() + ")");
        }
    }
}
