package lecture9_swing_interfaces;

/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class ImmutableTest {

    /**
     * Simple program to show compare mutable and immutable objects.
     * @param args arguments
     */
    public static void main(String[] args) {
        String s = new String("TERRY");
        System.out.println(s);
        s.toLowerCase();
        System.out.println(s);
        
        StringBuilder sb = new StringBuilder("OBAMA");
        System.out.println(sb.toString());
        sb.reverse();
        System.out.println(sb.toString());
        
        java.util.Date d = new java.util.Date();
        System.out.println(d);
        d.setTime(1800000000000L);
        System.out.println(d);   
    }

}
