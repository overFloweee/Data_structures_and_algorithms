// 编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」 定义为：
//
//
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
// 如果这个过程 结果为 1，那么这个数就是快乐数。
//
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
//
//
//
// 示例 1：
//
//
// 输入：n = 19
// 输出：true
// 解释：
// 1² + 9² = 82
// 8² + 2² = 68
// 6² + 8² = 100
// 1² + 0² + 0² = 1
//
//
// 示例 2：
//
//
// 输入：n = 2
// 输出：false
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
//
// Related Topics 哈希表 数学 双指针 👍 1567 👎 0


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {

        int p1 = n;
        int p2 = n;
        if (getNext(p2) == 1)
        {
            return true;
        }

        while (p2 != 1)
        {
            p1 = getNext(p1);
            p2 = getNext(getNext(p2));

            if (p1 == p2)
            {
                return false;
            }
        }
        return true;
    }

    public static int getNext(int n) {
        int result = 0;
        while (n > 0) {
            int g = n % 10;
            result += g * g;
            n = n / 10;
        }
        return result;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
