package Lab1;

import java.util.Scanner;

/**
 * Created by andrew on 11.04.17.
 */
public class Lab1 {
    public static void main(String[] args) {
        int n, m;
        final int c = 2;
        boolean failed = false;
        double result = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter n: ");
            n = scanner.nextInt();
            if (n < 0 || n > 126) System.out.println("n must be 0 <= n <= 126");
        } while (n < 0 || n > 126);
        do {
            System.out.print("Enter m: ");
            m = scanner.nextInt();
            if (m < 0 || m > 126) System.out.println("m must be 0 <= m <= 126");
        } while (m < 0 || m > 126);

        for (byte i = 1; i <= n; i++) {
            for (byte j = 1; j <= m; j++) {
                if (i == c) {
                    failed = true;
                    System.out.println("Division by zero.");
                    break;
                } else result += (double) (i % j) / (i - c);
            }
            if (failed) break;
        }
        if (!failed) System.out.println("Result: " + result);
    }
}
