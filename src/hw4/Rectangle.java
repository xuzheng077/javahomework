package hw4;

/**
 * Rectangle class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class Rectangle extends Shape {
    /**
     * Width.
     */
    private double width;
    /**
     * Height.
     */
    private double height;

    /**
     * Constructor.
     *
     * @param newWidth  new width
     * @param newHeight new weight
     */
    public Rectangle(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Calculate area.
     *
     * @return area
     */
    @Override
    public double getArea() {
        return this.width * this.height;
    }

    /**
     * Calculate perimeter.
     *
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        return 2.0 * (this.width + this.height);
    }

    /**
     * Getter for width.
     *
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Getter for height.
     *
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * toString().
     *
     * @return String representation of rectangle
     */
    @Override
    public String toString() {
        return "Rectangle " + String.format("%.3f", getArea()) + " " + String.format("%.3f", getPerimeter());
    }
}
