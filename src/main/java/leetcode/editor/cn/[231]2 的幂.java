// 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。
//
//
//
// 示例 1：
//
//
// 输入：n = 1
// 输出：true
// 解释：2⁰ = 1
//
//
// 示例 2：
//
//
// 输入：n = 16
// 输出：true
// 解释：2⁴ = 16
//
//
// 示例 3：
//
//
// 输入：n = 3
// 输出：false
//
//
// 示例 4：
//
//
// 输入：n = 4
// 输出：true
//
//
// 示例 5：
//
//
// 输入：n = 5
// 输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= n <= 2³¹ - 1
//
//
//
//
// 进阶：你能够不使用循环/递归解决此问题吗？
//
// Related Topics 位运算 递归 数学 👍 653 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    // 二分
    public boolean isPowerOfTwo(int n)
    {
        if (n == 1)
        {
            return true;
        }
        int p1 = 0, p2 = n - 1;
        while (p1 <= p2)
        {
            int m = (p1 + p2) >>> 1;
            if (Math.pow(2,m) > n)
            {
                p2 = m - 1;
            }
            else if (Math.pow(2,m) < n)
            {
                p1 = m + 1;

            }
            else
            {
                return true;
            }
        }
        return false;

    }
}
// leetcode submit region end(Prohibit modification and deletion)
