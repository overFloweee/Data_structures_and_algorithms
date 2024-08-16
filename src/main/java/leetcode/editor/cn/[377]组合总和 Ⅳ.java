class Solution {
    // 初解 做成了组合数了，没有关心顺序
    // 所以没解出来
    public int combinationSum4(int[] nums, int target) {
        // 完全背包，物品可以用多次
        // 求排列数，关心顺序
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; ++i) {
            dp[i][0] = 1;
        }

        for (int j = 0; j <= target; ++j) {
            if (j >= nums[0]) {
                dp[0][j] += dp[0][j - nums[0]];
            }
        }
        for (int j = 0; j <= target; ++j) {
            for (int i = 1; i < n; ++i) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[n - 1][target];
    }

    public int combinationSum42(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        // 别忘记初始化
        dp[0] = 1;
        for (int j = 0; j <= target; ++j) {
            for (int i = 0; i < n; ++i) {
                if (j >= nums[i]) {
                    // 因为物品可以无限使用，所以每遍历 coins[i] 次为一轮
                    dp[j] += +dp[j - nums[i]];
                }
            }
        }
        // for (int i = 0; i <= target; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i >= nums[j]) {
        //             dp[i] += dp[i - nums[j]];
        //         }
        //     }
        // }

        return dp[target];
    }
}
