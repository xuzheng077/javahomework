package hw3;

/**
 * Square class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Square extends Rectangle {
    public static void main(String[] args) {
        final long MICROS_FOR_TWO_DAYS = 24 * 60 * 60 * 1000 * 1000 * 2L;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_FOR_TWO_DAYS / MILLIS_PER_DAY);
    }
    /**
     * Side.
     */
    private double side;

    /**
     * Constructor.
     *
     * @param newSide new side
     */
    public Square(double newSide) {
        super(newSide, newSide);
        this.side = newSide;
    }

    /**
     * Getter for side.
     *
     * @return side
     */
    public double getSide() {
        return this.side;
    }

    /**
     * toString().
     *
     * @return String representation of square
     */
    @Override
    public String toString() {
        return "Square " + String.format("%.3f", this.getArea()) + " " + String.format("%.3f", this.getPerimeter());
    }
}
