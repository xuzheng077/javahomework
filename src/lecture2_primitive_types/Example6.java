package lecture2_primitive_types;

/**
 * Example for manipulating program arguments as long.
 * @author Terry Lee (terrylee@cs.cmu.edu)
 */
public class Example6 {
    /**
     * Demo code to access program arguments using Long class.
     * @param args arguments
     */
    public static void main(String[] args) {
        long x = Long.parseLong(args[0]);
        System.out.println("x = " + x);
    }
}
