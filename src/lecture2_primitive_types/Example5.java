package lecture2_primitive_types;

/**
 * Example for manipulating program arguments as int.
 * @author Terry Lee (terrylee@cs.cmu.edu)
 */
public class Example5 {
    /**
     * Demo code to access program arguments using Integer class.
     * @param args arguments
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("x = " + x);
        int half = x / 2;
        System.out.println("half = " + half);
    }
}
