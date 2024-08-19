package suixianglu;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();
        // int m = sc.nextInt();
        int m = 2;
        int n = 3;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int j = 0; j <= n; ++j) {
            for (int i = 0; i < m; ++i) {
                if (j >= i + 1) {
                    dp[j] += dp[j - i - 1];
                }
            }
        }

        System.out.println(dp[n]);

    }
}
