// 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
// 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,4,7,5,3,6,8,9]
//
//
// 示例 2：
//
//
// 输入：mat = [[1,2],[3,4]]
// 输出：[1,2,3,4]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 10⁴
// 1 <= m * n <= 10⁴
// -10⁵ <= mat[i][j] <= 10⁵
//
//
// Related Topics 数组 矩阵 模拟 👍 487 👎 0


import java.util.ArrayList;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int num = n * m;

        int[] arr = new int[m * n];
        int pos = 0;
        // 对角线有 m+n-1 条
        for (int i = 0; i < m + n - 1; i++) {
            // i为偶数，对角线往上
            if (i % 2 == 0) {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    arr[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
            // i为奇数，对角线往下
            else {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    arr[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }

            }
        }

        return arr;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
