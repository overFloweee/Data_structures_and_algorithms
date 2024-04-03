package practice;

import org.junit.Test;

public class L35_搜索插入位置
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 5, 5, 6, 7};
        int i = new L35_搜索插入位置().searchInsert(nums, 3);
        System.out.println(i);
    }

    // 基础版
    public int searchInsert(int[] nums, int target)
    {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j)
        {
            int m = (i + j) >>> 1;
            if (target < nums[m])
            {
                j = m - 1;
            }
            else if (nums[m] < target)
            {
                i = m + 1;
            }
            else
            {
                return m;
            }
        }

        return i;

    }

    // 平衡版
    public int searchInsert1(int[] nums, int target)
    {
        int i = 0;
        int j = nums.length;
        while (1 < j - i)  // 中间 无值的时候，即 [....,i,j.....]
        {
            int m = (i + j) >>> 1;
            if (target <= nums[m])
            {
                j = m;
            }
            else
            {
                i = m;
            }
        }


        // * 不是nums[i+1]
        // * 如果不存在该值，那就往右一个位置,即插入位置
        return nums[i] == target ? i : i + 1;
    }

    // leftmost 版本
    public int searchInsert2(int[] nums, int target)
    {
        int i = 0;
        int j = nums.length;
        while (i <= j)
        {
            int m = (i + j) >>> 1;
            if (target <= nums[m])
            {
                j = m - 1;
            }
            else
            {
                i = m + 1;
            }
        }
        return i;

    }


}
