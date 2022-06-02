package hw2;

/**
 * Homework 2 Check Digit.
 *
 * @author Xu Zheng
 * Andrew id: xuzheng
 */
public class CheckDigit {
    /**
     * main method.
     *
     * @param args first eleven digits
     */
    public static void main(String[] args) {
        long firstEleven = Long.parseLong(args[0]);
        long k = firstEleven % 10;
        firstEleven /= 10;
        long j = firstEleven % 10;
        firstEleven /= 10;
        long i = firstEleven % 10;
        firstEleven /= 10;
        long h = firstEleven % 10;
        firstEleven /= 10;
        long g = firstEleven % 10;
        firstEleven /= 10;
        long f = firstEleven % 10;
        firstEleven /= 10;
        long e = firstEleven % 10;
        firstEleven /= 10;
        long d = firstEleven % 10;
        firstEleven /= 10;
        long c = firstEleven % 10;
        firstEleven /= 10;
        long b = firstEleven % 10;
        firstEleven /= 10;
        long a = firstEleven % 10;
        long x = (10 - (3 * a + b + 3 * c + d + 3 * e + f + 3 * g + h + 3 * i + j + 3 * k) % 10) % 10;
        System.out.println(args[0]);
        System.out.println(x);
    }
}
