// 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
//
// F(0) = 0，F(1) = 1
// F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//
//
// 给定 n ，请计算 F(n) 。
//
//
//
// 示例 1：
//
//
// 输入：n = 2
// 输出：1
// 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
//
//
// 示例 2：
//
//
// 输入：n = 3
// 输出：2
// 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
//
//
// 示例 3：
//
//
// 输入：n = 4
// 输出：3
// 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 30
//
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 741 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }

        int p1 = 0;
        int p2 = 0;
        int r = 1;
        for (int i = 0; i < n - 1; i++) {
            p1 = p2;
            p2 = r;
            r = p1 + p2;
        }

        return r;
    }

    // 二刷
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int last = 0;
        int cur = 1;
        int next = 1;

        for (int i = 1; i < n; ++i) {
            next = last + cur;
            last = cur;
            cur = next;
        }

        return cur;

    }

    // 动态规划
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;


        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
