import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    int res = 0;

    // 回溯 - 初解
    public int findTargetSumWays1(int[] nums, int target) {
        backTracking(nums, target, 0, 0);
        return res;
    }
    public void backTracking(int[] nums, int target, int sum, int index) {
        if (sum == target && index == nums.length) {
            res++;
            return;
        }
        if (index >= nums.length) {
            return;
        }

        for (int j = -1; j <= 1; j += 2) {
            int cur = nums[index] * j;
            sum += cur;
            backTracking(nums, target, sum, index + 1);
            sum -= cur;
        }


    }

    // 动态规划 - 没解出来
    // 原因：找子数组组成总和为 x 的动态规划套路，只能找出有没有这种情况
    // 但是没想到怎么做统计
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int n = nums.length;
        int x = (sum + target) / 2;
        int[] dp = new int[x + 1];

        for (int i = 0; i <= x; ++i) {
            if (i >= nums[0]) {
                dp[i] = nums[0];
            }
        }

        int res = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = x; j >= 0; --j) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
                }
            }
            System.out.println(Arrays.toString(dp));

            if (dp[x] == target) {
                res++;
            }
        }

        return res;
    }
}
