package demo;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        new Solution().numTrees(4);
    }

    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // dp[n] = dp[n-i] + dp[i]
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < n; ++j) {

                dp[i] += dp[n - 1 - j] * dp[j];
                System.out.println("i:" + i + " " + Arrays.toString(dp));

            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];

    }
}
