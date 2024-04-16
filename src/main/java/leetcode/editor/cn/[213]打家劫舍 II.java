// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
// 房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,3,2]
// 输出：3
// 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2：
//
//
// 输入：nums = [1,2,3,1]
// 输出：4
// 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 3：
//
//
// 输入：nums = [1,2,3]
// 输出：3
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000
//
//
// Related Topics 数组 动态规划 👍 1579 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    // 初解 - 动态规划 - 执行耗时:4 ms,击败了1.08% 的Java用户
    public int rob1(int[] nums)
    {
        int n = nums.length;

        if (n == 1)
        {
            return nums[0];
        }

        int[][] dp = new int[n][2];

        int max = 0;
        for (int i = 0; i < n; i++)
        {
            dp[i][0] = 0;
            dp[i][1] = nums[i];

            for (int j = (i + 1) % n, z = 1; z < n; z++)
            {
                if (j == 0)
                {
                    dp[j][0] = Integer.max(dp[n - 1][0], dp[n - 1][1]);
                    dp[j][1] = dp[n - 1][0] + nums[j];
                }
                else
                {
                    dp[j][0] = Integer.max(dp[j - 1][0], dp[j - 1][1]);
                    dp[j][1] = dp[j - 1][0] + nums[j];
                }
                j++;
                j = j % n;
            }

            int temp;
            if (i == 0)
            {
                temp = dp[n - 1][0];
            }
            else
            {
                temp = dp[i - 1][0];
            }
            max = Math.max(temp, max);
        }

        return max;

    }

    // 优化解法
    public int rob(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int i = 0; i < n; i++)
        {

        }

    }
}
// leetcode submit region end(Prohibit modification and deletion)
