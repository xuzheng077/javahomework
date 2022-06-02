package lecture2_primitive_types;

/**
 * Puzzle #3 of "Java Puzzlers" for long division.
 * @author Josh Bloch and Neal Gafter.
 */
public class LongDivision {
    /**
     * Demo code to show silent conversion and silent overflow.
     * @param args arguments
     */
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}
