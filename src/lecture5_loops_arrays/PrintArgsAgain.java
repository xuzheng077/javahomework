package lecture5_loops_arrays;

/**
 * Example code for array and for-each (enhanced) loop.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class PrintArgsAgain {
    /**
     * print an array of arguments using for loop.
     * @param args argument array
     */
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }
    }
}
