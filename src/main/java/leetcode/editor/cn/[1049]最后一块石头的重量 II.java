class Solution {
    public int lastStoneWeightII1(int[] stones) {
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int target = sum / 2;

        int n = stones.length;
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i <= target; i++) {
            if (stones[0] <= i) {
                dp[0][i] = stones[0];
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= target; ++j) {
                if (stones[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i] + dp[i - 1][j - stones[i]]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return (sum - dp[n - 1][target]) - dp[n - 1][target];
    }

    // 2 ms,击败了97.07% 的Java用户
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int target = sum / 2;

        int n = stones.length;
        int[] dp = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            if (stones[0] <= i) {
                dp[i] = stones[0];
            }
        }
        dp[0] = 0;

        for (int i = 1; i < n; ++i) {
            for (int j = target; j >= 0; --j) {
                if (stones[i] <= j) {
                    dp[j] = Math.max(dp[j], stones[i] + dp[j - stones[i]]);
                }
                else {
                    dp[j] = dp[j];
                }
            }
        }
        return (sum - dp[target]) - dp[target];

    }
}
