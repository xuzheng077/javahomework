package hw4;

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

    /**
     * Calculate area.
     *
     * @return area
     */
    @Override
    public double getArea() {
        return 3.0 * Math.sqrt(3.0) * this.side * this.side / 2.0;
    }

    /**
     * Calculate perimeter.
     *
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        return 6.0 * this.side;
    }
}
