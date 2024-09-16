// 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//
//
//
// 示例 1：
//
//
// 输入：n = 12
// 输出：3
// 解释：12 = 4 + 4 + 4
//
// 示例 2：
//
//
// 输入：n = 13
// 输出：2
// 解释：13 = 4 + 9
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁴
//
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1950 👎 0


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 初解 - 未Accepted
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        new ArrayList<>().stream().collect(Collectors.toList());

        int late = 1;
        for (int i = 2; i <= n; i++) {

            int temp = i - late;

            if (isSquare(i)) {
                dp[i] = 1;
                set.add(i);

            }
            else if (set.contains(temp)) {
                dp[i] = 1 + dp[temp];

            }
            else {
                dp[i] = 1 + temp;
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];

    }

    public static boolean isSquare(int num) {
        double a = 0;
        try {
            a = Math.sqrt(num);
        }
        catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i] = i;
        }

        for (int i = 1; i * i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (j >= i * i) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n];
    }


}
// leetcode submit region end(Prohibit modification and deletion)
