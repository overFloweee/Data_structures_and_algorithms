package exam3;

import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-09-14
 */
public class Main2 {
    public static void main(String[] args) {

    }

    private static void method() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{in.nextInt(), in.nextInt()};
        }


        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t1 = Math.abs(arr[i][1] - arr[j][1]);
                int t2 = Math.abs(arr[i][0] - arr[j][0]);
                double sqrt = Math.sqrt(Math.abs(t1 * t1 - t2 * t2));
                max = Math.max(max, sqrt);
            }
        }

        System.out.println((int) Math.ceil(max / 2));
    }
}
