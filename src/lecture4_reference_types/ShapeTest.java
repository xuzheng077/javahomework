package lecture4_reference_types;

/**
 * Example code for to test with Shapes.
 * @author Terry Lee
 */
public class ShapeTest {
    /**
     * Demo code to test different shapes.
     * @param args arguments
     */
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c);

        Rectangle r = new Rectangle(5, 3);
        System.out.println(r);

        Square s = new Square(3);
        System.out.println(s + " area=" + s.getArea());

        Shape s1 = c;
        Shape s2 = r;
        System.out.println(s1);
        System.out.println(s2);
    }
}
