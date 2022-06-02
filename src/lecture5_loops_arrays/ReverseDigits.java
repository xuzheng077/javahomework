package lecture5_loops_arrays;

/**
 * Example code for while loop.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class ReverseDigits {
    /**
     * Try to reverse an int value but broken. 
     * @param args arguments
     */
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        while (x > 0) {
            int digit = x % 10;
            System.out.print(digit);
            x = x / 10;
        }
        System.out.println();
    }
}
