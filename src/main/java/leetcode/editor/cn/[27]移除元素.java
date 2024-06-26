// 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
//
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
// int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
// for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
//
//
//
// 示例 1：
//
//
// 输入：nums = [3,2,2,3], val = 3
// 输出：2, nums = [2,2]
// 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而
// nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
//
//
// 示例 2：
//
//
// 输入：nums = [0,1,2,2,3,0,4,2], val = 2
// 输出：5, nums = [0,1,3,0,4]
// 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
// 的元素。
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 50
// 0 <= val <= 100
//
//
// Related Topics 数组 双指针 👍 2216 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 初解，没解出来
    public int removeElement1(int[] nums, int val) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            if (nums[0] == val) {
                return 0;
            }
            else {
                return 1;
            }
        }
        int p1 = 0;
        int p2 = n - 1;

        int size = 0;
        while (p1 < p2) {
            while (nums[p1] != val && p1 < p2) {
                p1++;
                if (p1 == n - 1) {
                    return n;
                }
            }
            while (nums[p2] == val && p1 < p2) {
                p2--;
                size++;
                if (p2 == -1) {
                    return 0;
                }
            }


            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            size++;
        }

        // System.out.println(++size);
        System.out.println(Arrays.toString(nums));
        return nums.length - size;

    }

    // 官解1
    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

    // 官解2
    public int removeElement3(int[] nums, int val) {
        int n = nums.length;
        int p1 = 0;
        int p2 = n - 1;
        while (p1 <= p2) {
            if (nums[p1] == val) {
                nums[p1] = nums[p2--];
            }
            else {
                p1++;
            }
        }
        return p1;
    }


    // 二刷
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int n = nums.length;
        for (int r = 0; r < n; r++) {
            if (nums[r] != val) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }

}
// leetcode submit region end(Prohibit modification and deletion)
