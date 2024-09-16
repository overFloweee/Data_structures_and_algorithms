package exam3;

import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-09-14
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        int min = Integer.MAX_VALUE;
        int a1 = 0;
        for (int i = 0; i < n - 1; i++) {
            a1 += arr[i];
            min = Math.min(min, sum * a1 - a1 * a1);
        }

        System.out.println(min);
    }
}
