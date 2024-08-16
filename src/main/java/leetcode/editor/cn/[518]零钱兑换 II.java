// 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
//
// 假设每一种面额的硬币有无限个。
//
// 题目数据保证结果符合 32 位带符号整数。
//
//
//
//
//
//
// 示例 1：
//
//
// 输入：amount = 5, coins = [1, 2, 5]
// 输出：4
// 解释：有四种方式可以凑成总金额：
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
//
//
// 示例 2：
//
//
// 输入：amount = 3, coins = [2]
// 输出：0
// 解释：只用面额 2 的硬币不能凑成总金额 3 。
//
//
// 示例 3：
//
//
// 输入：amount = 10, coins = [10]
// 输出：1
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// coins 中的所有值 互不相同
// 0 <= amount <= 5000
//
//
// Related Topics 数组 动态规划 👍 1317 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change1(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // 初始化边界值
        for (int i = 0; i < n; i++) {
            // 第一列的初始值为1
            dp[i][0] = 1;
        }

        for (int i = 0; i <= amount; ++i) {
            if (i >= coins[0]) {
                dp[0][i] += dp[0][i - coins[0]];
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                if (j >= coins[i]) {
                    // 因为物品可以无限使用，所以每遍历 coins[i] 次为一轮
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][amount];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        // 初始化边界值
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                if (j >= coins[i]) {
                    // 因为物品可以无限使用，所以每遍历 coins[i] 次为一轮
                    dp[j] += +dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
