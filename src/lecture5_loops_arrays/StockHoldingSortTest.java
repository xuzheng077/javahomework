package lecture5_loops_arrays;

/**
 * Example code for an array of objects and for loop and sorting.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StockHoldingSortTest {
    /**
     * Build StockHolding objects and sort them using nested for loops.
     * @param arguments
     */
    public static void main(String[] args) {
        StockHolding[] ha = new StockHolding[5];
        ha[0] = new StockHolding("IBM", 500);
        ha[1] = new StockHolding("MSFT", 400);
        ha[2] = new StockHolding("AAPL", 300);
        ha[3] = new StockHolding("GOOG", 200);
        ha[4] = new StockHolding("AMZN", 100);

        for (int i = 0; i < ha.length; i++) {
            for (int j = i + 1; j < ha.length; j++) {
                if ((ha[j].getPrice() * ha[j].getShares()) < (ha[i].getPrice() * ha[i].getShares())) {
                    StockHolding temp = ha[i];
                    ha[i] = ha[j];
                    ha[j] = temp;
                }
            }
        }

        for (StockHolding sh : ha) {
            System.out.printf("%5s, shares=%6d, price=$%7.2f, value=$%,10.2f\n",
                    sh.getTicker(), sh.getShares(), sh.getPrice(),
                    sh.getPrice() * sh.getShares());
        }
    }
}
