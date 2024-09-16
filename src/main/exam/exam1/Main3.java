package exam1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-09-06
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();

        int[] days = new int[n];
        int[] fb = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            fb[i] = in.nextInt();
        }

        Arrays.sort(fb);
        long left = 0;
        long right = (long) n * (long) fb[n - 1];
        long res = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (method(days, fb, m, mid, n)) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(res);
    }


    public static boolean method(int[] days, int[] fb, long m, long mid, int n) {
        long total = 0;
        for (int i = 0; i < n && i < mid; i++) {
            long temp = 1;
            for (int j = n - 1; j >= n - i; j--) {
                temp *= fb[j];
                total += days[i] * temp;
                if (total > m) {
                    return true;
                }
            }
        }
        return false;
    }
}
