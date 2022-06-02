package hw4;

/**
 * Square class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Square extends Rectangle {
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
