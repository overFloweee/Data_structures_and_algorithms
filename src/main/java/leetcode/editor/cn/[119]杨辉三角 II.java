// 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
// 输入: rowIndex = 3
// 输出: [1,3,3,1]
//
//
// 示例 2:
//
//
// 输入: rowIndex = 0
// 输出: [1]
//
//
// 示例 3:
//
//
// 输入: rowIndex = 1
// 输出: [1,1]
//
//
//
//
// 提示:
//
//
// 0 <= rowIndex <= 33
//
//
//
//
// 进阶：
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
//
// Related Topics 数组 动态规划 👍 541 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 100%
    public List<Integer> getRow(int rowIndex) {

        Integer[] t = new Integer[rowIndex + 1];

        for (int i = 0; i <= rowIndex; ++i) {
            for (int j = i; j >= 0; --j) {
                if (j == i || j == 0) {
                    t[j] = 1;
                }
                else {
                    t[j] = t[j - 1] + t[j];
                }
            }
        }
        return Arrays.asList(t);
    }

}
// leetcode submit region end(Prohibit modification and deletion)
