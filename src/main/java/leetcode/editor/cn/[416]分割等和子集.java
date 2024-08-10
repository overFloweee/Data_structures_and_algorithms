class Solution {
    // 动态规划 - 二维数组 - 整数版本
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i <= target; i++) {
            if (nums[0] <= i) {
                dp[0][i] = nums[0];
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= target; ++j) {
                if (nums[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], nums[i] + dp[i - 1][j - nums[i]]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            if (dp[i][target] == target) {
                return true;
            }
        }

        return false;
    }

    // 动态规划 - 一维数组 - 整数版本
    // 16 ms,击败了98.14% 的Java用户
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        int n = nums.length;
        int[] dp = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            if (nums[0] <= i) {
                dp[i] = nums[0];
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = target; j >= 0; --j) {
                if (nums[i] <= j) {
                    dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
                }
            }
            if (dp[target] == target) {
                return true;
            }
        }

        return false;
    }
}
