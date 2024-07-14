// 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
//
// 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
//
// 返回 你能获得的 最大 利润 。
//
//
//
// 示例 1：
//
//
// 输入：prices = [7,1,5,3,6,4]
// 输出：7
// 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
//     总利润为 4 + 3 = 7 。
//
// 示例 2：
//
//
// 输入：prices = [1,2,3,4,5]
// 输出：4
// 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//     总利润为 4 。
//
// 示例 3：
//
//
// 输入：prices = [7,6,4,3,1]
// 输出：0
// 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 3 * 10⁴
// 0 <= prices[i] <= 10⁴
//
//
// Related Topics 贪心 数组 动态规划 👍 2455 👎 0


import practice.L495_提莫攻击;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    // 第一次没解出来
    public int maxProfit0(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < prices.length; i++)
        {
            if (min > prices[i])
            {
                min = prices[i];
            }
            else
            {
                int temp = prices[i] - min;
                if (temp > max)
                {
                    max = temp;
                    if (i < prices.length - 2 && max > prices[i + 1] - min)
                    {
                        sum += max;
                        min = prices[i];
                        max = 0;
                    }
                }
            }

        }
        sum += max;
        return sum;
    }


    // 解法一：动态规划  -  二维数组
    public int maxProfit(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            // 寻找 第 i 天的最大利润
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }


    // 解法二：计算上升天数
    public int maxProfit2(int[] prices)
    {
        int sum = 0;

        for (int i = 0; i < prices.length - 1; i++)
        {
            int p1 = prices[i];
            int p2 = prices[i + 1];
            if (p1 < p2)
            {
                sum += p2 - p1;
            }
        }
        return sum;

    }

    // 解法三：贪心
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    // 贪心初解
    public int maxProfit(int[] prices) {

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (min > prices[i]) {
                min = prices[i];
            }
            else {
                if (i < prices.length - 1 && prices[i + 1] > prices[i]) {
                    continue;
                } else {
                    sum += prices[i] - min;
                    min = Integer.MAX_VALUE;
                }
            }
        }

        return sum;
    }





}
// leetcode submit region end(Prohibit modification and deletion)
