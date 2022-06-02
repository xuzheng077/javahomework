package lecture5_loops_arrays;

/**
 * Example code for while loop.
 * precondition: exponent is non-negative values
 * @author Jeffrey Eppinger & Terry Lee
 */
public class IsPowerOfTwo {
    /**
     * Checks if int value is power of two but broken.
     * @param args arguments
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        boolean answer = false;
        int p = 1;
        while (p <= x) {
            System.out.println("Testing " + p);
            if (p == x) {
                answer = true;
            }
            p = p * 2;
        }
        System.out.println("Answer is: " + answer);
    }
}