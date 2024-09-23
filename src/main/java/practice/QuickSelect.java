package practice;

public class QuickSelect {

    // 用于找到数组中第k大的元素
    public static int findKthLargest(int[] nums, int k) {
        // 注意：题目要求的是第k大的元素，但我们的数组索引是从0开始的，所以转换为第n-k+1小的元素
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // 快速选择算法的递归实现
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            // 如果左右指针相遇，说明找到了第k小的元素
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        // pivotIndex 是分区后基准值（pivot）的正确位置（即pivot左边都是小于pivot的，右边都是大于pivot的）
        if (pivotIndex == k) {
            // 如果pivotIndex正好等于k，那么基准值就是我们要找的第k小的元素
            return nums[pivotIndex];
        }
        else if (pivotIndex < k) {
            // 如果pivotIndex小于k，说明第k小的元素在基准值的右边
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
        else {
            // 如果pivotIndex大于k，说明第k小的元素在基准值的左边
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    // 数组的分区操作
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; // 选择最右边的元素作为基准值
        int i = left - 1; // 小于基准值的元素的最后索引

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                // 交换nums[i]和nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // 交换nums[i+1]和nums[right]（即把基准值放到它最终的位置）
        int temp = nums[i + 1];
        nums[i + 1] = nums[right];
        nums[right] = temp;

        return i + 1; // 返回基准值的正确位置
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 8, 5, 7, 10};
        int k = 3;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + kthLargest);
    }
}
