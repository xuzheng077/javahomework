package hw3;

/**
 * Shape class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Shape {

    /**
     * Area of a shape.
     */
    private double area;

    /**
     * Perimeter of a shape.
     */
    private double perimeter;

    /**
     * Constructor.
     *
     * @param newArea      new area
     * @param newPerimeter new perimeter
     */
    public Shape(double newArea, double newPerimeter) {
        this.area = newArea;
        this.perimeter = newPerimeter;
    }

    /**
     * Getter for area.
     *
     * @return area
     */
    public double getArea() {
        return this.area;
    }

    /**
     * Getter for perimeter.
     *
     * @return perimeter
     */
    public double getPerimeter() {
        return this.perimeter;
    }

    /**
     * toString().
     *
     * @return String representation of shape
     */
    @Override
    public String toString() {
        return "Shape " + String.format("%.3f", this.area) + " " + String.format("%.3f", this.perimeter);
    }
}
