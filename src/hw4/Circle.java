package hw4;

/**
 * Circle class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Circle extends Shape {
    /**
     * Radius.
     */
    private double radius;

    /**
     * Constructor.
     *
     * @param newRadius
     */
    public Circle(double newRadius) {
        this.radius = newRadius;
    }

    /**
     * Getter for radius.
     *
     * @return radius
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * toString().
     *
     * @return String representation of circle
     */
    @Override
    public String toString() {
        return "Circle " + String.format("%.3f", this.getArea()) + " " + String.format("%.3f", this.getPerimeter());
    }

    /**
     * Calculate area.
     *
     * @return area
     */
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    /**
     * Calculate perimeter.
     *
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * this.radius;
    }
}
