// 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
// 输入：nums = [-4,-1,0,3,10]
// 输出：[0,1,9,16,100]
// 解释：平方后，数组变为 [16,1,0,9,100]
// 排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
// 输入：nums = [-7,-3,2,3,11]
// 输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
//
// Related Topics 数组 双指针 排序 👍 992 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 初解
    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            nums[i] = num * num;
        }

        Arrays.sort(nums);
        return nums;
    }


    // 二刷
    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 优解
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int index = n - 1;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int lnum = nums[l] * nums[l];
            int rnum = nums[r] * nums[r];
            if (lnum >= rnum) {
                res[index--] = lnum;
                l++;
            }
            else {
                res[index--] = rnum;
                r--;
            }
        }

        return res;
    }


    public int[] sortedSquares3(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
