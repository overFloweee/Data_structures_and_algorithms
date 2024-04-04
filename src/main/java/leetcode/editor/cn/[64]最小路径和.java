// 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
// 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
// 输出：7
// 解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
// 输入：grid = [[1,2,3],[4,5,6]]
// 输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 200
//
//
// Related Topics 数组 动态规划 矩阵 👍 1657 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{

    // 初解 - 动态规划
    public int minPathSum1(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++)
        {
            if (i != 0)
            {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }

            for (int j = 1; j < col; j++)
            {
                if (i == 0)
                {
                    dp[0][j] = grid[0][j] + dp[0][j - 1];
                }
                else
                {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = min + grid[i][j];
                }
            }
        }

        return dp[row - 1][col - 1];

    }


    // 优化解
    public int minPathSum(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < row; i++)
        {
            dp[i][0] = grid[i][0] + dp[i - 1][0];

        }

        for (int j = 1; j < col; j++)
        {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }


        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++)
            {
                int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = min + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];

    }
}
// leetcode submit region end(Prohibit modification and deletion)
