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

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> list = new ArrayList<>();

        ArrayList<Integer> addList = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++)
            {
                if (j == 0 || j == i)
                {
                    temp.add(1);
                }
                else
                {
                    temp.add(addList.get(j - 1) + addList.get(j));
                }
            }
            addList = temp;
            list.add(temp);
        }

        return list;

    }
}
// leetcode submit region end(Prohibit modification and deletion)
