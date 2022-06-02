package lecture6_methods_classes;

/**
 * Example code for lecture 6.
 * In-depth look at array and sort algorithm introduced in lecture 5
 * @author Jeffrey Eppinger & Terry Lee
 */
public class SortGrades {
    /**
     * A simple test program to sort int array.
     * @param args arguments
     */
    public static void main(String[] args) {
        int[] grades = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            grades[i] = Integer.parseInt(args[i]);
        }

        for (int i = 0; i < grades.length; i++) {
            for (int j = i + 1; j < grades.length; j++) {
                if (grades[j] < grades[i]) {
                    int temp = grades[i];
                    grades[i] = grades[j];
                    grades[j] = temp;
                }
            }
        }

        for (int i : grades) {
            System.out.println(i);
        }
    }
}
