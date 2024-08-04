class Solution {
    // 初解 - 动态规划
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; ++i) {
            int t1 = dp[i-2] + cost[i-2];
            int t2 = dp[i-1] + cost[i-1];

            dp[i] = Math.min(t1, t2);
        }

        return dp[n];
    }
}
