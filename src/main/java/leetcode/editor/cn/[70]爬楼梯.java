// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//
//
// 示例 1：
//
//
// 输入：n = 2
// 输出：2
// 解释：有两种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶
// 2. 2 阶
//
// 示例 2：
//
//
// 输入：n = 3
// 输出：3
// 解释：有三种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶 + 1 阶
// 2. 1 阶 + 2 阶
// 3. 2 阶 + 1 阶
//
//
//
//
// 提示：
//
//
// 1 <= n <= 45
//
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3459 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 2) + climbStairs(n - 1);
    }


    public int climbStairs(int n) {
        int p1 = 0;
        int p2 = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p1 = p2;
            p2 = r;
            r = p1 + p2;
        }

        return r;

    }

    // 二刷 - dp
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
