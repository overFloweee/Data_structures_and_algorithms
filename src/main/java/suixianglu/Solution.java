package suixianglu;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 9};
        int[] ints = new Solution().searchRange(arr, 8);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target + 1);

        return new int[]{left, right};
    }

    // 寻找最早出现的 target 值
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
