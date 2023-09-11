/** Class that prints the Collatz sequence starting from a given number.
 *  @author Qi Li
 */
public class Collatz {

    /**
     * Return the next number of positive integer number n
     * with Collatz sequence.
     * <p>
     * Collatz sequence:
     * <p>If n is even, the next number is n/2.
     * <p>If n is odd, the next number is 3*n+1.
     * <p>If n is 1, the sequence is over.
     */
    public static int nextNumber(int n) {
        if(n % 2 == 0) {
            return n / 2;
        } else if(n > 1) {
            return 3 * n + 1;
        } else {
            return n;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

