package hw3;

/**
 * Octagon class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Octagon extends Shape {
    /**
     * side.
     */
    private double side;

    /**
     * Constructor.
     *
     * @param newSide new side
     */
    public Octagon(double newSide) {
        super(2.0 * (1.0 + Math.sqrt(2.0)) * newSide * newSide, 8.0 * newSide);
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
     * @return String representation of Octagon
     */
    @Override
    public String toString() {
        return "Octagon " + String.format("%.3f", this.getArea()) + " " + String.format("%.3f", this.getPerimeter());
    }
}
