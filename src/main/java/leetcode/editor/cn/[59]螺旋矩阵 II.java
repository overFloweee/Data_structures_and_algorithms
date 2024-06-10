// 给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
// 输入：n = 3
// 输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
// 输入：n = 1
// 输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
//
// Related Topics 数组 矩阵 模拟 👍 1288 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix1(int n) {
        int i = 1;
        int[][] arr = new int[n][n];
        int flag = 0;

        int p1 = 0, p2 = 0;
        int num = n;
        while (i <= n * n) {
            // 右
            while (flag == 0 && i <= n * n) {
                arr[p1][p2] = i;
                if (p2 == num - 1) {
                    flag = 1;
                    break;
                }
                i++;
                p2++;
            }

            // 下
            while (flag == 1 && i <= n * n) {
                arr[p1][p2] = i;
                if (p1 == num - 1) {
                    flag = 2;
                    break;
                }
                i++;
                p1++;
            }

            // 左
            while (flag == 2 && i <= n * n) {
                arr[p1][p2] = i;
                if (p2 == n - num) {
                    flag = 3;
                    num--;
                    break;
                }
                i++;
                p2--;
            }

            // 上
            while (flag == 3 && i <= n * n) {
                arr[p1][p2] = i;
                if (p1 == n - num) {
                    flag = 0;
                    break;
                }
                i++;
                p1--;
            }
        }

        return arr;

    }

    public int[][] generateMatrix(int n) {
        int i = 1;
        int[][] arr = new int[n][n];

        int p1 = 0, p2 = 0;
        int num = n;
        while (i <= n * n) {
            // 右
            while (i <= n * n) {
                arr[p1][p2] = i;
                if (p2 == num - 1) {
                    break;
                }
                i++;
                p2++;
            }

            // 下
            while (i <= n * n) {
                arr[p1][p2] = i;
                if (p1 == num - 1) {
                    break;
                }
                i++;
                p1++;
            }

            // 左
            while (i <= n * n) {
                arr[p1][p2] = i;
                if (p2 == n - num) {
                    num--;
                    break;
                }
                i++;
                p2--;
            }

            // 上
            while (i <= n * n) {
                arr[p1][p2] = i;
                if (p1 == n - num) {
                    break;
                }
                i++;
                p1--;
            }
        }

        return arr;

    }
}
// leetcode submit region end(Prohibit modification and deletion)
