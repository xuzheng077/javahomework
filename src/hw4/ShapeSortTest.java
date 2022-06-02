package hw4;

/**
 * Driver class.
 *
 * @author Xu Zheng
 * <p>
 * Andrew id: xuzheng
 */
public class ShapeSortTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[args.length];

        //initialize Shape array
        for (int i = 0; i < args.length; i++) {
            char type = args[i].charAt(0);
            int size = Integer.parseInt(args[i].substring(1));
            switch (type) {
                case 'C':
                    shapes[i] = new Circle(size);
                    break;
                case 'S':
                    shapes[i] = new Square(size);
                    break;
                case 'H':
                    shapes[i] = new Hexagon(size);
                    break;
                case 'O':
                    shapes[i] = new Octagon(size);
                    break;
                default:
            }
        }

        //sort in ascending order of area
        for (int i = 0; i < shapes.length; i++) {
            int min = i;
            for (int j = i + 1; j < shapes.length; j++) {
                if (shapes[j].getArea() < shapes[min].getArea()) {
                    min = j;
                }
            }
            Shape temp = shapes[i];
            shapes[i] = shapes[min];
            shapes[min] = temp;
        }
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
        //sort in descending order of perimeter
        for (int i = 0; i < shapes.length; i++) {
            int max = i;
            for (int j = i + 1; j < shapes.length; j++) {
                if (shapes[j].getPerimeter() > shapes[max].getPerimeter()) {
                    max = j;
                }
            }
            Shape temp = shapes[i];
            shapes[i] = shapes[max];
            shapes[max] = temp;
        }
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }
}
