package hw3;

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
        super(Math.PI * newRadius * newRadius, 2.0 * Math.PI * newRadius);
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

}
