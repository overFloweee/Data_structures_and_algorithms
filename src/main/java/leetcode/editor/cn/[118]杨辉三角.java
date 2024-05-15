// 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
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
// 输入: numRows = 5
// 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
// 输入: numRows = 1
// 输出: [[1]]
//
//
//
//
// 提示:
//
//
// 1 <= numRows <= 30
//
//
// Related Topics 数组 动态规划 👍 1123 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        ArrayList<Integer> addList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                }
                else {
                    temp.add(addList.get(j - 1) + addList.get(j));
                }
            }
            addList = temp;
            list.add(temp);
        }

        return list;

    }


    // 100%
    public List<List<Integer>> generate(int numRows) {
        // 初始化动态规划数组
        Integer[][] dp = new Integer[numRows][];
        // 遍历每一行
        for (int i = 0; i < numRows; i++) {
            // 初始化当前行
            dp[i] = new Integer[i + 1];
            // 每一行的第一个和最后一个元素总是 1
            dp[i][0] = dp[i][i] = 1;
            // 计算中间元素
            for (int j = 1; j < i; j++) {
                // 中间元素等于上一行的相邻两个元素之和
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }

        }

        // 将动态规划数组转换为结果列表
        List<List<Integer>> result = new ArrayList<>();
        for (Integer[] row : dp) {
            result.add(Arrays.asList(row));
        }

        // 返回结果列表
        return result;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
