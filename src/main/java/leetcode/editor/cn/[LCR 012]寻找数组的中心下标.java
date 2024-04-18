// 给你一个整数数组 nums ，请计算数组的 中心下标 。
//
// 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
//
// 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
//
// 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,7,3,6,5,6]
// 输出：3
// 解释：
// 中心下标是 3 。
// 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
// 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
//
//
// 示例 2：
//
//
// 输入：nums = [1, 2, 3]
// 输出：-1
// 解释：
// 数组中不存在满足此条件的中心下标。
//
// 示例 3：
//
//
// 输入：nums = [2, 1, -1]
// 输出：0
// 解释：
// 中心下标是 0 。
// 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
// 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -1000 <= nums[i] <= 1000
//
//
//
//
//
// 注意：本题与主站 724 题相同： https://leetcode-cn.com/problems/find-pivot-index/
//
// Related Topics 数组 前缀和 👍 74 👎 0


import java.util.concurrent.atomic.AtomicInteger;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    // 初解，解不出来
    public int pivotIndex1(int[] nums)
    {
        int p1 = 0, p2 = nums.length - 1;
        int left = nums[p1++], right = nums[p2--];
        while (p1 <= p2)
        {
            if (left > right)
            {
                right += nums[p2];
                p2--;
            }
            else if (left < right)
            {
                left += nums[p1];
                p1++;
            }
            else
            {
                return p1;
            }
        }


        return -1;

    }

    // 解不出来
    public int pivotIndex2(int[] nums)
    {
        int p1 = 0, p2 = nums.length - 1;
        int left = 0, right = 0;
        while (p1 <= p2)
        {
            int ltemp = nums[p1];
            int rtemp = nums[p2];
            if (left + ltemp > right + rtemp)
            {
                right += rtemp;
                p2--;
            }
            else if (left + ltemp < right + rtemp)
            {
                left += ltemp;
                p1++;
            }
            else
            {
                if (p1 + 1 == p2)
                {
                    return -1;
                }
                else if (p1 == p2)
                {
                    return 0;
                }
                else
                {
                    p1++;
                    return p1;
                }
            }
        }


        return -1;

    }


    public int pivotIndex(int[] nums)
    {
        int lsum = 0; // 左侧和
        int rsum = Arrays.stream(nums).sum(); // 右侧和，初始化为整个数组的和

        for (int i = 0; i < nums.length; i++)
        {
            rsum -= nums[i]; // 减去当前元素作为新的右侧和
            if (lsum == rsum)
            {
                return i; // 如果左右和相等，则返回当前索引
            }
            lsum += nums[i]; // 加上当前元素作为新的左侧和
        }
        return -1; // 如果没有找到符合条件的索引，则返回-1
    }
}
// leetcode submit region end(Prohibit modification and deletion)
