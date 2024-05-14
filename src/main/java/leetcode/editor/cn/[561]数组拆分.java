// 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得
// 从 1 到 n 的 min(ai, bi) 总和最大。
//
// 返回该 最大总和 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,4,3,2]
// 输出：4
// 解释：所有可能的分法（忽略元素顺序）为：
// 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
// 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
// 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
// 所以最大总和为 4
//
// 示例 2：
//
//
// 输入：nums = [6,2,6,5,1,2]
// 输出：9
// 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 +
// 6 = 9
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁴
// nums.length == 2 * n
// -10⁴ <= nums[i] <= 10⁴
//
//
// Related Topics 贪心 数组 计数排序 排序 👍 366 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解，12ms 95%
    public int arrayPairSum1(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    // 计数排序？？
    public int arrayPairSum(int[] nums) {
        int[] ints = new int[20001];
        for (int num : nums) {
            ints[num + 10000]++;
        }
        int ans = 0;
        for (int i = 10000; i >= -10000; i--) {
            /**
             * i是值
             * ints[i+10000]是个数
             * 如果个数是偶数，直接除以2，再乘以i
             * 如果个数是奇数，个数减一之后，按偶数算，下一个个数+1（相当于把多余的一个的大数按比他小一的来算）
             */
            if ((ints[i + 10000] & 1) == 0) {
                ans += i * ints[i + 10000] / 2;
            }
            else {
                ans += i * (ints[i + 10000] - 1) / 2;
                if (i != -10000) {
                    ints[i + 10000 - 1]++;
                }
            }
        }
        return ans;
    }

}
// leetcode submit region end(Prohibit modification and deletion)
