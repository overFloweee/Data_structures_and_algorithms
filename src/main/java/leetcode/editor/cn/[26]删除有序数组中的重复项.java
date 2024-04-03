// 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持
// 一致 。然后返回 nums 中唯一元素的个数。
//
// 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
//
//
// 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不
// 重要。
// 返回 k 。
//
//
// 判题标准:
//
// 系统会用下面的代码来测试你的题解:
//
//
// int[] nums = [...]; // 输入数组
// int[] expectedNums = [...]; // 长度正确的期望答案
//
// int k = removeDuplicates(nums); // 调用
//
// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
//
// 如果所有断言都通过，那么您的题解将被 通过。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,1,2]
// 输出：2, nums = [1,2,_]
// 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
//
//
// 示例 2：
//
//
// 输入：nums = [0,0,1,1,1,2,2,3,3,4]
// 输出：5, nums = [0,1,2,3,4]
// 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非严格递增 排列
//
//
// Related Topics 数组 双指针 👍 3471 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    // 二解
    public int removeDuplicates(int[] nums)
    {
        if (nums.length == 1)
        {
            return 1;
        }
        int p1 = 0;
        int p2 = 1;
        int index = 1;
        while (true)
        {
            if (nums[p1] == nums[p2])
            {
                p2++;
            }
            else
            {
                nums[index] = nums[p2];
                index++;
                p1 = p2;
            }
            if (p2 >= nums.length)
            {
                break;
            }
        }

        return index;
    }

    // 初解
    public int removeDuplicates2(int[] nums)
    {
        int p1 = 0, p2 = 0;
        if (nums.length == 1)
        {
            return nums.length;
        }


        while (p2 < nums.length)
        {

            if (nums[p2] != nums[p2 + 1])
            {
                nums[p1] = nums[p2];
                p1++;

            }
            p2++;


            if (p2 == nums.length - 1)
            {
                nums[p1] = nums[p2];
                p1++;
                break;
            }

        }

        return p1;
    }

    // 优解
    public int removeDuplicates3(int[] nums)
    {
        int index = 0;
        for (int i = 1; i < nums.length; i++)
        {
            // 找到不重复的元素，赋值到数组的开头
            if (nums[i] != nums[index])
            {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
