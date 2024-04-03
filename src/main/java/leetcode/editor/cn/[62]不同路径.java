// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
// 输入：m = 3, n = 7
// 输出：28
//
// 示例 2：
//
//
// 输入：m = 3, n = 2
// 输出：3
// 解释：
// 从左上角开始，总共有 3 条路径可以到达右下角。
// 1. 向右 -> 向下 -> 向下
// 2. 向下 -> 向下 -> 向右
// 3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
// 输入：m = 7, n = 3
// 输出：28
//
//
// 示例 4：
//
//
// 输入：m = 3, n = 3
// 输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 10⁹
//
//
// Related Topics 数学 动态规划 组合数学 👍 2000 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    // 二维数组
    public int uniquePaths1(int m, int n)
    {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            arr[i][0] = 1;
            for (int j = 0; j < n; j++)
            {
                arr[0][j] = 1;
                if (i != 0 && j != 0)
                {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }

        return arr[m - 1][n - 1];
    }

    // 一维数组
    public int uniquePaths2(int m, int n)
    {
        int[] arr = new int[n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 || j == 0)
                {
                    arr[j] = 1;
                }
                else
                {
                    arr[j] = arr[j - 1] + arr[j];
                }
            }
        }

        return arr[n - 1];
    }


    public int uniquePaths(int m, int n)
    {
        int[][] arr = new int[m][];

        for (int i = 0; i < m; i++)
        {
            if (m == 0)
            {
                arr[0][m] = 1;
            }
            for (int j = 0; j < n; j++)
            {

            }
        }

    }
}
// leetcode submit region end(Prohibit modification and deletion)
