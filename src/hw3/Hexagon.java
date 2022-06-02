package hw3;

/**
 * Hexagon class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Hexagon extends Shape {

    /**
     * side.
     */
    private double side;

    /**
     * Constructor.
     *
     * @param newSide new side
     */
    public Hexagon(double newSide) {
        super(3.0 * Math.sqrt(3.0) * newSide * newSide / 2.0, 6.0 * newSide);
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
     * @return String representation of Hexagon
     */
    @Override
    public String toString() {
        return "Hexagon " + String.format("%.3f", this.getArea()) + " " + String.format("%.3f", this.getPerimeter());
    }
}
