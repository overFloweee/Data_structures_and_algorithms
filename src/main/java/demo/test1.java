package demo;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author qifei
 * @since 2024-04-11
 */
public class test1 {
    public static void main(String[] args) {
        // new test1().numSquares(13);
        new test1().change(5, new int[]{1, 2, 5});

    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        // 初始化边界值
        for (int i = 0; i < coins.length; i++) {
            // 第一列的初始值为1
            dp[i][0] = 1;
        }
        for (int j = coins[0]; j <= amount; j++) {
            // 初始化第一行
            dp[0][j] += dp[0][j - coins[0]];
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i][j - coins[i]] + dp[i - 1][j];
                }
            }
        }

        return dp[coins.length - 1][amount];
    }


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        HashSet<Integer> set = new HashSet<>();
        set.add(1);

        int late = 1;
        for (int i = 2; i <= n; i++) {

            int temp = i - late;

            if (isSquare(i)) {
                dp[i] = 1;
                late = i;
                set.add(i);
            }
            else if (set.contains(temp)) {
                dp[i] = 1 + dp[temp];

            }
            else {
                dp[i] = 1 + temp;
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];

    }

    public static boolean isSquare(int num) {
        double a;
        try {
            a = Math.sqrt(num);
        }
        catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }
}
