package lecture4_reference_types;

/**
 * Example code for Shape (inheritance).
 * @author Terry Lee
 */
public class Shape {
    /**
     * Instance variable for area.
     */
    private double area;

    /**
     * Constructor with area parameter.
     * @param newArea area
     */
    public Shape(double newArea) {
        area = newArea;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns String representation of Shape object.
     * @return String representation of Shape object
     */
    @Override
    public String toString() {
        return "Shape(area=" + area + ")";
    }
}
