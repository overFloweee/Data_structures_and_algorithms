// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。
//
// 返回 滑动窗口中的最大值 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
// 输出：[3,3,5,5,6,7]
// 解释：
// 滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// 示例 2：
//
//
// 输入：nums = [1], k = 1
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
// 1 <= k <= nums.length
//
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2809 👎 0


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 初解 - 没解出来
    public int[] maxSlidingWindow1(int[] nums, int k) {

        int n = nums.length;
        int[] arr = new int[n - k + 1];
        int max = Integer.MIN_VALUE;

        int index = 0;
        for (int r = 0; r < k - 1; r++) {
            if (max < nums[r]) {
                max = nums[r];
            }
        }

        int l = 0;
        for (int r = l + k - 1; r < n; r++) {
            if (max < nums[r]) {
                max = nums[r];
            }
            arr[index++] = max;
            l++;
        }
        return arr;
    }

    // 优解
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n == 0 || k == 0) {
            return new int[0];
        }
        // 双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        for (int l = 1 - k, r = 0; r < n; l++, r++) {
            // 删除不在窗口范围的数
            if (l > 0 && deque.peekFirst() == nums[l - 1]) {
                deque.removeFirst();
            }
            // 保持deque递减
            while (!deque.isEmpty() && deque.peekLast() < nums[r]) {
                deque.removeLast();
            }
            deque.addLast(nums[r]);
            if (l >= 0) {
                res[l] = deque.peekFirst();
            }
        }
        return res;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
