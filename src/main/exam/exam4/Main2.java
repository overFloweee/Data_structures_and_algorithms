package exam4;

import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-09-14
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long res = method(a, b, c, x, y);
            System.out.println(res);
        }
    }

    public static long method(long a, long b, long c, long x, long y) {
        long set = 0;
        while (a > 0 && b > 0 && c > 0) {
            long min = Math.min(a, Math.min(b, c));
            set += min;

            a -= min;
            b -= min;
            c -= min;

            if (a < 0 || b < 0 || c < 0) {
                break;
            }

            long newBlueFromRed = a / x;
            b += newBlueFromRed;
            a -= newBlueFromRed * x;

            long newGreenFromBlue = b / y;
            c += newGreenFromBlue;
            b -= newGreenFromBlue * y;

            if (newBlueFromRed == 0 && newGreenFromBlue == 0) {
                break;
            }

        }

        return set;
    }
}


