package lecture5_loops_arrays;

/**
 * Stockholding example code.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class StockHolding {
    /**
     * Ticker of a stock.
     */
    private String ticker;
    /**
     * Number of shares of a stock.
     */
    private int shares;
    /**
     * Full name of a stock.
     */
    private String name;
    /**
     * Market price of a stock.
     */
    private float price;

    /**
     * This is the constructor method.
     * @param newTicker ticker
     * @param newShares share price
     */
    public StockHolding(String newTicker, int newShares) {
        ticker = newTicker;
        shares = newShares;
        StockQuote sq = new StockQuote(ticker);
        price = sq.getPrice();
        name = sq.getName();
    }

    /**
     * Returns ticker of a stock.
     * @return String value of ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * Returns number of shares of a stock.
     * @return int value of number of shares
     */
    public int getShares() {
        return shares;
    }

    /**
     * Returns full name of a stock.
     * @return String value of a full name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns current market price of a stock.
     * @return float value of a market price
     */
    public float getPrice() {
        return price;
    }
}
