// 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
//
// 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
//
//
//
// 示例 1：
//
// 输入：a = 12, b = 6
// 输出：4
// 解释：12 和 6 的公因子是 1、2、3、6 。
//
//
// 示例 2：
//
// 输入：a = 25, b = 30
// 输出：2
// 解释：25 和 30 的公因子是 1、5 。
//
//
//
// 提示：
//
//
// 1 <= a, b <= 1000
//
//
// Related Topics 数学 枚举 数论 👍 61 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    public int commonFactors(int a, int b)
    {
        int c = gcd(a, b), ans = 0;
        for (int x = 1; x * x <= c; ++x)
        {
            if (c % x == 0)
            {
                ++ans;
                if (x * x != c)
                {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b)
    {
        while (b != 0)
        {
            a %= b;
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return a;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
