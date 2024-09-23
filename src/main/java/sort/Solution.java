package sort;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        new Solution().findKthLargest(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 构成大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, n);
        }
        System.out.println(Arrays.toString(nums));


        // 排序
        for (int i = n - 1; i >= 0; i--) {
            // 大值放到最后
            swap(nums, 0, i);
            // 继续构成大顶堆
            adjustHeap(nums, 0, i);
        }
        return nums[n - k];
    }

    public void adjustHeap(int[] nums, int parent, int size) {
        while (true) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int max = parent;

            if (left < size && nums[left] > nums[max]) {
                max = left;
            }
            if (right < size && nums[right] > nums[max]) {
                max = right;
            }

            // 终止
            if (max == parent) {
                break;
            }

            swap(nums, parent, max);
            parent = max;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
