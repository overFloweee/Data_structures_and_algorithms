// 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
//
// 不占用额外内存空间能否做到？
//
//
//
// 示例 1:
//
//
// 给定 matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
// 原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//
//
// 示例 2:
//
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
// 原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
//
//
// 注意：本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/
//
// Related Topics 数组 数学 矩阵 👍 293 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 使用辅助数组
    public void rotate0(int[][] matrix) {
        int n = matrix[0].length;

        int[][] newArr = new int[n][n];
        // 0,0 - 0,2
        // 0,2 - 2,2
        // 0,1 - 1,2
        // i,j - j,n-i-1
        // 1,0 - 0,1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newArr[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = newArr[i][j];
            }
        }
    }


    // 原地旋转 - 暂未实现
    public void rotate1(int[][] matrix) {
        int n = matrix[0].length;

        int[][] newArr = new int[n][n];
        // 0,0 - 0,2
        // 0,2 - 2,2
        // 0,1 - 1,2
        // i,j - j,n-i-1
        // 1,0 - 0,1
        for (int i = 0; i < n; i++) {
            int temp;
            for (int j = 0; j < n; j++) {
                newArr[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = newArr[i][j];
            }
        }
    }


    // 翻转代替旋转
    public void rotate(int[][] matrix) {
        // 先水平翻转（即上下翻转）
        // 再沿主对角线进行翻转
        int n = matrix[0].length;

        for (int i = 0; i < n / 2; i++) {
            int temp;
            for (int j = 0; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }


        // 沿着对角线翻转
        // 0,0 - 0,0
        // 0,1 - 1,0
        // 0,2 - 2,0
        // 1,2 - 2,1
        // i,j - j,i
        for (int i = 0; i < n; i++) {
            int temp;
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
// leetcode submit region end(Prohibit modification and deletion)
