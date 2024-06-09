// 给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返
// 回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
// 输入：target = 7, nums = [2,3,1,2,4,3]
// 输出：2
// 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
// 输入：target = 4, nums = [1,4,4]
// 输出：1
//
//
// 示例 3：
//
//
// 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
// 输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 10⁹
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2132 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 没注意到是连续子数组
    public int minSubArrayLen1(int target, int[] nums) {

        Arrays.sort(nums); // 1 2 2 3 3 4
        System.out.println(Arrays.toString(nums));

        int n = nums.length;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum >= target) {
                return n - i;
            }
        }
        return 0;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        int p1 = 0;
        int p2 = 0;
        int temp = 0;
        while (p2 < n)
        {
            temp += nums[p2];
            while (temp >= target)
            {
                min = Integer.min(min, p2 - p1 + 1);
                temp -= nums[p1];
                p1++;
            }
            p2++;

        }

        return Integer.MAX_VALUE == min ? 0 : min;

    }


    // 官解:妙解，需要深入学习
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Integer.min(min, right - left + 1);
                sum -= nums[left++]; // 缩小窗口左边界，减少窗口的和
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
// leetcode submit region end(Prohibit modification and deletion)
