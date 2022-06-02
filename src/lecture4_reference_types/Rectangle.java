package lecture4_reference_types;

/**
 * Example code for Shape (inheritance).
 * @author Terry Lee
 */
public class Rectangle extends Shape {
    /**
     * Instance variable for width.
     */
    private double width;
    /**
     * Instance variable for height.
     */
    private double height;

    /**
     * Constructor with width and height.
     * @param newWidth width value
     * @param newHeight height value
     */
    public Rectangle(double newWidth, double newHeight) {
        super(newWidth * newHeight);
        width = newWidth;
        height = newHeight;
    }

    /**
     * Returns width value of rectangle object.
     * @return width value in double
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns height value of rectangle object.
     * @return height value in double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns Spring representation of rectangle object.
     * @return String representation of rectangle object
     */
    @Override
    public String toString() {
        return "Rectangle(width=" + width + ", height=" + height + ")";
    }
}
