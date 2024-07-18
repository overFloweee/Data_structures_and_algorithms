// 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
//
//
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
//
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
//
// 以这种方式修改数组后，返回数组 可能的最大和 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [4,2,3], k = 1
// 输出：5
// 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
//
//
// 示例 2：
//
//
// 输入：nums = [3,-1,0,2], k = 3
// 输出：6
// 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
//
//
// 示例 3：
//
//
// 输入：nums = [2,-3,-1,5,-4], k = 2
// 输出：13
// 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -100 <= nums[i] <= 100
// 1 <= k <= 10⁴
//
//
// Related Topics 贪心 数组 排序 👍 453 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解 - 存在问题
    public int largestSumAfterKNegations1(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num < 0 && k > 0) {
                nums[i] = -1 * num;
                k--;
            }
            else if (k % 2 != 0) {
                nums[i] = -1 * num;
                k--;
            }
            sum += nums[i];
        }
        return sum;
    }

    public int largestSumAfterKNegations2(int[] nums, int k) {
        // 排序，把可能有的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k还有盈余，就把负数反过来
            if (nums[i] < 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);

        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        if (k % 2 == 1) {
            sum -= 2 * nums[0];
        }
        return sum;
    }

    public int largestSumAfterKNegations(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        // nums = IntStream.of(nums)
        //         .boxed()
        //         .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
        //         .mapToInt(Integer::intValue).toArray();
        quickSort(nums, 0, nums.length - 1);

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (K % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);  // 递归排序左半部分
            quickSort(arr, pivotIndex + 1, high); // 递归排序右半部分
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准
        int i = (low - 1); // 指示比基准小的区域的最后一个元素的索引

        for (int j = low; j < high; j++) {
            // 如果当前元素的绝对值大于或等于基准的绝对值
            if (Math.abs(arr[j]) >= Math.abs(pivot)) {
                i++;
                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i+1] 和 arr[high]（即基准）
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 返回基准的索引位置
    }
}
// leetcode submit region end(Prohibit modification and deletion)
